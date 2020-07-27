package com.youchu.fssranddzpj.service.fabriclistener;

import com.youchu.fssranddzpj.service.fabriclistener.event.MyBlockListener;
//import com.youchu.fssranddzpj.service.fabriclistener.event.MyChaincodeListener;

import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

import javax.json.JsonObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;


public class HLFCall {

    private HFClient client;
    private Channel channel;

    private static Configurations configurations;

    static {
        configurations = new Configurations();

    }

    private void init() throws Exception {

        client = HFClient.createNewInstance();

        //load parameters
        JsonObject options = configurations.loadConfigurations().getJsonObject("options");
        String keyDir = options.getString("privateKeyFolder");
        String keyFile = getKeyFilesInDir(new File(keyDir)).toString();
        String certFile = configurations.loadConfigurations().getJsonObject("options").getString("signedCert"); 
        String userName = configurations.loadConfigurations().getJsonObject("options").getString("user_id");
        String mspId = configurations.loadConfigurations().getJsonObject("options").getString("msp_id");
        String channelName = configurations.loadConfigurations().getJsonObject("options").getString("channel_id");
        String peerName = configurations.loadConfigurations().getJsonObject("options").getString("peer_server_hostname");
        String peerURL = configurations.loadConfigurations().getJsonObject("options").getString("peer_url");
        
        String keyDir2 = options.getString("privateKeyFolder2");
        String keyFile2 = getKeyFilesInDir(new File(keyDir2)).toString();
        String certFile2 = configurations.loadConfigurations().getJsonObject("options").getString("signedCert2");
        String userName2 = configurations.loadConfigurations().getJsonObject("options").getString("user_id2");
        String mspId2 = configurations.loadConfigurations().getJsonObject("options").getString("msp_id2");
        String peerName2 = configurations.loadConfigurations().getJsonObject("options").getString("peer_server_hostname2");
        String peerURL2 = configurations.loadConfigurations().getJsonObject("options").getString("peer_url2");
        
        String ordererName = configurations.loadConfigurations().getJsonObject("options").getString("orderer_server_hostname");
        String ordererURL = configurations.loadConfigurations().getJsonObject("options").getString("orderer_url");

        //create user object
        FabricUser user = new FabricUser(userName, mspId, keyFile, certFile);
        FabricUser user2 = new FabricUser(userName2, mspId2, keyFile2, certFile2);

        //encryption suite
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        client.setUserContext(user);
        client.setUserContext(user2);

        //create channel object
        channel = client.newChannel(channelName);

        //create peer
        String peerTLSCert = configurations.loadConfigurations().getJsonObject("options").getString("peer_tls_cacerts");
        Properties peer_properties = new Properties();
        peer_properties.put("pemBytes", Files.readAllBytes(Paths.get(peerTLSCert)));
        peer_properties.setProperty("sslProvider", "openSSL");
        peer_properties.setProperty("negotiationType", "TLS");
        Peer peer = client.newPeer(peerName, peerURL,peer_properties);
        channel.addPeer(peer);

        //create peer2
        String peerTLSCert2 = configurations.loadConfigurations().getJsonObject("options").getString("peer_tls_cacerts2");
        Properties peer_properties2 = new Properties();
        peer_properties2.put("pemBytes", Files.readAllBytes(Paths.get(peerTLSCert2)));
        peer_properties2.setProperty("sslProvider", "openSSL");
        peer_properties2.setProperty("negotiationType", "TLS");
        Peer peer2 = client.newPeer(peerName2, peerURL2,peer_properties2);
        channel.addPeer(peer2);

        //orderer
        String ordererTLSCert = configurations.loadConfigurations().getJsonObject("options").getString("orderer_tls_cacerts");
        Properties orderer_properties = new Properties();
        orderer_properties.put("pemBytes", Files.readAllBytes(Paths.get(ordererTLSCert)));
        orderer_properties.setProperty("sslProvider", "openSSL");
        orderer_properties.setProperty("negotiationType", "TLS");
        Orderer orderer = client.newOrderer(ordererName, ordererURL,orderer_properties);
        channel.addOrderer(orderer);

        //create EvenHub
       // EventHub eventHub = client.newEventHub(peerName, peerURL, peer_properties);
       // channel.addEventHub(eventHub);

        channel.registerBlockListener(new MyBlockListener(channel));


        //channel.registerChaincodeEventListener(Pattern.compile(".*"), Pattern.compile(".*"), new MyChaincodeListener(channel));

        //init channel
        channel.initialize();

    }


