package com.hyg;

import com.hyg.API.MySqlSeesion;
import com.hyg.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class MyConfiguration {


    private static final ResourceBundle sqlMapperings;

    static {
        sqlMapperings=ResourceBundle.getBundle("configruation");
    }
    public <T> T getMapper(Class clazz,MySqlSeesion mySqlSeesion) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(mySqlSeesion));
    }
    public static ResourceBundle getSqlMapperings() {
        return sqlMapperings;
    }
}
