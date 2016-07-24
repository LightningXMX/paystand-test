package com.cmcc.pay.paystand.test.xml.module.settleperiodchange;

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

public class AdvPayForSettlePeriodChange {
    private PubInfo pubInfo;

    private SettlePeriodChangeBusiData busiData;

    public PubInfo getPubInfo() {
        return pubInfo;
    }


    @XmlElement(name = "PubInfo")
    public void setPubInfo(PubInfo pubInfo) {
        this.pubInfo = pubInfo;
    }

    public SettlePeriodChangeBusiData getBusiData() {
        return busiData;
    }

    @XmlElement(name = "BusiData")
    public void setBusiData(SettlePeriodChangeBusiData busiData) {
        this.busiData = busiData;
    }

    public static AdvPayForSettlePeriodChange build(Map<String, String> input){
        PubInfo pubInfo = new PubInfo();
        pubInfo.setVersion(input.get(AdvPayEnum.Version));
        pubInfo.setTransactionId(input.get(AdvPayEnum.TransactionId));
        pubInfo.setTransactionDate(input.get(AdvPayEnum.TransactionDate));
        pubInfo.setOriginId(input.get(AdvPayEnum.OriginId));
        pubInfo.setDigestAlg(input.get(AdvPayEnum.DigestAlg));
        String finalVerifyCode = MD5Generator.sign(input, MD5Generator.MD5_KEY);
        pubInfo.setVerifyCode(finalVerifyCode);

        SettlePeriodChangeBusiData busiData = SettlePeriodChangeBusiData.build(input);

        AdvPayForSettlePeriodChange advPayForSettlePeriodChange = new AdvPayForSettlePeriodChange();
        advPayForSettlePeriodChange.setPubInfo(pubInfo);
        advPayForSettlePeriodChange.setBusiData(busiData);
        return advPayForSettlePeriodChange;

    }
}
