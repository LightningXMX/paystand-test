package com.cmcc.pay.paystand.test.testcase;

import com.cmcc.pay.paystand.test.util.AdvTestResponse;
import com.cmcc.pay.paystand.test.util.InterfaceType;
import com.cmcc.pay.paystand.test.util.TestBase;
import com.cmcc.pay.paystand.test.util.DBHelper;
import com.cmcc.pay.paystand.test.util.biz.AskForPayUtil;
import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by ech0 on 2016/3/13.
 */
public class AskForPayTest extends TestBase {

    public static  String SQL  = null;
    public static  DBHelper DB1  = null;
    public static ResultSet ret = null;

    @DataProvider(name = "testData_AskForPay")
    public Object[][] testData_AskForPay() {

        // all parameters are default
        Map testData = AskForPayUtil.createDefaultInput();
        List expectedResults = createExpectedResult();
        expectedResults.add("收银台");
/**
 * Test Node:Version (Test Exception & boundary value)
 */
        //testcase1
        Map testData_Version01 = AskForPayUtil.createDefaultInput();
        testData_Version01.put(AdvPayEnum.Version, "");

        List expectedResults_Version01 = createExpectedResult();
        expectedResults_Version01.add("9007");
        expectedResults_Version01.add("Version节点值为空");

        //testcase2
        Map testData_Version02 = AskForPayUtil.createDefaultInput();
        testData_Version02.put(AdvPayEnum.Version, "1.0");

        List expectedResults_Version02 = createExpectedResult();
        expectedResults_Version02.add("9007");
        expectedResults_Version02.add("Version节点值错误，必须为1.00");

        //testcase3
        Map testData_Version03 = AskForPayUtil.createDefaultInput();
        testData_Version03.put(AdvPayEnum.Version, "1.000");

        List expectedResults_Version03 = createExpectedResult();
        expectedResults_Version03.add("9007");
        expectedResults_Version03.add("Version节点值错误，必须为1.00");

        //testcase4
        Map testData_Version04 = AskForPayUtil.createDefaultInput();
        testData_Version04.put(AdvPayEnum.Version, "2.00");

        List expectedResults_Version04 = createExpectedResult();
        expectedResults_Version04.add("9007");
        expectedResults_Version04.add("Version节点值错误，必须为1.00");
/**
 * Test Node: TransactionId (Test Exception & boundary value)
 */
        //testcase1
        Map testData_TransactionId01 = AskForPayUtil.createDefaultInput();
        testData_TransactionId01.put(AdvPayEnum.TransactionId, "");

        List expectedResults_TransactionId01 = createExpectedResult();
        expectedResults_TransactionId01.add("9007");
        expectedResults_TransactionId01.add("TransactionId节点值为空");

        //testcase2
        Map testData_TransactionId02 = AskForPayUtil.createDefaultInput();
        testData_TransactionId02.put(AdvPayEnum.TransactionId, "up123456789012345678901234567890");

        List expectedResults_TransactionId02 = createExpectedResult();
        expectedResults_TransactionId02.add("收银台");
        expectedResults_TransactionId02.add("确认支付");

        //testcase3
        Map testData_TransactionId03 = AskForPayUtil.createDefaultInput();
        testData_TransactionId03.put(AdvPayEnum.TransactionId, "up1234567890123456789012345678901");

        List expectedResults_TransactionId03 = createExpectedResult();
        expectedResults_TransactionId03.add("9007");
        expectedResults_TransactionId03.add("TransactionId节点值长度不能超过32字符");

        //testcase4
        Map testData_TransactionId04 = AskForPayUtil.createDefaultInput();
        testData_TransactionId04.put(AdvPayEnum.TransactionId, "123&678%0123￥01#67890_*");

        List expectedResults_TransactionId04 = createExpectedResult();
        expectedResults_TransactionId04.add("收银台");
        expectedResults_TransactionId04.add("确认支付");

        //testcase5
        Map testData_TransactionId05 = AskForPayUtil.createDefaultInput();
        testData_TransactionId05.put(AdvPayEnum.TransactionId, "aaaaaaaaaaaaaaaa");

        List expectedResults_TransactionId05 = createExpectedResult();
        expectedResults_TransactionId05.add("收银台");
        expectedResults_TransactionId05.add("确认支付");


/**
 * Test Node: TransactionDate (Test Exception & boundary value)
 */
        //testcase1
        Map testData_TransactionDate01 = AskForPayUtil.createDefaultInput();
        testData_TransactionDate01.put(AdvPayEnum.TransactionDate, "");

        List expectedResults_TransactionDate01 = createExpectedResult();
        expectedResults_TransactionDate01.add("9007");
        expectedResults_TransactionDate01.add("TransactionDate节点值为空");

        //testcase2
        Map testData_TransactionDate02 = AskForPayUtil.createDefaultInput();
        testData_TransactionDate02.put(AdvPayEnum.TransactionDate, "20160317103522");

        List expectedResults_TransactionDate02 = createExpectedResult();
        expectedResults_TransactionDate02.add("收银台");
        expectedResults_TransactionDate02.add("确认支付");

        //testcase3
        Map testData_TransactionDate03 = AskForPayUtil.createDefaultInput();
        testData_TransactionDate03.put(AdvPayEnum.TransactionDate, "2016031710352a");

        List expectedResults_TransactionDate03 = createExpectedResult();
        expectedResults_TransactionDate03.add("9007");
        expectedResults_TransactionDate03.add("TransactionDate节点值必须为YYYYMMddHHMMss时间格式");

        //testcase4
        Map testData_TransactionDate04 = AskForPayUtil.createDefaultInput();
        testData_TransactionDate04.put(AdvPayEnum.TransactionDate, "2016031710352");

        List expectedResults_TransactionDate04 = createExpectedResult();
        expectedResults_TransactionDate04.add("9007");
        expectedResults_TransactionDate04.add("TransactionDate节点值必须为YYYYMMddHHMMss时间格式");

        //testcase5
        Map testData_TransactionDate05 = AskForPayUtil.createDefaultInput();
        testData_TransactionDate05.put(AdvPayEnum.TransactionDate, "201603171035222");

        List expectedResults_TransactionDate05 = createExpectedResult();
        expectedResults_TransactionDate05.add("9007");
        expectedResults_TransactionDate05.add("TransactionDate节点值长度不能超过14字符");

        //testcase6
        Map testData_TransactionDate06 = AskForPayUtil.createDefaultInput();
        testData_TransactionDate06.put(AdvPayEnum.TransactionDate, "00000000000000");

        List expectedResults_TransactionDate06 = createExpectedResult();
        expectedResults_TransactionDate06.add("收银台");
        expectedResults_TransactionDate06.add("确认支付");
/**
 * Test Node: OriginId (Test Exception & boundary value)
 */

        //testcase1
        Map testData_OriginId01 = AskForPayUtil.createDefaultInput();
        testData_OriginId01.put(AdvPayEnum.OriginId, "");

        List expectedResults_OriginId01 = createExpectedResult();
        expectedResults_OriginId01.add("9007");
        expectedResults_OriginId01.add("OriginId节点值为空");

        //testcase2
        Map testData_OriginId02 = AskForPayUtil.createDefaultInput();
        testData_OriginId02.put(AdvPayEnum.OriginId, "1000");

        List expectedResults_OriginId02 = createExpectedResult();
        expectedResults_OriginId02.add("收银台");
        expectedResults_OriginId02.add("确认支付");

        //testcase3
        Map testData_OriginId03 = AskForPayUtil.createDefaultInput();
        testData_OriginId03.put(AdvPayEnum.OriginId, "14");

        List expectedResults_OriginId03 = createExpectedResult();
        expectedResults_OriginId03.add("9007");
        expectedResults_OriginId03.add("OriginId不存在");

        //testcase4
        Map testData_OriginId04 = AskForPayUtil.createDefaultInput();
        testData_OriginId04.put(AdvPayEnum.OriginId, "12345");

        List expectedResults_OriginId04 = createExpectedResult();
        expectedResults_OriginId04.add("9007");
        expectedResults_OriginId04.add("OriginId节点值长度不能超过4字符");

/**
 * Test Node: DigestAlg (Test Exception & boundary value)
 */

        //testcase1
        Map testData_DigestAlg01 = AskForPayUtil.createDefaultInput();
        testData_DigestAlg01.put(AdvPayEnum.DigestAlg, "");

        List expectedResults_DigestAlg01 = createExpectedResult();
        expectedResults_DigestAlg01.add("9007");
        expectedResults_DigestAlg01.add("Digestalg节点值为空");

        //testcase2
        Map testData_DigestAlg02 = AskForPayUtil.createDefaultInput();
        testData_DigestAlg02.put(AdvPayEnum.DigestAlg, "MD5");

        List expectedResults_DigestAlg02 = createExpectedResult();
        expectedResults_DigestAlg02.add("收银台");
        expectedResults_DigestAlg02.add("确认支付");

        //testcase3
        Map testData_DigestAlg03 = AskForPayUtil.createDefaultInput();
        testData_DigestAlg03.put(AdvPayEnum.DigestAlg, "RSA");

        List expectedResults_DigestAlg03 = createExpectedResult();
        expectedResults_DigestAlg03.add("收银台");
        expectedResults_DigestAlg03.add("确认支付");

        //testcase4
        Map testData_DigestAlg04 = AskForPayUtil.createDefaultInput();
        testData_DigestAlg04.put(AdvPayEnum.DigestAlg, "123");

        List expectedResults_DigestAlg04 = createExpectedResult();
        expectedResults_DigestAlg04.add("9007");
        expectedResults_DigestAlg04.add("Digestalg节点值错误,必须为MD5或RSA");


/**
 * Test Node: AccountType & AccountCode (Test Exception & boundary value)
 */

        //testcase1
        Map testData_AccountType01 = AskForPayUtil.createDefaultInput();
        testData_AccountType01.put(AdvPayEnum.AccountType, "");

        List expectedResults_AccountType01 = createExpectedResult();
        expectedResults_AccountType01.add("9007");
        expectedResults_AccountType01.add("AccountType节点值为空");

        //testcase2
        Map testData_AccountType02 = AskForPayUtil.createDefaultInput();
        testData_AccountType02.put(AdvPayEnum.AccountCode, "");

        List expectedResults_AccountType02 = createExpectedResult();
        expectedResults_AccountType02.add("9007");
        expectedResults_AccountType02.add("AccountCode节点值为空");


        //testcase3
        Map testData_AccountType03 = AskForPayUtil.createDefaultInput();
        testData_AccountType03.put(AdvPayEnum.AccountType, "1");
        testData_AccountType03.put(AdvPayEnum.AccountCode, "123456789123");

        List expectedResults_AccountType03 = createExpectedResult();
        expectedResults_AccountType03.add("9007");
        expectedResults_AccountType03.add("ACCOUNTTYPE为1，AccountCode必须为正确的11位手机号码");

        //testcase4
        Map testData_AccountType04 = AskForPayUtil.createDefaultInput();
        testData_AccountType04.put(AdvPayEnum.AccountType, "1");
        testData_AccountType04.put(AdvPayEnum.AccountCode, "18867103681");

        List expectedResults_AccountType04 = createExpectedResult();
        expectedResults_AccountType04.add("收银台");
        expectedResults_AccountType04.add("确认支付");


        //testcase5  AccountType=2时候 AccountCode为128位
        Map testData_AccountType05 = AskForPayUtil.createDefaultInput();
        testData_AccountType05.put(AdvPayEnum.AccountType, "2");
        testData_AccountType05.put(AdvPayEnum.AccountCode, "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");

        List expectedResults_AccountType05 = createExpectedResult();
        expectedResults_AccountType05.add("收银台");
        expectedResults_AccountType05.add("确认支付");

        //testcase6  AccountType=2时候 AccountCode为129位
        Map testData_AccountType06 = AskForPayUtil.createDefaultInput();
        testData_AccountType06.put(AdvPayEnum.AccountType, "2");
        testData_AccountType06.put(AdvPayEnum.AccountCode, "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");

        List expectedResults_AccountType06 = createExpectedResult();
        expectedResults_AccountType06.add("9007");
        expectedResults_AccountType06.add("AccountCode节点值长度不能超过128字符");

        //testcase7  AccountType=3时候 AccountCode为11位手机号
        Map testData_AccountType07 = AskForPayUtil.createDefaultInput();
        testData_AccountType07.put(AdvPayEnum.AccountType, "3");
        testData_AccountType07.put(AdvPayEnum.AccountCode, "18867103681");

        List expectedResults_AccountType07 = createExpectedResult();
        expectedResults_AccountType07.add("9007");
        expectedResults_AccountType07.add("ACCOUNTTYPE为3，AccountCode必须为正确的email地址");


        //testcase8  AccountType=3时候 AccountCode为正确的邮箱
        Map testData_AccountType08 = AskForPayUtil.createDefaultInput();
        testData_AccountType08.put(AdvPayEnum.AccountType, "3");
        testData_AccountType08.put(AdvPayEnum.AccountCode, "echo_y@126.com");

        List expectedResults_AccountType08 = createExpectedResult();
        expectedResults_AccountType08.add("收银台");
        expectedResults_AccountType08.add("确认支付");


        //testcase9  AccountType=3时候 AccountCode为不带@符号的字符串不超过128位
        Map testData_AccountType09 = AskForPayUtil.createDefaultInput();
        testData_AccountType09.put(AdvPayEnum.AccountType, "3");
        testData_AccountType09.put(AdvPayEnum.AccountCode, "echo_y12126com");

        List expectedResults_AccountType09 = createExpectedResult();
        expectedResults_AccountType09.add("9007");
        expectedResults_AccountType09.add("AccountCode必须为正确的email地址");

        //testcase10  AccountType=3时候 AccountCode为带@符号的字符串且超过128位
        Map testData_AccountType10 = AskForPayUtil.createDefaultInput();
        testData_AccountType10.put(AdvPayEnum.AccountType, "3");
        testData_AccountType10.put(AdvPayEnum.AccountCode, "12345@789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");

        List expectedResults_AccountType10 = createExpectedResult();
        expectedResults_AccountType10.add("9007");
        expectedResults_AccountType10.add("AccountCode节点值长度不能超过128字符");

        //testcase11  AccountType=4
        Map testData_AccountType11 = AskForPayUtil.createDefaultInput();
        testData_AccountType11.put(AdvPayEnum.AccountType, "4");

        List expectedResults_AccountType11 = createExpectedResult();
        expectedResults_AccountType11.add("9007");
        expectedResults_AccountType11.add("AccountType节点值必须为1-3的数值");


        //testcase12  AccountType为字符类型
        Map testData_AccountType12 = AskForPayUtil.createDefaultInput();
        testData_AccountType12.put(AdvPayEnum.AccountType, "a");

        List expectedResults_AccountType12 = createExpectedResult();
        expectedResults_AccountType12.add("9007");
        expectedResults_AccountType12.add("AccountType节点值必须为1-3的数值");

        //testcase13  AccountType为特殊字符
        Map testData_AccountType13 = AskForPayUtil.createDefaultInput();
        testData_AccountType13.put(AdvPayEnum.AccountType, "&");

        List expectedResults_AccountType13 = createExpectedResult();
        expectedResults_AccountType13.add("9007");
        expectedResults_AccountType13.add("AccountType节点值必须为1-3的数值");

        //testcase14  AccountType为2位数字
        Map testData_AccountType14 = AskForPayUtil.createDefaultInput();
        testData_AccountType14.put(AdvPayEnum.AccountType, "12");

        List expectedResults_AccountType14 = createExpectedResult();
        expectedResults_AccountType14.add("9007");
        expectedResults_AccountType14.add("AccountType节点值必须为1-3的数值");

/**
* Test Node:  PayInfo (Test Exception & boundary value)
*/


        //testcase1
        Map testData_PayInfo01 = AskForPayUtil.createDefaultInput();
        testData_PayInfo01.put(AdvPayEnum.PayInfo, "");

        List expectedResults_PayInfo01 = createExpectedResult();
        expectedResults_PayInfo01.add("收银台");
        expectedResults_PayInfo01.add("确认支付");

        //testcase2 PayInfo为128位数字
        Map testData_PayInfo02 = AskForPayUtil.createDefaultInput();
        testData_PayInfo02.put(AdvPayEnum.PayInfo, "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");

        List expectedResults_PayInfo02 = createExpectedResult();
        expectedResults_PayInfo02.add("收银台");
        expectedResults_PayInfo02.add("确认支付");


        //testcase3 PayInfo为128位数字加字符
        Map testData_PayInfo03 = AskForPayUtil.createDefaultInput();
        testData_PayInfo03.put(AdvPayEnum.PayInfo, "123456789012aaa67890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");

        List expectedResults_PayInfo03 = createExpectedResult();
        expectedResults_PayInfo03.add("收银台");
        expectedResults_PayInfo03.add("确认支付");

        //testcase4 PayInfo为129位数字
        Map testData_PayInfo04 = AskForPayUtil.createDefaultInput();
        testData_PayInfo04.put(AdvPayEnum.PayInfo, "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");

        List expectedResults_PayInfo04 = createExpectedResult();
        expectedResults_PayInfo04.add("9007");
        expectedResults_PayInfo04.add("PayInfo长度不能超过128字符");

        //testcase5 PayInfo为含中文字符
        Map testData_PayInfo05 = AskForPayUtil.createDefaultInput();
        testData_PayInfo05.put(AdvPayEnum.PayInfo, "中文字符检测");

        List expectedResults_PayInfo05 = createExpectedResult();
        expectedResults_PayInfo05.add("收银台");
        expectedResults_PayInfo05.add("确认支付");

        //testcase6 PayInfo为128个中文字符
        Map testData_PayInfo06 = AskForPayUtil.createDefaultInput();
        testData_PayInfo06.put(AdvPayEnum.PayInfo, "中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心");

        List expectedResults_PayInfo06 = createExpectedResult();
        expectedResults_PayInfo06.add("收银台");
        expectedResults_PayInfo06.add("确认支付");

        //testcase7 PayInfo为超过128个中文字符
        Map testData_PayInfo07 = AskForPayUtil.createDefaultInput();
        testData_PayInfo07.put(AdvPayEnum.PayInfo, "中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃中文字符检测中心甘肃");

        List expectedResults_PayInfo07 = createExpectedResult();
        expectedResults_PayInfo07.add("9007");
        expectedResults_PayInfo07.add("PayInfo长度不能超过128字符");

        //testcase8 PayInfo为含有特殊字符
        Map testData_PayInfo08 = AskForPayUtil.createDefaultInput();
        testData_PayInfo08.put(AdvPayEnum.PayInfo, "&&&&！！！！@@@@@");

        List expectedResults_PayInfo08 = createExpectedResult();
        expectedResults_PayInfo08.add("收银台");
        expectedResults_PayInfo08.add("确认支付");


/**
* Test Node:  OrderId (Test Exception & boundary value)
*/

        //testcase1
        Map testData_OrderId01 = AskForPayUtil.createDefaultInput();
        testData_OrderId01.put(AdvPayEnum.OrderId, "");

        List expectedResults_OrderId01 = createExpectedResult();
        expectedResults_OrderId01.add("9007");
        expectedResults_OrderId01.add("OrderId节点值为空");

        //testcase2 OrderId为20位数字
        Map testData_OrderId02 = AskForPayUtil.createDefaultInput();
        testData_OrderId02.put(AdvPayEnum.OrderId, "12345678901234567890");

        List expectedResults_OrderId02 = createExpectedResult();
        expectedResults_OrderId02.add("收银台");
        expectedResults_OrderId02.add("确认支付");


        //testcase3 OrderId为20位数字加字符
        Map testData_OrderId03 = AskForPayUtil.createDefaultInput();
        testData_OrderId03.put(AdvPayEnum.OrderId, "op123456789012345678");

        List expectedResults_OrderId03 = createExpectedResult();
        expectedResults_OrderId03.add("收银台");
        expectedResults_OrderId03.add("确认支付");

        //testcase4 OrderId为超过20位数字加字符
        Map testData_OrderId04 = AskForPayUtil.createDefaultInput();
        testData_OrderId04.put(AdvPayEnum.OrderId, "op123456789012345678wq");

        List expectedResults_OrderId04 = createExpectedResult();
        expectedResults_OrderId04.add("9007");
        expectedResults_OrderId04.add("OrderId长度不能超过20字符");

        //testcase5 OrderId含有中文字符
        Map testData_OrderId05 = AskForPayUtil.createDefaultInput();
        testData_OrderId05.put(AdvPayEnum.OrderId, "op业务平台订单号");

        List expectedResults_OrderId05 = createExpectedResult();
        expectedResults_OrderId05.add("收银台");
        expectedResults_OrderId05.add("确认支付");


/**
 * Test Node:  MerchantId (Test Exception & boundary value)
 */
        //testcase1
        Map testData_MerchantId01 = AskForPayUtil.createDefaultInput();
        testData_MerchantId01.put(AdvPayEnum.MerchantId, "");

        List expectedResults_MerchantId01 = createExpectedResult();
        expectedResults_MerchantId01.add("9007");
        expectedResults_MerchantId01.add("MerchantId节点值为空");

        //testcase2 MerchantId为18位数字且在数据库中存在
        Map testData_MerchantId02 = AskForPayUtil.createDefaultInput();
        testData_MerchantId02.put(AdvPayEnum.MerchantId, "123456789012345678");

        List expectedResults_MerchantId02 = createExpectedResult();
        expectedResults_MerchantId02.add("收银台");
        expectedResults_MerchantId02.add("确认支付");


        //testcase3 MerchantId为19位数字
        Map testData_MerchantId03 = AskForPayUtil.createDefaultInput();
        testData_MerchantId03.put(AdvPayEnum.MerchantId, "1234567890123456789");

        List expectedResults_MerchantId03 = createExpectedResult();
        expectedResults_MerchantId03.add("9007");
        expectedResults_MerchantId03.add("MerchantId节点值不能超过18位数值");

        //testcase4 MerchantId包含字符
        Map testData_MerchantId04 = AskForPayUtil.createDefaultInput();
        testData_MerchantId04.put(AdvPayEnum.MerchantId, "123abc");

        List expectedResults_MerchantId04 = createExpectedResult();
        expectedResults_MerchantId04.add("9007");
        expectedResults_MerchantId04.add("MerchantId节点值必须为正整数");

        //testcase5 MerchantId含有中文字符
        Map testData_MerchantId05 = AskForPayUtil.createDefaultInput();
        testData_MerchantId05.put(AdvPayEnum.MerchantId, "op业务平台订单号");

        List expectedResults_MerchantId05 = createExpectedResult();
        expectedResults_MerchantId05.add("9007");
        expectedResults_MerchantId05.add("MerchantId节点值必须为正整数");

        //testcase6 MerchantId为18位以下的数字且数据库中存在
        Map testData_MerchantId06 = AskForPayUtil.createDefaultInput();
        testData_MerchantId06.put(AdvPayEnum.MerchantId, "3");

        List expectedResults_MerchantId06 = createExpectedResult();
        expectedResults_MerchantId06.add("收银台");
        expectedResults_MerchantId06.add("确认支付");

        //testcase7 MerchantId为18位以下的数字且数据库中不存在
        Map testData_MerchantId07 = AskForPayUtil.createDefaultInput();
        testData_MerchantId07.put(AdvPayEnum.MerchantId, "6432");

        List expectedResults_MerchantId07 = createExpectedResult();
        expectedResults_MerchantId07.add("9111");
        expectedResults_MerchantId07.add("产品ID错误或未配置");

/**
 * Test Node:  ProductId (Test Exception & boundary value)
 */
        //testcase1
        Map testData_ProductId01 = AskForPayUtil.createDefaultInput();
        testData_ProductId01.put(AdvPayEnum.ProductId, "");

        List expectedResults_ProductId01 = createExpectedResult();
        expectedResults_ProductId01.add("9007");
        expectedResults_ProductId01.add("ProductId节点值为空");

        //testcase2 ProductId为18位数字且在数据库中存在
        Map testData_ProductId02 = AskForPayUtil.createDefaultInput();
        testData_ProductId02.put(AdvPayEnum.ProductId, "123456789012345678");

        List expectedResults_ProductId02 = createExpectedResult();
        expectedResults_ProductId02.add("收银台");
        expectedResults_ProductId02.add("确认支付");


        //testcase3 ProductId为19位数字
        Map testData_ProductId03 = AskForPayUtil.createDefaultInput();
        testData_ProductId03.put(AdvPayEnum.ProductId, "1234567890123456789");

        List expectedResults_ProductId03 = createExpectedResult();
        expectedResults_ProductId03.add("9007");
        expectedResults_ProductId03.add("ProductId节点值不能超过18位数值");

        //testcase4 ProductId包含字符
        Map testData_ProductId04 = AskForPayUtil.createDefaultInput();
        testData_ProductId04.put(AdvPayEnum.ProductId, "123abc");

        List expectedResults_ProductId04 = createExpectedResult();
        expectedResults_ProductId04.add("9007");
        expectedResults_ProductId04.add("ProductId节点值必须为正整数");

        //testcase5 ProductId含有中文字符
        Map testData_ProductId05 = AskForPayUtil.createDefaultInput();
        testData_ProductId05.put(AdvPayEnum.ProductId, "op业务平台订单号");

        List expectedResults_ProductId05 = createExpectedResult();
        expectedResults_ProductId05.add("9007");
        expectedResults_ProductId05.add("ProductId节点值必须为正整数");

        //testcase6 ProductId为18位以下的数字且数据库中存在
        Map testData_ProductId06 = AskForPayUtil.createDefaultInput();
        testData_ProductId06.put(AdvPayEnum.ProductId, "32");

        List expectedResults_ProductId06 = createExpectedResult();
        expectedResults_ProductId06.add("收银台");
        expectedResults_ProductId06.add("确认支付");

        //testcase7 ProductId为18位以下的数字且数据库中不存在
        Map testData_ProductId07 = AskForPayUtil.createDefaultInput();
        testData_ProductId07.put(AdvPayEnum.ProductId, "7823");

        List expectedResults_ProductId07 = createExpectedResult();
        expectedResults_ProductId07.add("9111");
        expectedResults_ProductId07.add("产品ID错误或未配置");

/**
 * Test Node:  ProCount (Test Exception & boundary value)
 */
        //testcase1
        Map testData_ProCount01 = AskForPayUtil.createDefaultInput();
        testData_ProCount01.put(AdvPayEnum.ProCount, "");

        List expectedResults_ProCount01 = createExpectedResult();
        expectedResults_ProCount01.add("9007");
        expectedResults_ProCount01.add("ProCount节点值为空");

        //testcase2 ProCount为10位数字
        Map testData_ProCount02 = AskForPayUtil.createDefaultInput();
        testData_ProCount02.put(AdvPayEnum.ProCount, "1234567890");

        List expectedResults_ProCount02 = createExpectedResult();
        expectedResults_ProCount02.add("收银台");
        expectedResults_ProCount02.add("确认支付");


        //testcase3 ProCount为11位数字
        Map testData_ProCount03 = AskForPayUtil.createDefaultInput();
        testData_ProCount03.put(AdvPayEnum.ProCount, "12345678901");

        List expectedResults_ProCount03 = createExpectedResult();
        expectedResults_ProCount03.add("9007");
        expectedResults_ProCount03.add("ProCount长度不能超过10位字符");

        //testcase4 ProCount包含字符
        Map testData_ProCount04 = AskForPayUtil.createDefaultInput();
        testData_ProCount04.put(AdvPayEnum.ProCount, "123abc");

        List expectedResults_ProCount04 = createExpectedResult();
        expectedResults_ProCount04.add("9007");
        expectedResults_ProCount04.add("ProCount节点值必须为大于0的正整数");

        //testcase5 ProCount含有中文字符
        Map testData_ProCount05 = AskForPayUtil.createDefaultInput();
        testData_ProCount05.put(AdvPayEnum.ProCount, "op业务平台订单号");

        List expectedResults_ProCount05 = createExpectedResult();
        expectedResults_ProCount05.add("9007");
        expectedResults_ProCount05.add("ProCount节点值必须为大于0的正整数");

        //testcase6 ProCount数量为负值
        Map testData_ProCount06 = AskForPayUtil.createDefaultInput();
        testData_ProCount06.put(AdvPayEnum.ProCount, "-1");

        List expectedResults_ProCount06 = createExpectedResult();
        expectedResults_ProCount06.add("9007");
        expectedResults_ProCount06.add("ProCount节点值必须为大于0的正整数");


/**
 * Test Node:  PayAmount (Test Exception & boundary value)
 */
        //testcase1
        Map testData_PayAmount01 = AskForPayUtil.createDefaultInput();
        testData_PayAmount01.put(AdvPayEnum.PayAmount, "");

        List expectedResults_PayAmount01 = createExpectedResult();
        expectedResults_PayAmount01.add("9007");
        expectedResults_PayAmount01.add("PayAmount节点值为空");

        //testcase2 PayAmount为9位浮点数
        Map testData_PayAmount02 = AskForPayUtil.createDefaultInput();
        testData_PayAmount02.put(AdvPayEnum.PayAmount, "999999.99");

        List expectedResults_PayAmount02 = createExpectedResult();
        expectedResults_PayAmount02.add("收银台");
        expectedResults_PayAmount02.add("确认支付");


        //testcase3 PayAmount测试小数点后1位
        Map testData_PayAmount03 = AskForPayUtil.createDefaultInput();
        testData_PayAmount03.put(AdvPayEnum.PayAmount, "1.1");

        List expectedResults_PayAmount03 = createExpectedResult();
        expectedResults_PayAmount03.add("收银台");
        expectedResults_PayAmount03.add("确认支付");

        //testcase4 PayAmount测试小数点后3位
        Map testData_PayAmount04 = AskForPayUtil.createDefaultInput();
        testData_PayAmount04.put(AdvPayEnum.PayAmount, "1.111");

        List expectedResults_PayAmount04 = createExpectedResult();
        expectedResults_PayAmount04.add("9007");
        expectedResults_PayAmount04.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");

        //testcase5 PayAmount测试小数点后0位
        Map testData_PayAmount05 = AskForPayUtil.createDefaultInput();
        testData_PayAmount05.put(AdvPayEnum.PayAmount, "1.");

        List expectedResults_PayAmount05 = createExpectedResult();
        expectedResults_PayAmount05.add("9007");
        expectedResults_PayAmount05.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");

        //testcase6 PayAmount_6位且无小数点
        Map testData_PayAmount06 = AskForPayUtil.createDefaultInput();
        testData_PayAmount06.put(AdvPayEnum.PayAmount, "999999");

        List expectedResults_PayAmount06 = createExpectedResult();
        expectedResults_PayAmount06.add("收银台");
        expectedResults_PayAmount06.add("确认支付");

        //testcase7 PayAmount_7位且无小数点
        Map testData_PayAmount07 = AskForPayUtil.createDefaultInput();
        testData_PayAmount07.put(AdvPayEnum.PayAmount, "9999999");

        List expectedResults_PayAmount07 = createExpectedResult();
        expectedResults_PayAmount07.add("9007");
        expectedResults_PayAmount07.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");

        //testcase8 PayAmount含字符
        Map testData_PayAmount08 = AskForPayUtil.createDefaultInput();
        testData_PayAmount08.put(AdvPayEnum.PayAmount, "123a");

        List expectedResults_PayAmount08 = createExpectedResult();
        expectedResults_PayAmount08.add("9007");
        expectedResults_PayAmount08.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");

        //testcase9 PayAmount小数点在最前面
        Map testData_PayAmount09 = AskForPayUtil.createDefaultInput();
        testData_PayAmount09.put(AdvPayEnum.PayAmount, ".12");

        List expectedResults_PayAmount09 = createExpectedResult();
        expectedResults_PayAmount09.add("9007");
        expectedResults_PayAmount09.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");

        //testcase10 PayAmount是0.00
        Map testData_PayAmount10 = AskForPayUtil.createDefaultInput();
        testData_PayAmount10.put(AdvPayEnum.PayAmount, "0.00");

        List expectedResults_PayAmount10 = createExpectedResult();
        expectedResults_PayAmount10.add("9007");
        expectedResults_PayAmount10.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");

        //testcase11 PayAmount是1000000.999
        Map testData_PayAmount11 = AskForPayUtil.createDefaultInput();
        testData_PayAmount11.put(AdvPayEnum.PayAmount, "1000000.999");

        List expectedResults_PayAmount11 = createExpectedResult();
        expectedResults_PayAmount11.add("9007");
        expectedResults_PayAmount11.add("PayAmount节点值不是正确的金额，必须为大于0，且小数点前最多6位整数，小数点后最多保留两位的数值");


/**
 * Test Node:  PayPeriod (Test Exception & boundary value)
 */

        //testcase1
        Map testData_PayPeriod01 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod01.put(AdvPayEnum.PayPeriod, "");

        List expectedResults_PayPeriod01 = createExpectedResult();
        expectedResults_PayPeriod01.add("收银台");
        expectedResults_PayPeriod01.add("确认支付");

        //testcase2 PayPeriod以分为单位
        Map testData_PayPeriod02 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod02.put(AdvPayEnum.PayPeriod, "5m");

        List expectedResults_PayPeriod02 = createExpectedResult();
        expectedResults_PayPeriod02.add("收银台");
        expectedResults_PayPeriod02.add("确认支付");


        //testcase3 PayPeriod以小时为单位
        Map testData_PayPeriod03 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod03.put(AdvPayEnum.PayPeriod, "9h");

        List expectedResults_PayPeriod03 = createExpectedResult();
        expectedResults_PayPeriod03.add("收银台");
        expectedResults_PayPeriod03.add("确认支付");

        //testcase4 PayPeriod以天为单位
        Map testData_PayPeriod04 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod04.put(AdvPayEnum.PayPeriod, "2d");

        List expectedResults_PayPeriod04 = createExpectedResult();
        expectedResults_PayPeriod04.add("9007");
        expectedResults_PayPeriod04.add("PayPeriod参数集错误");

        //testcase5 PayPeriod右边界值
        Map testData_PayPeriod05 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod05.put(AdvPayEnum.PayPeriod, "15d");

        List expectedResults_PayPeriod05 = createExpectedResult();
        expectedResults_PayPeriod05.add("9007");
        expectedResults_PayPeriod05.add("PayPeriod参数集错误");

        //testcase6 PayPeriod左边界值
        Map testData_PayPeriod06 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod06.put(AdvPayEnum.PayPeriod, "1d");

        List expectedResults_PayPeriod06 = createExpectedResult();
        expectedResults_PayPeriod06.add("收银台");
        expectedResults_PayPeriod06.add("确认支付");

        //testcase7 PayPeriod为小时的右边界
        Map testData_PayPeriod07 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod07.put(AdvPayEnum.PayPeriod, "24h");

        List expectedResults_PayPeriod07 = createExpectedResult();
        expectedResults_PayPeriod07.add("收银台");
        expectedResults_PayPeriod07.add("确认支付");

        //testcase8 PayPeriod为小时的左边界
        Map testData_PayPeriod08 = AskForPayUtil.createDefaultInput();
        testData_PayPeriod08.put(AdvPayEnum.PayPeriod, "1h");

        List expectedResults_PayPeriod08 = createExpectedResult();
        expectedResults_PayPeriod08.add("收银台");
        expectedResults_PayPeriod08.add("确认支付");

        //testcase9 PayPeriod为分钟的左边界
        Map testData_PayPeriod09= AskForPayUtil.createDefaultInput();
        testData_PayPeriod09.put(AdvPayEnum.PayPeriod, "1m");

        List expectedResults_PayPeriod09 = createExpectedResult();
        expectedResults_PayPeriod09.add("收银台");
        expectedResults_PayPeriod09.add("确认支付");

        //testcase10 PayPeriod为分钟的右边界
        Map testData_PayPeriod10= AskForPayUtil.createDefaultInput();
        testData_PayPeriod10.put(AdvPayEnum.PayPeriod, "24h");

        List expectedResults_PayPeriod10 = createExpectedResult();
        expectedResults_PayPeriod10.add("收银台");
        expectedResults_PayPeriod10.add("确认支付");

        //testcase11 PayPeriod左边界分钟异常
        Map testData_PayPeriod11= AskForPayUtil.createDefaultInput();
        testData_PayPeriod11.put(AdvPayEnum.PayPeriod, "0m");

        List expectedResults_PayPeriod11 = createExpectedResult();
        expectedResults_PayPeriod11.add("9007");
        expectedResults_PayPeriod11.add("PayPeriod参数集错误");

        //testcase12 PayPeriod右边界分钟异常
        Map testData_PayPeriod12= AskForPayUtil.createDefaultInput();
        testData_PayPeriod12.put(AdvPayEnum.PayPeriod, "25h");

        List expectedResults_PayPeriod12 = createExpectedResult();
        expectedResults_PayPeriod12.add("9007");
        expectedResults_PayPeriod12.add("PayPeriod参数集错误");

        //testcase13 PayPeriod左边界小时异常
        Map testData_PayPeriod13= AskForPayUtil.createDefaultInput();
        testData_PayPeriod13.put(AdvPayEnum.PayPeriod, "0h");

        List expectedResults_PayPeriod13 = createExpectedResult();
        expectedResults_PayPeriod13.add("9007");
        expectedResults_PayPeriod13.add("PayPeriod参数集错误");

        //testcase14 PayPeriod右边界小时异常
        Map testData_PayPeriod14= AskForPayUtil.createDefaultInput();
        testData_PayPeriod14.put(AdvPayEnum.PayPeriod, "301h");

        List expectedResults_PayPeriod14 = createExpectedResult();
        expectedResults_PayPeriod14.add("9007");
        expectedResults_PayPeriod14.add("PayPeriod参数集错误");


        //testcase15 PayPeriod左边界天异常
        Map testData_PayPeriod15= AskForPayUtil.createDefaultInput();
        testData_PayPeriod15.put(AdvPayEnum.PayPeriod, "0d");

        List expectedResults_PayPeriod15 = createExpectedResult();
        expectedResults_PayPeriod15.add("9007");
        expectedResults_PayPeriod15.add("PayPeriod参数集错误");

        //testcase16 PayPeriod左边界天异常
        Map testData_PayPeriod16= AskForPayUtil.createDefaultInput();
        testData_PayPeriod16.put(AdvPayEnum.PayPeriod, "16d");

        List expectedResults_PayPeriod16 = createExpectedResult();
        expectedResults_PayPeriod16.add("9007");
        expectedResults_PayPeriod16.add("PayPeriod参数集错误");

        //testcase17 PayPeriod不符合格式的，全数字
        Map testData_PayPeriod17= AskForPayUtil.createDefaultInput();
        testData_PayPeriod17.put(AdvPayEnum.PayPeriod, "1234");

        List expectedResults_PayPeriod17 = createExpectedResult();
        expectedResults_PayPeriod17.add("9007");
        expectedResults_PayPeriod17.add("PayPeriod参数集错误");

        //testcase18 PayPeriod不符合格式的，超过4位
        Map testData_PayPeriod18= AskForPayUtil.createDefaultInput();
        testData_PayPeriod18.put(AdvPayEnum.PayPeriod, "1234m");

        List expectedResults_PayPeriod18 = createExpectedResult();
        expectedResults_PayPeriod18.add("9007");
        expectedResults_PayPeriod18.add("PayPeriod参数集错误");


/**
 * Test Node:  PayNotifyIntURL (Test Exception & boundary value)
 */
        //testcase1
        Map testData_PayNotifyIntURL01 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyIntURL01.put(AdvPayEnum.PayNotifyIntURL, "");

        List expectedResults_PayNotifyIntURL01 = createExpectedResult();
        expectedResults_PayNotifyIntURL01.add("收银台");
        expectedResults_PayNotifyIntURL01.add("确认支付");

        //testcase2 PayNotifyIntURL为256位
        Map testData_PayNotifyIntURL02 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyIntURL02.put(AdvPayEnum.PayNotifyIntURL, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456");

        List expectedResults_PayNotifyIntURL02 = createExpectedResult();
        expectedResults_PayNotifyIntURL02.add("收银台");
        expectedResults_PayNotifyIntURL02.add("确认支付");


        //testcase3 PayNotifyIntURL为257位
        Map testData_PayNotifyIntURL03 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyIntURL03.put(AdvPayEnum.PayNotifyIntURL, "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");

        List expectedResults_PayNotifyIntURL03 = createExpectedResult();
        expectedResults_PayNotifyIntURL03.add("9007");
        expectedResults_PayNotifyIntURL03.add("PayNotifyIntURL节点值长度不能超过256字符");

        //testcase4 PayNotifyIntURL为纯数字
        Map testData_PayNotifyIntURL04 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyIntURL04.put(AdvPayEnum.PayNotifyIntURL, "123");

        List expectedResults_PayNotifyIntURL04 = createExpectedResult();
        expectedResults_PayNotifyIntURL04.add("收银台");
        expectedResults_PayNotifyIntURL04.add("确认支付");

        //testcase5 PayNotifyIntURL全为字符
        Map testData_PayNotifyIntURL05 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyIntURL05.put(AdvPayEnum.PayNotifyIntURL, "thinking");

        List expectedResults_PayNotifyIntURL05 = createExpectedResult();
        expectedResults_PayNotifyIntURL05.add("收银台");
        expectedResults_PayNotifyIntURL05.add("确认支付");

        //testcase6 PayNotifyIntURL为256个中文字符
        Map testData_PayNotifyIntURL06 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyIntURL06.put(AdvPayEnum.PayNotifyIntURL, "测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测");

        List expectedResults_PayNotifyIntURL06 = createExpectedResult();
        expectedResults_PayNotifyIntURL06.add("收银台");
        expectedResults_PayNotifyIntURL06.add("确认支付");

/**
 * Test Node:  PayNotifyPageURL (Test Exception & boundary value)
 */
        //testcase1
        Map testData_PayNotifyPageURL01 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyPageURL01.put(AdvPayEnum.PayNotifyPageURL, "");

        List expectedResults_PayNotifyPageURL01 = createExpectedResult();
        expectedResults_PayNotifyPageURL01.add("收银台");
        expectedResults_PayNotifyPageURL01.add("确认支付");

        //testcase2 PayNotifyPageURL为256位
        Map testData_PayNotifyPageURL02 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyPageURL02.put(AdvPayEnum.PayNotifyPageURL, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456");

        List expectedResults_PayNotifyPageURL02 = createExpectedResult();
        expectedResults_PayNotifyPageURL02.add("收银台");
        expectedResults_PayNotifyPageURL02.add("确认支付");


        //testcase3 PayNotifyPageURL为257位
        Map testData_PayNotifyPageURL03 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyPageURL03.put(AdvPayEnum.PayNotifyPageURL, "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");

        List expectedResults_PayNotifyPageURL03 = createExpectedResult();
        expectedResults_PayNotifyPageURL03.add("9007");
        expectedResults_PayNotifyPageURL03.add("PayNotifyPageURL节点值长度不能超过256字符");

        //testcase4 PayNotifyPageURL为纯数字
        Map testData_PayNotifyPageURL04 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyPageURL04.put(AdvPayEnum.PayNotifyPageURL, "123");

        List expectedResults_PayNotifyPageURL04 = createExpectedResult();
        expectedResults_PayNotifyPageURL04.add("收银台");
        expectedResults_PayNotifyPageURL04.add("确认支付");

        //testcase5 PayNotifyPageURL全为字符
        Map testData_PayNotifyPageURL05 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyPageURL05.put(AdvPayEnum.PayNotifyPageURL, "thinking");

        List expectedResults_PayNotifyPageURL05 = createExpectedResult();
        expectedResults_PayNotifyPageURL05.add("收银台");
        expectedResults_PayNotifyPageURL05.add("确认支付");

        //testcase6 PayNotifyPageURL为256个中文字符
        Map testData_PayNotifyPageURL06 = AskForPayUtil.createDefaultInput();
        testData_PayNotifyPageURL06.put(AdvPayEnum.PayNotifyPageURL, "测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测");

        List expectedResults_PayNotifyPageURL06 = createExpectedResult();
        expectedResults_PayNotifyPageURL06.add("收银台");
        expectedResults_PayNotifyPageURL06.add("确认支付");

/**
 * Test Node:  RoyaltyFlag (Test Exception & boundary value)
 */


        //testcase1
        Map testData_RoyaltyFlag01 = AskForPayUtil.createDefaultInput();
        testData_RoyaltyFlag01.put(AdvPayEnum.RoyaltyFlag, "");

        List expectedResults_RoyaltyFlag01 = createExpectedResult();
        expectedResults_RoyaltyFlag01.add("收银台");
        expectedResults_RoyaltyFlag01.add("确认支付");

        //testcase2 RoyaltyFlag为1
        Map testData_RoyaltyFlag02 = AskForPayUtil.createDefaultInput();
        testData_RoyaltyFlag02.put(AdvPayEnum.RoyaltyFlag, "1");

        List expectedResults_RoyaltyFlag02 = createExpectedResult();
        expectedResults_RoyaltyFlag02.add("9007");
        expectedResults_RoyaltyFlag02.add("RoyaltyFlag节点值必须为0");


        //testcase3 RoyaltyFlag为2
        Map testData_RoyaltyFlag03 = AskForPayUtil.createDefaultInput();
        testData_RoyaltyFlag03.put(AdvPayEnum.RoyaltyFlag, "2");

        List expectedResults_RoyaltyFlag03 = createExpectedResult();
        expectedResults_RoyaltyFlag03.add("9007");
        expectedResults_RoyaltyFlag03.add("RoyaltyFlag节点值必须为0");

        //testcase4 RoyaltyFlag为2位数字
        Map testData_RoyaltyFlag04 = AskForPayUtil.createDefaultInput();
        testData_RoyaltyFlag04.put(AdvPayEnum.RoyaltyFlag, "12");

        List expectedResults_RoyaltyFlag04 = createExpectedResult();
        expectedResults_RoyaltyFlag04.add("9007");
        expectedResults_RoyaltyFlag04.add("RoyaltyFlag节点值必须为0");

        //testcase5 RoyaltyFlag为字母
        Map testData_RoyaltyFlag05 = AskForPayUtil.createDefaultInput();
        testData_RoyaltyFlag05.put(AdvPayEnum.RoyaltyFlag, "a");

        List expectedResults_RoyaltyFlag05 = createExpectedResult();
        expectedResults_RoyaltyFlag05.add("9007");
        expectedResults_RoyaltyFlag05.add("RoyaltyFlag节点值必须为0");


/**
 * Test Node:  MerchantUrl (Test Exception & boundary value)
 */
        //testcase1
        Map testData_MerchantUrl01 = AskForPayUtil.createDefaultInput();
        testData_MerchantUrl01.put(AdvPayEnum.MerchantUrl, "");

        List expectedResults_MerchantUrl01 = createExpectedResult();
        expectedResults_MerchantUrl01.add("收银台");
        expectedResults_MerchantUrl01.add("确认支付");

        //testcase2 MerchantUrl为256位
        Map testData_MerchantUrl02 = AskForPayUtil.createDefaultInput();
        testData_MerchantUrl02.put(AdvPayEnum.MerchantUrl, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456");

        List expectedResults_MerchantUrl02 = createExpectedResult();
        expectedResults_MerchantUrl02.add("收银台");
        expectedResults_MerchantUrl02.add("确认支付");


        //testcase3 MerchantUrl为257位
        Map testData_MerchantUrl03 = AskForPayUtil.createDefaultInput();
        testData_MerchantUrl03.put(AdvPayEnum.MerchantUrl, "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234561");

        List expectedResults_MerchantUrl03 = createExpectedResult();
        expectedResults_MerchantUrl03.add("9007");
        expectedResults_MerchantUrl03.add("MerchantURL节点值长度不能超过256字符");

        //testcase4 MerchantUrl为纯数字
        Map testData_MerchantUrl04 = AskForPayUtil.createDefaultInput();
        testData_MerchantUrl04.put(AdvPayEnum.MerchantUrl, "123");

        List expectedResults_MerchantUrl04 = createExpectedResult();
        expectedResults_MerchantUrl04.add("收银台");
        expectedResults_MerchantUrl04.add("确认支付");

        //testcase5 MerchantUrl全为字符
        Map testData_MerchantUrl05 = AskForPayUtil.createDefaultInput();
        testData_MerchantUrl05.put(AdvPayEnum.MerchantUrl, "thinking");

        List expectedResults_MerchantUrl05 = createExpectedResult();
        expectedResults_MerchantUrl05.add("收银台");
        expectedResults_MerchantUrl05.add("确认支付");

        //testcase6 MerchantUrl为256个中文字符
        Map testData_MerchantUrl06 = AskForPayUtil.createDefaultInput();
        testData_MerchantUrl06.put(AdvPayEnum.MerchantUrl, "测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测试中国人测");

        List expectedResults_MerchantUrl06 = createExpectedResult();
        expectedResults_MerchantUrl06.add("收银台");
        expectedResults_MerchantUrl06.add("确认支付");



        return new Object[][]{

                {testData, expectedResults, "yyy测试正常的测试数据"},

                {testData_Version01, expectedResults_Version01, "version为空"},
                {testData_Version02, expectedResults_Version02, "Version节点值为1.0"},
                {testData_Version03, expectedResults_Version03, "Version节点值为1.000"},
                {testData_Version04, expectedResults_Version04, "Version节点值为2.00"},

                {testData_TransactionId01, expectedResults_TransactionId01, "TransactionId节点值为空"},
                {testData_TransactionId02, expectedResults_TransactionId02, "TransactionId节点值为32位字符"},
                {testData_TransactionId03, expectedResults_TransactionId03, "TransactionId节点值超过32位字符"},
                {testData_TransactionId04, expectedResults_TransactionId04, "TransactionId节点值不超过32位字符但包含特殊字符"},
                {testData_TransactionId05, expectedResults_TransactionId05, "TransactionId节点值为16位字母"},

                {testData_TransactionDate01, expectedResults_TransactionDate01, "TransactionDate节点值为空"},
                {testData_TransactionDate02, expectedResults_TransactionDate02, "TransactionDate节点值为YYYYMMDDHHMMSS14位数字"},
                {testData_TransactionDate03, expectedResults_TransactionDate03, "TransactionDate节点值包含字母的14位数字"},
                {testData_TransactionDate04, expectedResults_TransactionDate04, "TransactionDate节点值为13位数字"},
                {testData_TransactionDate05, expectedResults_TransactionDate05, "TransactionDate节点值为15位数字"},
                {testData_TransactionDate06, expectedResults_TransactionDate06, "TransactionDate节点值为14个0"},

                {testData_OriginId01, expectedResults_OriginId01, "OriginId节点值为空"},
                {testData_OriginId02, expectedResults_OriginId02, "OriginId节点值为数据库中配置过的值"},
                {testData_OriginId03, expectedResults_OriginId03, "OriginId节点值小于4位数字，且为数据库中未配置过的值"},
                {testData_OriginId04, expectedResults_OriginId04, "OriginId节点值为5位数字"},

                {testData_DigestAlg01, expectedResults_DigestAlg01, "DigestAlg节点值为空"},
                {testData_DigestAlg02, expectedResults_DigestAlg02, "DigestAlg节点值为MD5"},
                //  {testData_DigestAlg03,expectedResults_DigestAlg03,"DigestAlg节点值为RSA"},
                {testData_DigestAlg04, expectedResults_DigestAlg04, "DigestAlg节点值为123"},

                {testData_AccountType01, expectedResults_AccountType01, "AccountType节点值为空"},
                {testData_AccountType02, expectedResults_AccountType02, "AccountCode节点值为空"},
                {testData_AccountType03, expectedResults_AccountType03, "AccountType节点值为1，AccountCode为超过11位手机号"},
                {testData_AccountType04, expectedResults_AccountType04, "AccountType节点值为1，AccountCode为11位手机号"},
                {testData_AccountType05, expectedResults_AccountType05, "AccountType节点值为2，AccountCode为128位"},
                {testData_AccountType06, expectedResults_AccountType06, "AccountType节点值为2，AccountCode为129位"},
                {testData_AccountType07, expectedResults_AccountType07, "AccountType节点值为3，AccountCode为11位手机号"},
                {testData_AccountType08, expectedResults_AccountType08, "AccountType节点值为3，AccountCode为正确的邮箱"},
                {testData_AccountType09, expectedResults_AccountType09, "AccountType节点值为3，AccountCode为不带@符号的字符串不超过128位"},
                {testData_AccountType10, expectedResults_AccountType10, "AccountType节点值为3，AccountCode为带@符号的字符串且超过128位"},
                {testData_AccountType11, expectedResults_AccountType11, "AccountType节点值为4"},
                {testData_AccountType12, expectedResults_AccountType12, "AccountType节点值为字符"},
                {testData_AccountType13, expectedResults_AccountType13, "AccountType节点值为特殊字符"},
                {testData_AccountType14, expectedResults_AccountType14, "AccountType节点值为2位数字"},


                {testData_PayInfo01, expectedResults_PayInfo01, "PayInfo节点值为空"},
                {testData_PayInfo02, expectedResults_PayInfo02, "PayInfo为128位数字"},
                {testData_PayInfo03, expectedResults_PayInfo03, "PayInfo为128位数字加字符"},
                {testData_PayInfo04, expectedResults_PayInfo04, "PayInfo为129位数字"},
                {testData_PayInfo05, expectedResults_PayInfo05, "PayInfo为含中文字符"},
                {testData_PayInfo06, expectedResults_PayInfo06, "PayInfo为128个中文字符"},
                {testData_PayInfo07, expectedResults_PayInfo07, "PayInfo为超过128个中文字符"},
                {testData_PayInfo08, expectedResults_PayInfo08, "PayInfo08为含有特殊字符"},


                {testData_OrderId01, expectedResults_OrderId01, "OrderId节点值为空"},
                {testData_OrderId02, expectedResults_OrderId02, "OrderId为20位数字"},
                {testData_OrderId03, expectedResults_OrderId03, "OrderId为20位数字加字符"},
                {testData_OrderId04, expectedResults_OrderId04, "OrderId为超过20位数字加字符"},
                {testData_OrderId05, expectedResults_OrderId05, "OrderId含有中文字符"},

                {testData_MerchantId01, expectedResults_MerchantId01, "MerchantId节点值为空"},
               // {testData_MerchantId02, expectedResults_MerchantId02, "MerchantId为18位数字且在数据库中存在"},
                {testData_MerchantId03, expectedResults_MerchantId03, "MerchantId为19位数字"},
                {testData_MerchantId04, expectedResults_MerchantId04, "MerchantId包含字符"},
                {testData_MerchantId05, expectedResults_MerchantId05, "MerchantId含有中文字符"},
                {testData_MerchantId06, expectedResults_MerchantId06, "MerchantId为18位以下的数字且数据库中存在"},
                {testData_MerchantId07, expectedResults_MerchantId07, "MerchantId为18位以下的数字且数据库中不存在"},


                {testData_ProductId01, expectedResults_ProductId01, "ProductId节点值为空"},
               // {testData_ProductId02, expectedResults_ProductId02, "ProductId为18位数字且在数据库中存在"},
                {testData_ProductId03, expectedResults_ProductId03, "ProductId为19位数字"},
                {testData_ProductId04, expectedResults_ProductId04, "ProductId包含字符"},
                {testData_ProductId05, expectedResults_ProductId05, "ProductId含有中文字符"},
                {testData_ProductId06, expectedResults_ProductId06, "ProductId为18位以下的数字且数据库中存在"},
                {testData_ProductId07, expectedResults_ProductId07, "ProductId为18位以下的数字且数据库中不存在"},

                {testData_ProCount01, expectedResults_ProCount01, "ProCount节点值为空"},
                {testData_ProCount02, expectedResults_ProCount02, "ProCount为10位数字"},
                {testData_ProCount03, expectedResults_ProCount03, "ProCount为11位数字"},
                {testData_ProCount04, expectedResults_ProCount04, "ProCount包含字符"},
                {testData_ProCount05, expectedResults_ProCount05, "ProCount含有中文字符"},
                {testData_ProCount06, expectedResults_ProCount06, "ProCount数量为负值"},

                {testData_PayAmount01, expectedResults_PayAmount01, "PayAmount节点值为空"},
                {testData_PayAmount02, expectedResults_PayAmount02, "PayAmount为9位浮点数"},
                {testData_PayAmount03, expectedResults_PayAmount03, "PayAmount测试小数点后1位"},
                {testData_PayAmount04, expectedResults_PayAmount04, "PayAmount测试小数点后3位"},
                {testData_PayAmount05, expectedResults_PayAmount05, "PayAmount测试小数点后0位"},
                {testData_PayAmount06, expectedResults_PayAmount06, "PayAmount_6位且无小数点"},
                {testData_PayAmount07, expectedResults_PayAmount07, "PayAmount_7位且无小数点"},
                {testData_PayAmount08, expectedResults_PayAmount08, "PayAmount含字符"},
                {testData_PayAmount09, expectedResults_PayAmount09, "PayAmount小数点在最前面"},
                {testData_PayAmount10, expectedResults_PayAmount10, "PayAmount是0.00"},
                {testData_PayAmount11, expectedResults_PayAmount11, "PayAmount是1000000.999"},


                {testData_PayPeriod01, expectedResults_PayPeriod01, "01"},
                {testData_PayPeriod02, expectedResults_PayPeriod02, "testcase2 PayPeriod以秒为单位"},
                {testData_PayPeriod03, expectedResults_PayPeriod03, "testcase3 PayPeriod以小时为单位"},
                {testData_PayPeriod04, expectedResults_PayPeriod04, "testcase4 PayPeriod以天为单位"},
                {testData_PayPeriod05, expectedResults_PayPeriod05, "testcase5 PayPeriod右边界值"},
                {testData_PayPeriod06, expectedResults_PayPeriod06, "testcase6 PayPeriod左边界值"},
                {testData_PayPeriod07, expectedResults_PayPeriod07, "testcase7 PayPeriod为小时的右边界"},
                {testData_PayPeriod08, expectedResults_PayPeriod08, "testcase8 PayPeriod为小时的左边界"},
                {testData_PayPeriod09, expectedResults_PayPeriod09, "testcase9 PayPeriod为分钟的左边界"},
                {testData_PayPeriod10, expectedResults_PayPeriod10, "testcase10 PayPeriod为分钟的右边界"},
                {testData_PayPeriod11, expectedResults_PayPeriod11, "testcase11 PayPeriod左边界分钟异常"},
                {testData_PayPeriod12, expectedResults_PayPeriod12, "testcase12 PayPeriod右边界分钟异常"},
                {testData_PayPeriod13, expectedResults_PayPeriod13, "testcase13 PayPeriod左边界小时异常"},
                {testData_PayPeriod14, expectedResults_PayPeriod14, "testcase14 PayPeriod右边界小时异常"},
                {testData_PayPeriod15, expectedResults_PayPeriod15, "testcase15 PayPeriod左边界天异常"},
                {testData_PayPeriod16, expectedResults_PayPeriod16, "testcase16 PayPeriod左边界天异常"},
                {testData_PayPeriod17, expectedResults_PayPeriod17, "testcase17 PayPeriod不符合格式的，全数字"},
                {testData_PayPeriod18, expectedResults_PayPeriod18, "testcase18 PayPeriod不符合格式的，超过4位"},

                {testData_PayNotifyIntURL01, expectedResults_PayNotifyIntURL01, "PayNotifyIntURL节点值为空"},
                {testData_PayNotifyIntURL02, expectedResults_PayNotifyIntURL02, "PayNotifyIntURL为256位"},
                {testData_PayNotifyIntURL03, expectedResults_PayNotifyIntURL03, "PayNotifyIntURL为257位"},
                {testData_PayNotifyIntURL04, expectedResults_PayNotifyIntURL04, "PayNotifyIntURL为纯数字"},
                {testData_PayNotifyIntURL05, expectedResults_PayNotifyIntURL05, "PayNotifyIntURL全为字符"},
                {testData_PayNotifyIntURL06, expectedResults_PayNotifyIntURL06, "PayNotifyIntURL为256个中文字符"},

                {testData_PayNotifyPageURL01, expectedResults_PayNotifyPageURL01, "PayNotifyPageURL节点值为空"},
                {testData_PayNotifyPageURL02, expectedResults_PayNotifyPageURL02, "PayNotifyPageURL为256位"},
                {testData_PayNotifyPageURL03, expectedResults_PayNotifyPageURL03, "PayNotifyPageURL为257位"},
                {testData_PayNotifyPageURL04, expectedResults_PayNotifyPageURL04, "PayNotifyPageURL为纯数字"},
                {testData_PayNotifyPageURL05, expectedResults_PayNotifyPageURL05, "PayNotifyPageURL全为字符"},
                {testData_PayNotifyPageURL06, expectedResults_PayNotifyPageURL06, "PayNotifyPageURL为256个中文字符"},

                {testData_RoyaltyFlag01, expectedResults_RoyaltyFlag01, "RoyaltyFlag节点值为空"},
                {testData_RoyaltyFlag02, expectedResults_RoyaltyFlag02, "RoyaltyFlag为1"},
                {testData_RoyaltyFlag03, expectedResults_RoyaltyFlag03, "RoyaltyFlag为2"},
                {testData_RoyaltyFlag04, expectedResults_RoyaltyFlag04, "RoyaltyFlag为2位数字"},
                {testData_RoyaltyFlag05, expectedResults_RoyaltyFlag05, "RoyaltyFlag为1位字母"},


                {testData_MerchantUrl01, expectedResults_MerchantUrl01, "MerchantUrl节点值为空"},
                {testData_MerchantUrl02, expectedResults_MerchantUrl02, "MerchantUrl为256位"},
                {testData_MerchantUrl03, expectedResults_MerchantUrl03, "MerchantUrl为257位"},
                {testData_MerchantUrl04, expectedResults_MerchantUrl04, "MerchantUrl为纯数字"},
                {testData_MerchantUrl05, expectedResults_MerchantUrl05, "MerchantUrl全为字符"},
                {testData_MerchantUrl06, expectedResults_MerchantUrl06, "MerchantUrl为256个中文字符"},

        };
    }

    @Test(dataProvider = "testData_AskForPay", groups = "AskForPay")
    public void askForPayTest(Map input, List<String> expectedResults, String desc) {
        AdvTestResponse response = test(input, InterfaceType.askForPay);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getReasonPhrase(), "OK");

        //循环断言返回结果是否包含预期字符串
        for (String expectedResult : expectedResults) {
            Assert.assertTrue(response.getContent().contains(expectedResult), desc);

        }

    }

    @AfterTest( groups = "AskForPay")
    public void ClearData() {

        SQL="DELETE FROM pay_order_1604 where orderinfo = 'InterfaceTest_YYY0624' or orderid='InterfaceTest_663681';";
        DB1 = new DBHelper(SQL);
        try {
           int i= DB1.pst.executeUpdate();//执行语句，得到结果集
            System.out.println("Delete "+i+" recodes.");
            DB1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


