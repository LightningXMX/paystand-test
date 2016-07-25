package com.cmcc.pay.paystand.test.util.biz;

/**
 * Created by mingxin on 16/7/25.
 */
public class ExcelFieldEnum {

    public static class CommonExcelFieldEnum {
        public static String version = "version";

        public static String transactionId = "transactionId";

        public static String transactionDate = "transactionDate";

        public static String originId = "originId";

        public static String digestAlg = "digestAlg";

        public static String verifyCode = "verifyCode";

        public static String expectedResults = "expectedResults";

        public static String desc = "desc";
    }

    public static class RefundExcelFieldEnum {

        public static String orderId = "orderId";

        public static String refundNotifyURL = "refundNotifyURL";

        public static String refundReason = "refundReason";


    }

    public static class ChangeSettlePeriodExcelFieldEnum {
        // TODO: 16/7/25  
        public static String id = "id";


    }
}
