package com.tibani.bookmall.web.book.dao;

import java.util.List;

import com.tibani.bookmall.web.book.dao.impl.BookDaoImpl;
import com.tibani.bookmall.web.book.entity.Book;

public class BookService {
	
	private BookDao dao;
	public BookService() {
		dao = new BookDaoImpl();
	}
	public Book showOne(Integer bookID) {
		return dao.selectByPrimaryKey(bookID);
	}
	
	public List<Book> getAll() {
		return dao.selectAll();
	}
	
	
}
