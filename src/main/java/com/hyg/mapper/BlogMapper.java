package com.hyg.mapper;

import com.hyg.entity.Blog;

import java.util.List;

/**
 * @Author: qingshan
 */
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

    /**
     * 根据实体类查询文章
     * @param blog
     * @return
     */
    public List<Blog> selectBlogByBean(Blog blog);

    public List<Blog> selectBlogListIf(Blog blog);

    public List<Blog> selectBlogListChoose(Blog blog);

    public void deleteByList(List<Blog> list);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    public int updateByPrimaryKey(Blog blog);

    /**
     * 新增博客
     * @param blog
     * @return
     */
    public int insertBlog(Blog blog);

    /**
     * 批量插入博客
     * @param list
     * @return
     */
    public int insertBlogList(List<Blog> list);

    /**
     * 批量更新博客
     * @param list
     * @return
     */
    public int updateBlogList(List<Blog> list);
}
