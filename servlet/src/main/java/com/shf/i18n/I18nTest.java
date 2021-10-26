package com.shf.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {
    @Test
    public void testLocale(){
//        获取系统默认国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);

//        for (Locale availableLocale : Locale.getAvailableLocales()) {
//            System.out.println(availableLocale);
//        }

        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);
    }

    @Test
    public void testI18N(){
//        得到我们的local对象
        Locale locale = Locale.CHINA;
//        通过指定basename和local对象 读取响应的配置
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println("username："+bundle.getString("username"));
        System.out.println("password："+bundle.getString("password"));
        System.out.println("sex："+bundle.getString("sex"));
        System.out.println("age："+bundle.getString("age"));

    }
}
