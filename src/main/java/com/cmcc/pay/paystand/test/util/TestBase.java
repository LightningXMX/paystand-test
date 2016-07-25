package com.cmcc.pay.paystand.test.util;

import com.cmcc.pay.paystand.test.util.biz.ExcelInfo;
import com.cmcc.pay.paystand.test.xml.module.AdvPay;
import com.cmcc.pay.paystand.test.xml.module.AdvPayBuilder;
import com.cmcc.pay.paystand.test.xml.module.TestData;
import com.cmcc.pay.paystand.test.xml.module.refund.RefundTestData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.reflect.generics.tree.VoidDescriptor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ech0 on 2016/3/13.
 */
public class TestBase {

    protected static final String EXPECTED_RESULT = "EXPECTED_RESULT";
    protected static final String DESC = "DESC";


    private static ApplicationContext context;
    protected static HttpClientUtil httpClientUtil;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        initHttpClient();
//        initMybatis();
    }

    private static void initHttpClient() {
        httpClientUtil = (HttpClientUtil) context.getBean("httpClientUtil");

    }

    private static void initMybatis() {
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
    }


    protected List createExpectedResult() {
        return new ArrayList<String>();
    }

    protected List getTestData(InterfaceType interfaceType) {
        String filePath = getFilePath(interfaceType);
        XSSFWorkbook xssfWorkbook = ExcelUtil.readTestData(filePath);
        String sheetName ="";
        TestData testData = null;
        if (InterfaceType.refund.equals(interfaceType)){
             sheetName = ExcelInfo.ExcelRefundSheetName;
             testData = new RefundTestData();
        }else if (InterfaceType.askForPay.equals(interfaceType)){
            sheetName = ExcelInfo.ExcelAskForPaySheetName;
        }else if (InterfaceType.settlePeriodChange.equals(interfaceType)){
            sheetName = ExcelInfo.ExcelChangeSettlePeriodSheetName;
        }
        List<XSSFRow> refundRowList = ExcelUtil.convertXLS(xssfWorkbook, sheetName);


        List testDataList = testData.build(refundRowList);
        return testDataList;
    }

    protected AdvTestResponse test(Map<String, String> input, InterfaceType interfaceType) {

        AdvPay advPay = AdvPayBuilder.build(input, interfaceType);

        String xml = XmlUtil.convertToXml(advPay);

        String url = URLbuilder.buildRequestUrl(xml, interfaceType);

        AdvTestResponse response = HttpClientUtil.get(url);

        return response;

    }
    protected AdvTestResponse test(AdvPay advPay, InterfaceType interfaceType) {

//        AdvPay advPay = AdvPayBuilder.build(input, interfaceType);

        String xml = XmlUtil.convertToXml(advPay);

        String url = URLbuilder.buildRequestUrl(xml, interfaceType);

        AdvTestResponse response = HttpClientUtil.get(url);

        return response;

    }

    protected String getFilePath(InterfaceType interfaceType) {
        StringBuilder filePath = new StringBuilder().
                append(System.getProperty("user.dir")).append(File.separator)
                .append("src").append(File.separator)
                .append("main").append(File.separator)
                .append("resources").append(File.separator)
                .append("testdata").append(File.separator);
        if (InterfaceType.askForPay.equals(interfaceType)) {
            filePath.append("askforpay").append(File.separator)
                    .append(ExcelInfo.ExcelFileName_AskForPay);
        } else if (InterfaceType.refund.equals(interfaceType)) {
            filePath.append("refund").append(File.separator)
                    .append(ExcelInfo.ExcelFileName_Refund);
        } else if (InterfaceType.settlePeriodChange.equals(interfaceType)) {
            filePath.append("changesettleperiod").append(File.separator)
                    .append(ExcelInfo.ExcelFileName_SettlePeriodChange);
        }


        return filePath.toString();
    }
}
