package com.hyg.API;

import com.hyg.MyConfiguration;
import com.hyg.executor.MyExecutor;

public class MySqlSeesion {
    //全局配置类
    private MyConfiguration myConfiguration;
    //执行器
    private MyExecutor myExecutor;

    public MySqlSeesion(MyConfiguration myConfiguration, MyExecutor myExecutor) {
        this.myConfiguration=myConfiguration;
        this.myExecutor=myExecutor;
    }

    public <T> T selectOne(String statementId,Object param){
        String sql=MyConfiguration.getSqlMapperings().getString(statementId);
        return myExecutor.query(sql,param);
    }

    //提供获取一个代理类
    public <T>T getMapper(Class clazz){
        return myConfiguration.getMapper(clazz,this);
    }

}
