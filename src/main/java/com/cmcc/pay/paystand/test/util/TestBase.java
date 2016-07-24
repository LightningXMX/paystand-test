package com.cmcc.pay.paystand.test.util;

import com.cmcc.pay.paystand.test.xml.module.AdvPay;
import com.cmcc.pay.paystand.test.xml.module.AdvPayBuilder;
import com.cmcc.pay.paystand.test.xml.module.AdvPayEnum;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


    private static ApplicationContext context ;
    protected static HttpClientUtil httpClientUtil;

    static {
         context = new ClassPathXmlApplicationContext("applicationContext.xml");

        initHttpClient();
//        initMybatis();
    }

    private static void initHttpClient(){
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
    protected AdvTestResponse test(Map<String,String> input,InterfaceType interfaceType) {

        AdvPay advPay = AdvPayBuilder.build(input,interfaceType);
//
        String xml = XmlUtil.convertToXml(advPay);

        String url = URLbuilder.buildRequestUrl(xml);

        AdvTestResponse response = HttpClientUtil.get(url);

        return response;

    }
}
