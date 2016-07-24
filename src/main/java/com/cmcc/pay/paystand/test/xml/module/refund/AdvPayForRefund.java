package com.cmcc.pay.paystand.test.xml.module.refund;

import com.cmcc.pay.paystand.test.util.MD5Generator;
import com.cmcc.pay.paystand.test.xml.module.AdvPay;
import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;
import com.cmcc.pay.paystand.test.xml.module.BusiData;
import com.cmcc.pay.paystand.test.xml.module.PubInfo;
import com.cmcc.pay.paystand.test.xml.module.askforpay.AdvPayForAskForPay;
import com.cmcc.pay.paystand.test.xml.module.askforpay.AskForPayBusiData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
@XmlRootElement(name = "AdvPay")

public class AdvPayForRefund {
    private PubInfo pubInfo;

    private RefundBusiData busiData;

    public PubInfo getPubInfo() {
        return pubInfo;
    }


    @XmlElement(name = "PubInfo")
    public void setPubInfo(PubInfo pubInfo) {
        this.pubInfo = pubInfo;
    }

    public RefundBusiData getBusiData() {
        return busiData;
    }

    @XmlElement(name = "BusiData")
    public void setBusiData(RefundBusiData busiData) {
        this.busiData = busiData;
    }

    public static AdvPayForRefund build(Map<String, String> input){
        PubInfo pubInfo = new PubInfo();
        pubInfo.setVersion(input.get(AdvPayEnum.Version));
        pubInfo.setTransactionId(input.get(AdvPayEnum.TransactionId));
        pubInfo.setTransactionDate(input.get(AdvPayEnum.TransactionDate));
        pubInfo.setOriginId(input.get(AdvPayEnum.OriginId));
        pubInfo.setDigestAlg(input.get(AdvPayEnum.DigestAlg));
        String finalVerifyCode = MD5Generator.sign(input, MD5Generator.MD5_KEY);
        pubInfo.setVerifyCode(finalVerifyCode);

        RefundBusiData busiData = RefundBusiData.build(input);

        AdvPayForRefund advPayForRefund = new AdvPayForRefund();
        advPayForRefund.setPubInfo(pubInfo);
        advPayForRefund.setBusiData(busiData);
        return advPayForRefund;

    }
}
