package com.hyg.executor;

import com.hyg.entity.Blog;

import java.sql.*;

public class MyExecutor {
    public <T> T query(String sql, Object param) {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();

        try {
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            // 执行查询
            stmt = conn.createStatement();
           // String sql = "SELECT bid, name, author_id FROM blog where bid = 1";
            ResultSet rs = stmt.executeQuery(String.format(sql,param));

            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null){ stmt.close();}
            } catch (SQLException se2) {
            }
            try {
                if (conn != null){conn.close();}
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) blog;
    }
}
