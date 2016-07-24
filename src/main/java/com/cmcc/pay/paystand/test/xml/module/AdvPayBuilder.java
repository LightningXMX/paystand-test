package com.cmcc.pay.paystand.test.xml.module;

import com.cmcc.pay.paystand.test.util.InterfaceType;
import com.cmcc.pay.paystand.test.util.MD5Generator;

import java.util.Map;

/**
 * Created by ech0 on 2016/3/15.
 */
public class AdvPayBuilder {

    public static AdvPay build(Map<String,String> input, InterfaceType interfaceType){

        AdvPay advPay = new AdvPay();
        PubInfo pubInfo = new PubInfo();
        pubInfo.setVersion(input.get(AdvPayEnum.Version));
        pubInfo.setTransactionId(input.get(AdvPayEnum.TransactionId));
        pubInfo.setTransactionDate(input.get(AdvPayEnum.TransactionDate));
        pubInfo.setOriginId(input.get(AdvPayEnum.OriginId));
        pubInfo.setDigestAlg(input.get(AdvPayEnum.DigestAlg));

//        String originalVerifyCode = input.get(AdvPayEnum.VerifyCode);
        String finalVerifyCode = MD5Generator.sign(input,MD5Generator.MD5_KEY);
        pubInfo.setVerifyCode(finalVerifyCode);

        BusiData busiData = null;
        if (InterfaceType.askfor.equals(interfaceType)){
            busiData = AskForBusiData.build(input);
        }else if (InterfaceType.refund.equals(interfaceType)){
            busiData = RefundBusiData.build(input);
        }else if (InterfaceType.settlePeriodChange.equals(interfaceType)){
            busiData = SettlePeriodChangeBusiData.build(input);
        }

        advPay.setPubInfo(pubInfo);
        advPay.setBusiData(busiData);


        return advPay;
    }



}