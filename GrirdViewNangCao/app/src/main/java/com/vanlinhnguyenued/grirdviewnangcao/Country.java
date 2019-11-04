package com.vanlinhnguyenued.grirdviewnangcao;

public class Country {
    private int hinhQK;
    private String ten;

    public Country(int hinhQK, String ten) {
        this.hinhQK = hinhQK;
        this.ten = ten;
    }

    public int getHinhQK() {
        return hinhQK;
    }

    public String getTen() {
        return ten;
    }

    public void setHinhQK(int hinhQK) {
        this.hinhQK = hinhQK;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


}
