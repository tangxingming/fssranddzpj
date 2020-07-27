package com.youchu.fssranddzpj.service.fabriclistener;

import java.util.ArrayList;

public class TestHLF {

    public static void main(String[] args) throws Exception {
        testInvoke();
       // testQuery();
    }

    private static void testInvoke() throws Exception {
        //build args
        ArrayList<String> argsList = new ArrayList<>();
        argsList.add("b");
        argsList.add("a");
        argsList.add("10");

        HLFCall call = new HLFCall();
        call.invokeByChaincode(argsList);
    }

    private static void testQuery() throws Exception {
        //build args
        ArrayList<String> argsList = new ArrayList<>();
        argsList.add("b");

        HLFCall call = new HLFCall();
        call.queryByChaincode(argsList);
    }

}
