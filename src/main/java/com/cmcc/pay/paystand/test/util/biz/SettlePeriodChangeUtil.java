package com.cmcc.pay.paystand.test.util.biz;

import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
public class SettlePeriodChangeUtil {
    public static Map<String,String> createDefaultInput(){
        Map<String,String> defaultInput = new HashMap();

        defaultInput.put(AdvPayEnum.Version,"1.00");
        defaultInput.put(AdvPayEnum.TransactionId,"11335725725655");
        defaultInput.put(AdvPayEnum.TransactionDate,"20130815162325");
        defaultInput.put(AdvPayEnum.OriginId,"1000");
        defaultInput.put(AdvPayEnum.DigestAlg,"MD5");
        defaultInput.put(AdvPayEnum.VerifyCode,"245085b06819d930639a15f12fd4ba98");


        defaultInput.put(AdvPayEnum.OrderId,"OP2016070311321757103");
        defaultInput.put(AdvPayEnum.SettlePeriod,"DefaultSettlePeriod");

        return defaultInput;
    }
}
