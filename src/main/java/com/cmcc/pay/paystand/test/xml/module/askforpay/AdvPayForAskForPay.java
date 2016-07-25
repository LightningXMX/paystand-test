package com.cmcc.pay.paystand.test.xml.module.askforpay;

import com.cmcc.pay.paystand.test.util.InterfaceType;
import com.cmcc.pay.paystand.test.util.MD5Generator;
import com.cmcc.pay.paystand.test.xml.module.AdvPay;
import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;
import com.cmcc.pay.paystand.test.xml.module.BusiData;
import com.cmcc.pay.paystand.test.xml.module.PubInfo;
import com.cmcc.pay.paystand.test.xml.module.refund.AdvPayForRefund;
import com.cmcc.pay.paystand.test.xml.module.refund.RefundBusiData;
import com.cmcc.pay.paystand.test.xml.module.settleperiodchange.AdvPayForSettlePeriodChange;
import com.cmcc.pay.paystand.test.xml.module.settleperiodchange.SettlePeriodChangeBusiData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
@XmlRootElement(name = "AdvPay")

public class AdvPayForAskForPay {
    private PubInfo pubInfo;

    private AskForPayBusiData busiData;

    public PubInfo getPubInfo() {
        return pubInfo;
    }


    @XmlElement(name = "PubInfo")
    public void setPubInfo(PubInfo pubInfo) {
        this.pubInfo = pubInfo;
    }

    public AskForPayBusiData getBusiData() {
        return busiData;
    }

    @XmlElement(name = "BusiData")
    public void setBusiData(AskForPayBusiData busiData) {
        this.busiData = busiData;
    }

    public static AdvPayForAskForPay build(Map<String, String> input){
        PubInfo pubInfo = new PubInfo();
        pubInfo.setVersion(input.get(AdvPayEnum.Version));
        pubInfo.setTransactionId(input.get(AdvPayEnum.TransactionId));
        pubInfo.setTransactionDate(input.get(AdvPayEnum.TransactionDate));
        pubInfo.setOriginId(input.get(AdvPayEnum.OriginId));
        pubInfo.setDigestAlg(input.get(AdvPayEnum.DigestAlg));
        String finalVerifyCode = MD5Generator.sign(input, MD5Generator.MD5_KEY);
        pubInfo.setVerifyCode(finalVerifyCode);

//        AskForPayBusiData busiData = AskForPayBusiData.build(input);

        AdvPayForAskForPay advPayForAskForPay = new AdvPayForAskForPay();
        advPayForAskForPay.setPubInfo(pubInfo);
//        advPayForAskForPay.setBusiData(busiData);
        return advPayForAskForPay;

    }

}
