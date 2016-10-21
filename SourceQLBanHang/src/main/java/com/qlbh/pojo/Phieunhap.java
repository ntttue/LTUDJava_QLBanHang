package com.qlbh.pojo;
// Generated 21/10/2016 11:19:45 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Phieunhap generated by hbm2java
 */
public class Phieunhap  implements java.io.Serializable {


     private Integer id;
     private Khohang khohang;
     private Nhacungcap nhacungcap;
     private Nhanvien nhanvien;
     private String ma;
     private String dienthoai;
     private String diachi;
     private Date ngaynhap;
     private String ghichu;
     private Double tongtien;
     private Boolean activity;
     private Set chitietphieunhaps = new HashSet(0);

    public Phieunhap() {
    }

    public Phieunhap(Khohang khohang, Nhacungcap nhacungcap, Nhanvien nhanvien, String ma, String dienthoai, String diachi, Date ngaynhap, String ghichu, Double tongtien, Boolean activity, Set chitietphieunhaps) {
       this.khohang = khohang;
       this.nhacungcap = nhacungcap;
       this.nhanvien = nhanvien;
       this.ma = ma;
       this.dienthoai = dienthoai;
       this.diachi = diachi;
       this.ngaynhap = ngaynhap;
       this.ghichu = ghichu;
       this.tongtien = tongtien;
       this.activity = activity;
       this.chitietphieunhaps = chitietphieunhaps;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Khohang getKhohang() {
        return this.khohang;
    }
    
    public void setKhohang(Khohang khohang) {
        this.khohang = khohang;
    }
    public Nhacungcap getNhacungcap() {
        return this.nhacungcap;
    }
    
    public void setNhacungcap(Nhacungcap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }
    public Nhanvien getNhanvien() {
        return this.nhanvien;
    }
    
    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }
    public String getMa() {
        return this.ma;
    }
    
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getDienthoai() {
        return this.dienthoai;
    }
    
    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    public String getDiachi() {
        return this.diachi;
    }
    
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public Date getNgaynhap() {
        return this.ngaynhap;
    }
    
    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    public String getGhichu() {
        return this.ghichu;
    }
    
    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    public Double getTongtien() {
        return this.tongtien;
    }
    
    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }
    public Boolean getActivity() {
        return this.activity;
    }
    
    public void setActivity(Boolean activity) {
        this.activity = activity;
    }
    public Set getChitietphieunhaps() {
        return this.chitietphieunhaps;
    }
    
    public void setChitietphieunhaps(Set chitietphieunhaps) {
        this.chitietphieunhaps = chitietphieunhaps;
    }




}