    /**
     * @description query
     * @params [client, configurations, channel]
     * @return  void
     * @author  adder
     * @date  2020/1/20 14:23
     *
     */
    public void queryByChaincode(ArrayList<String> argsList) throws Exception {

        init();

        String chaincodeName = configurations.loadConfigurations().getJsonObject("options").getString("chaincode_id");
        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chaincodeName).build();

        //build query request
        QueryByChaincodeRequest request = client.newQueryProposalRequest();
        request.setChaincodeID(chaincodeID);
        request.setFcn("query");
        request.setArgs(argsList);
        Collection<ProposalResponse> responses = channel.queryByChaincode(request);
        ProposalResponse response = (ProposalResponse) responses.toArray()[0];

        //analyse response
        System.out.println("Response code = "+response.getStatus().toString());
        if (response.getStatus().toString().equals("SUCCESS")){
            String result = new String(response.getChaincodeActionResponsePayload(), StandardCharsets.UTF_8);
            System.out.println("Response: "+result);
            System.out.println("Response message: "+response.getMessage());
        } else {
            String result = response.getMessage();
            System.out.println("Response: "+result);
        }
    }

    public void invokeByChaincode(ArrayList<String> argsList) throws Exception {

        init();

        String chaincodeName = configurations.loadConfigurations().getJsonObject("options").getString("chaincode_id");
        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chaincodeName).build();

        //build insert request
        TransactionProposalRequest request = client.newTransactionProposalRequest();
        request.setChaincodeLanguage(TransactionRequest.Type.GO_LANG);
        request.setChaincodeID(chaincodeID);
        request.setArgs(argsList);
        request.setFcn("invoke");
        request.setProposalWaitTime(3000);

        String endorsementPolicy = "src/main/resources/endorsementPolicy.yaml";
        ChaincodeEndorsementPolicy chaincodeEndorsementPolicy = new ChaincodeEndorsementPolicy();
        chaincodeEndorsementPolicy.fromYamlFile(new File(endorsementPolicy));
        request.setChaincodeEndorsementPolicy(chaincodeEndorsementPolicy);

        Collection<ProposalResponse> responses = channel.sendTransactionProposal(request);
        for (ProposalResponse response : responses) {
            if (response.getChaincodeActionResponseStatus()==200){
                System.out.println("Successfully sent Proposal and received ProposalResponse: status:"+response.getChaincodeActionResponseStatus()+",TransactionInformation: "+response.getProposalResponse().getResponse().getPayload().toStringUtf8());
            }
        }

        Channel.NOfEvents nOfEvents = Channel.NOfEvents.createNofEvents();
        if (!channel.getPeers(EnumSet.of(Peer.PeerRole.EVENT_SOURCE)).isEmpty()) {
            nOfEvents.addPeers(channel.getPeers(EnumSet.of(Peer.PeerRole.EVENT_SOURCE)));
        }
        if (!channel.getEventHubs().isEmpty()) {
            nOfEvents.addEventHubs(channel.getEventHubs());
        }

        CompletableFuture<BlockEvent.TransactionEvent> transactionEvent =  channel.sendTransaction(responses);
        BlockEvent.TransactionEvent event = transactionEvent.get();

        System.out.println("==== Transaction Event TransationID: "+event.getTransactionID());
        if (event.isValid()){
            System.out.println("  Transaction Event Successfully committed the change to the ledger by the peer "+event.getPeer());
            System.out.println("  Transaction Event Successfully committed the change to the ledger : "+event.getBlockEvent().getBlock());
        }

        //wait 10s
        new Thread() {
            public void run() {
                for (int i=0; i<10; i++) {
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();

    }

    public void registerChannelEventListener() throws Exception {
        init();

        new Thread() {
            public void run() {
                for (int i=0; i<100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }


    /**
     * @description get private key from key dir
     * @params [filePath]
     * @return  java.io.File
     * @author  adder
     * @date  2020/1/20 11:02
     *
     */
    private File getKeyFilesInDir(File filePath) {
        File keyFile = null;
        File[] listFiles = filePath.listFiles();
        if(listFiles != null) {
            for(File file:listFiles) {
                if(file.isFile()) {
                    if(file.getName().endsWith("_sk")) {
                        keyFile = file;
                        break;
                    }
                }
            }
        }
        return keyFile;
    }


}
