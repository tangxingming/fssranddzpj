package com.youchu.fssranddzpj.service.fabriclistener;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric.sdk.identity.X509Enrollment;
import org.hyperledger.fabric.sdk.security.CryptoPrimitives;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Set;

public class FabricUser implements User {

    private String name;
    private String mspId;
    private Enrollment enrollment;
    private String keyFile;
    private String certFile;

    public FabricUser(String name, String mspId, String keyFile, String certFile) {
        this.name = name;
        this.mspId = mspId;
        this.keyFile=keyFile;
        this.certFile=certFile;

        try{
            enrollment=loadFromPemFile(keyFile, certFile);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private Enrollment loadFromPemFile(String keyFile,String certFile) throws Exception{
        byte[] keyPem = Files.readAllBytes(Paths.get(keyFile));     //load private key text
        byte[] certPem = Files.readAllBytes(Paths.get(certFile));   //load certificate text
        CryptoPrimitives suite = new CryptoPrimitives();            //load the cryptography suite
        PrivateKey privateKey = suite.bytesToPrivateKey(keyPem);    //convert private key text to object
        return new X509Enrollment(privateKey,new String(certPem));  //create X509Enrollment object
    }

    public String getName() {
        return name;
    }

    public String getMspId() {
        return mspId;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public String getAccount() {
        return null;
    }

    public String getAffiliation() {
        return null;
    }

    public Set<String> getRoles() {
        return null;
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public String getCertFile() {
        return certFile;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }


}
