package com.jsoup;

import java.util.List;

/**
 * @author fujin
 * @version $Id: Book.java, v 0.1 2018-07-27 21:35 Exp $$
 */
public class Book {

    private String bookname;

    private String url;

    private List<Charpter> clist;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Charpter> getClist() {
        return clist;
    }

    public void setClist(List<Charpter> clist) {
        this.clist = clist;
    }
}
