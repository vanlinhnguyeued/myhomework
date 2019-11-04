package com.vanlinhnguyenued.listviewnangcao;

public class country {
    private String ten;
    private String mota;
    private int hinh;

    public country(String ten, String mota, int hinh) {
        this.ten = ten;
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
