package com.kewei.manager.response;

import java.util.List;

/**
 * @Title: PageDataResult
 * @Description: 封装DTO分页数据（记录数和所有记录）
 * @auther: Administrator
 * @date: 2019/5/17 9:22
 */
public class PageDataResult {

    private Integer code=200;

    //总记录数量
    private Integer totals;

    private List<?> list;

    private int bList;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public List <?> getList() {
        return list;
    }

    public void setList(List <?> list) {
        this.list = list;
    }

    public int getbList() {
        return bList;
    }

    public void setbList(int bList) {
        this.bList = bList;
    }

    @Override
    public String toString() {
        return "PageDataResult{" +
                "code=" + code +
                ", totals=" + totals +
                ", list=" + list +
                ", bList=" + bList +
                '}';
    }
}
