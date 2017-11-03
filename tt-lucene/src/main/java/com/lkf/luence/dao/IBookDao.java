package com.lkf.luence.dao;

import com.lkf.lucene.pojo.po.Book;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/1
 * Time: 15:39
 * Version:V1.0
 */
public interface IBookDao {
    List<Book> listBooks();
}
