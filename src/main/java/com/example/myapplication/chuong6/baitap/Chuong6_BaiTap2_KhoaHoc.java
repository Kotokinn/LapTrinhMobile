package com.example.myapplication.chuong6.baitap;

public class Chuong6_BaiTap2_KhoaHoc {

    private String imag;
    private String tenKhoaHoc;
    private String hocPhi;

    public Chuong6_BaiTap2_KhoaHoc(String hocPhi, String imag, String tenKhoaHoc) {
        this.hocPhi = hocPhi;
        this.imag = imag;
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(String hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

}
