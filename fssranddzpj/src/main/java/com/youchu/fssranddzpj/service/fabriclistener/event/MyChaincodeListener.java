package com.youchu.fssranddzpj.service.fabriclistener.event;

import org.hyperledger.fabric.protos.common.Common;
import org.hyperledger.fabric.sdk.BlockEvent;
import org.hyperledger.fabric.sdk.BlockInfo;
import org.hyperledger.fabric.sdk.ChaincodeEvent;
import org.hyperledger.fabric.sdk.ChaincodeEventListener;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;

import java.io.UnsupportedEncodingException;


import static org.hyperledger.fabric.sdk.BlockInfo.EnvelopeType.TRANSACTION_ENVELOPE;

public class MyChaincodeListener implements ChaincodeEventListener {

    private final Channel channel;

    public MyChaincodeListener(final Channel channel) {
        this.channel = channel;
    }

    @Override
    public void received(String handle, BlockEvent blockEvent, ChaincodeEvent chaincodeEvent) {

        System.out.println("==== ChainCode Listener.. ======= start ");

        final Common.Block block = blockEvent.getBlock();

        System.out.println("BLock All FIelds :" + block.getAllFields());
        System.out.println("BLock HeaderOrBuilder :" + block.getHeaderOrBuilder());
        System.out.println("BLock Number :" + blockEvent.getBlockNumber());
        System.out.println("Peer :" + blockEvent.getPeer());
        System.out.println("FilteredBlock :" + blockEvent.getFilteredBlock());
        
        System.out.println("ChainCode Enent name :" + chaincodeEvent.getEventName());
        System.out.println("ChainCode Enent name :" + chaincodeEvent.getTxId());

        try {
            final long blockNumber = blockEvent.getBlockNumber();
            final BlockInfo returnedBlock = channel.queryBlockByNumber(blockNumber);

            System.out.println(
                    "current block number " + blockNumber + " has envelope count:" + returnedBlock.getEnvelopeCount());
            int i = 0;
            for (final BlockInfo.EnvelopeInfo envelopeInfo : returnedBlock.getEnvelopeInfos()) {
                ++i;
                System.out.println(
                        "  Transaction number " + i + " has transaction id: " + envelopeInfo.getTransactionID());

                if (envelopeInfo.getType() == TRANSACTION_ENVELOPE) {
                    final BlockInfo.TransactionEnvelopeInfo transactionEnvelopeInfo = (BlockInfo.TransactionEnvelopeInfo) envelopeInfo;

                    int j = 0;
                    for (final BlockInfo.TransactionEnvelopeInfo.TransactionActionInfo transactionActionInfo : transactionEnvelopeInfo
                            .getTransactionActionInfos()) {
                        ++j;
                        final int cac = transactionActionInfo.getChaincodeInputArgsCount();

                        System.out.println("   Transaction action has Endorsements:"
                                + transactionActionInfo.getEndorsementsCount());
                        System.out.println("   Transaction action has getProposalResponseMessageBytes:"
                                + new String(transactionActionInfo.getProposalResponseMessageBytes(), "UTF-8"));
                        System.out.println("   Transaction action has event:" + transactionActionInfo.getEvent());
                        System.out.println("   Transaction action has chaincode input arguments: " + cac);
                        for (int k = 0; k < cac; k++) {
                            System.out.println("     Transaction action argument" + k + "of" + cac + ":"
                                    + new String(transactionActionInfo.getChaincodeInputArgs(k), "UTF-8"));
                        }
                        System.out.println("   Transaction action " + j + " proposal response payload: "
                                + new String(transactionActionInfo.getProposalResponsePayload(), "UTF-8"));
                    }
                }
            }

        } catch (final InvalidArgumentException e) {
            e.printStackTrace();
        } catch (final ProposalException e) {
            e.printStackTrace();
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("==== ChainCode Listener.. ======= end ");

    }
}
