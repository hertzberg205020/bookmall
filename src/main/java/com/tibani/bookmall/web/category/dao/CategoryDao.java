package com.tibani.bookmall.web.category.dao;


import com.tibani.bookmall.core.dao.CoreDao;
import com.tibani.bookmall.web.category.pojo.Category;

import java.util.List;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-05 下午 09:27
 */
public interface CategoryDao extends CoreDao<Category, Integer> {
    List<Category> selectAll(Integer page);
}
