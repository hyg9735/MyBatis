package com.hyg;

import com.hyg.API.MySqlSeesion;
import com.hyg.entity.Blog;
import com.hyg.executor.MyExecutor;
import com.hyg.mapper.BlogMapper;

public class MyBatisTest {
    public static void main(String[] args) {
        //对外的api接口  SqlSeesion
        MySqlSeesion mySqlSeesion=new MySqlSeesion(new MyConfiguration(),new MyExecutor());
        BlogMapper mapper=mySqlSeesion.getMapper(BlogMapper.class);
        Blog blog=mapper.selectBlogById(1);
        blog.toString();
    }
    /*优化目标
    职责拆分，预编译ps，结果集自动映射，注解sql，缓存，插件
     */



}
