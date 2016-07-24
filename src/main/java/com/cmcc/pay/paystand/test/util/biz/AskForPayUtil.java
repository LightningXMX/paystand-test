package com.cmcc.pay.paystand.test.util.biz;

import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
public class AskForPayUtil {

    public static Map<String,String> createDefaultInput(){
        Map<String,String> defaultInput = new HashMap();

        defaultInput.put(AdvPayEnum.Version,"1.00");
        defaultInput.put(AdvPayEnum.TransactionId,"11335725725655");
        defaultInput.put(AdvPayEnum.TransactionDate,"20130815162325");
        defaultInput.put(AdvPayEnum.OriginId,"1000");
        defaultInput.put(AdvPayEnum.DigestAlg,"MD5");
        defaultInput.put(AdvPayEnum.VerifyCode,"245085b06819d930639a15f12fd4ba98");


        defaultInput.put(AdvPayEnum.AccountType,"1");
        defaultInput.put(AdvPayEnum.AccountCode,"18867103681");
        defaultInput.put(AdvPayEnum.PayInfo,"InterfaceTest_YYY0624");
        defaultInput.put(AdvPayEnum.OrderId,"InterfaceTest_663681");
        defaultInput.put(AdvPayEnum.MerchantId,"3");
        defaultInput.put(AdvPayEnum.ProductId,"32");
        defaultInput.put(AdvPayEnum.ProCount,"1");
        defaultInput.put(AdvPayEnum.PayAmount,"0.01");
        defaultInput.put(AdvPayEnum.PayPeriod,"1h");
        defaultInput.put(AdvPayEnum.PayNotifyIntURL,"http://www.qq.com");
        defaultInput.put(AdvPayEnum.PayNotifyPageURL,"http://www.baidu.com");
        defaultInput.put(AdvPayEnum.RoyaltyFlag,"0");
        defaultInput.put(AdvPayEnum.MerchantUrl,"http://www.qq.com");


        return defaultInput;
    }
}
