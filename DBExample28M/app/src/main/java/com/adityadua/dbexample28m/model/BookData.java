package com.adityadua.dbexample28m.model;

/**
 * Created by AdityaDua on 23/04/18.
 */

public class BookData {

    /**
     * 3 columns in this table
     *
     * **/

    String bookName;
    String authorName;
    String bookid;

    int id;// AUTO INCREMENTED VALUE

    // Getters & Setters for the fields

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
