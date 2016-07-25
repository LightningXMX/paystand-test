package com.cmcc.pay.paystand.test.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ech0 on 2016/3/13.
 */
public class URLbuilder {

    public static String ASK_FOR_HOST = "";
    public static String REFUND_HOST = "";
    public static String SETTLE_PERIOD_CHANGE_HOST = "";
    public static String PORT = "";
    public static String ASK_FOR_PATH = "";
    public static String REFUND_PATH = "";
    public static String SETTLE_PERIOD_CHANGE_PATH = "";


    public static String buildRequestUrl(String xml,InterfaceType interfaceType) {


        String url = null;
        try {
            String encodedXML = URLEncoder.encode(xml, "UTF-8");

            if (InterfaceType.askForPay.equals(interfaceType)){
            url = "http://" + ASK_FOR_HOST + ":" + PORT + ASK_FOR_PATH + encodedXML;
            }else if (InterfaceType.refund.equals(interfaceType)){
                url = "http://" + REFUND_HOST + ":" + PORT + REFUND_PATH + encodedXML;
            }else if (InterfaceType.settlePeriodChange.equals(interfaceType)){
                url = "http://" + SETTLE_PERIOD_CHANGE_HOST + ":" + PORT + SETTLE_PERIOD_CHANGE_PATH + encodedXML;
            }

            System.out.println(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return url;
    }


}
