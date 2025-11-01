package com.example.myapplication.chuong7.baitap;

import java.io.Serializable;

public class Chuong7_BaiTap6_ObjectMonHoc implements Serializable {

    private int giaTien;
    private String tenMonHoc;

    public Chuong7_BaiTap6_ObjectMonHoc() {
    }

    public Chuong7_BaiTap6_ObjectMonHoc(String tenMonHoc, int giaTien) {
        this.tenMonHoc = tenMonHoc;
        this.giaTien = giaTien;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }


    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }


}
