package com.ours.contract.entity;

import java.util.List;

public class Datalist {
    private List forlist;
    private int pageTotal;

    public List getForlist() {
        return forlist;
    }

    public void setForlist(List forlist) {
        this.forlist = forlist;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
}
