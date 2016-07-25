package com.cmcc.pay.paystand.test.testcase;

import com.cmcc.pay.paystand.test.util.AdvTestResponse;
import com.cmcc.pay.paystand.test.util.InterfaceType;
import com.cmcc.pay.paystand.test.util.TestBase;
import com.cmcc.pay.paystand.test.util.biz.RefundUtil;
import com.cmcc.pay.paystand.test.xml.module.AdvPay;
import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;
import com.cmcc.pay.paystand.test.xml.module.refund.RefundTestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
public class RefundTest extends TestBase {

    @DataProvider(name = "testData_Refund")
    public Object[][] testData_Refund() {

        List<RefundTestData> refundTestDataList = getTestData(InterfaceType.refund);

        Object[][] allTestData = new Object[refundTestDataList.size()][3];

        for (int i = 0; i < refundTestDataList.size(); i++) {
            AdvPay advPay = refundTestDataList.get(i).getAdvPay();
            List<String> expectedResults = refundTestDataList.get(i).getExpectedResults();
            String desc = refundTestDataList.get(i).getDesc();

            Object[] testData = {advPay, expectedResults, desc};
            allTestData[i] = testData;
        }

        return allTestData;

    }

    @Test(dataProvider = "testData_Refund", groups = "Refund")
    public void refundTest(AdvPay advPay, List<String> expectedResults, String desc) {
        AdvTestResponse response = test(advPay, InterfaceType.refund);
//        AdvTestResponse response = test(input, InterfaceType.refund);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getReasonPhrase(), "OK");

        //循环断言返回结果是否包含预期字符串
        for (String expectedResult : expectedResults) {
            Assert.assertTrue(response.getContent().contains(expectedResult), desc);

        }

    }
}
