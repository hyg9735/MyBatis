package com.hyg.proxy;

import com.hyg.API.MySqlSeesion;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {
    private MySqlSeesion mySqlSeesion;

    public MapperProxy(MySqlSeesion mySqlSeesion){
        this.mySqlSeesion=mySqlSeesion;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取statementId   接口名加方法名
        String mapperInterface=method.getDeclaringClass().getName();
        String methodName=method.getName();
        String statementId=mapperInterface +"."+methodName;
        return mySqlSeesion.selectOne(statementId,args[0]);
    }
}
