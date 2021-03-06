package com.cmcc.pay.paystand.test.util;

import com.cmcc.pay.paystand.test.util.biz.ExcelInfo;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ech0 on 2016/3/17.
 */
@Component
public class CfgInit {

    public void init() {

        System.out.println("init");

        InputStream is = Object.class.getResourceAsStream("/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MD5Generator.MD5_KEY = (String) properties.get("MD5_KEY");
        URLbuilder.ASK_FOR_HOST = (String) properties.get("ASK_FOR_HOST");
        URLbuilder.REFUND_HOST = (String) properties.get("REFUND_HOST");
        URLbuilder.SETTLE_PERIOD_CHANGE_HOST = (String) properties.get("SETTLE_PERIOD_CHANGE_HOST");

        URLbuilder.PORT = (String) properties.get("PORT");

        URLbuilder.ASK_FOR_PATH = (String) properties.get("ASK_FOR_PATH");
        URLbuilder.REFUND_PATH = (String) properties.get("REFUND_PATH");
        URLbuilder.SETTLE_PERIOD_CHANGE_PATH = (String) properties.get("SETTLE_PERIOD_CHANGE_PATH");


        DBHelper.url = (String) properties.get("JDBC_URL");
        DBHelper.name = (String) properties.get("JDBC_NAME");
        DBHelper.user = (String) properties.get("JDBC_USER");
        DBHelper.password = (String) properties.get("JDBC_PASSWORD");


        ExcelInfo.ExcelFileName_AskForPay = "";
        ExcelInfo.ExcelFileName_Refund = "refund-testdata.xlsx";
        ExcelInfo.ExcelFileName_SettlePeriodChange = "";


        ExcelInfo.ExcelRefundSheetName = "refund";
        ExcelInfo.ExcelAskForPaySheetName = "askforpay";
        ExcelInfo.ExcelChangeSettlePeriodSheetName = "changesettleperiod";

    }
}
