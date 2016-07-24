package com.cmcc.pay.paystand.test.testcase;

import com.cmcc.pay.paystand.test.util.AdvTestResponse;
import com.cmcc.pay.paystand.test.util.InterfaceType;
import com.cmcc.pay.paystand.test.util.TestBase;
import com.cmcc.pay.paystand.test.util.biz.AskForUtil;
import com.cmcc.pay.paystand.test.util.biz.RefundUtil;
import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
public class RefundTest extends TestBase{

    @DataProvider(name = "testData_Refund")
    public Object[][] testData_Refund() {
//testcase1
        Map testData_Version01 = RefundUtil.createDefaultInput();
        testData_Version01.put(AdvPayEnum.Version, "");

        List expectedResults_Version01 = createExpectedResult();
        expectedResults_Version01.add("9007");
        expectedResults_Version01.add("Version节点值为空");

        return new Object[][]{

                {testData_Version01, expectedResults_Version01, "yyy测试正常的测试数据"}
        };
    }

    @Test(dataProvider = "testData_Refund", groups = "Refund")
    public void askForPayTest(Map input, List<String> expectedResults, String desc) {
        AdvTestResponse response = test(input, InterfaceType.refund);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getReasonPhrase(), "OK");

        //循环断言返回结果是否包含预期字符串
        for (String expectedResult : expectedResults) {
            Assert.assertTrue(response.getContent().contains(expectedResult), desc);

        }

    }
}
