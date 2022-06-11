package com.tibani.bookmall.web.book.dao;


import com.tibani.bookmall.core.dao.CoreDao;
import com.tibani.bookmall.web.book.entity.Book;

import java.util.List;

/**
 * @Description
 * @Author Robert
 * @Version
 * @Date 2022-06-05 下午 04:23
 */
public interface BookDao extends CoreDao<Book, Integer> {
    List<Book> selectByISBN(String ISBN, int page);
    List<Book> selectByTitle(String title, int page);
    List<Book> selectByCategoryName(String categoryName, int page);
    List<Book> selectAll(Integer page);
    Book selectByISBNAndEdition(String ISBN, Integer edition);
}
