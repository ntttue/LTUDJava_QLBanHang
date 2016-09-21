package com.qlbh.pojo;
// Generated 21/09/2016 2:16:33 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Khachhang generated by hbm2java
 */
@Entity
@Table(name="khachhang"
    ,catalog="qlbh"
)
public class Khachhang  implements java.io.Serializable {


     private int ma;
     private Loaikhachhang loaikhachhang;
     private String makh;
     private Short makhuvuc;
     private String ten;
     private String diachi;
     private String masothue;
     private String dienthoai;
     private String email;
     private String taikhoan;
     private String nganhang;
     private BigDecimal gioihanno;
     private BigDecimal nohientai;
     private String yahoo;
     private String skype;
     private String nguoilienhe;
     private Byte activite;
     private Set<Phieuxuat> phieuxuats = new HashSet<Phieuxuat>(0);

    public Khachhang() {
    }

	
    public Khachhang(int ma, String makh) {
        this.ma = ma;
        this.makh = makh;
    }
    public Khachhang(int ma, Loaikhachhang loaikhachhang, String makh, Short makhuvuc, String ten, String diachi, String masothue, String dienthoai, String email, String taikhoan, String nganhang, BigDecimal gioihanno, BigDecimal nohientai, String yahoo, String skype, String nguoilienhe, Byte activite, Set<Phieuxuat> phieuxuats) {
       this.ma = ma;
       this.loaikhachhang = loaikhachhang;
       this.makh = makh;
       this.makhuvuc = makhuvuc;
       this.ten = ten;
       this.diachi = diachi;
       this.masothue = masothue;
       this.dienthoai = dienthoai;
       this.email = email;
       this.taikhoan = taikhoan;
       this.nganhang = nganhang;
       this.gioihanno = gioihanno;
       this.nohientai = nohientai;
       this.yahoo = yahoo;
       this.skype = skype;
       this.nguoilienhe = nguoilienhe;
       this.activite = activite;
       this.phieuxuats = phieuxuats;
    }
   
     @Id 

    
    @Column(name="ma", unique=true, nullable=false)
    public int getMa() {
        return this.ma;
    }
    
    public void setMa(int ma) {
        this.ma = ma;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="maloaikh")
    public Loaikhachhang getLoaikhachhang() {
        return this.loaikhachhang;
    }
    
    public void setLoaikhachhang(Loaikhachhang loaikhachhang) {
        this.loaikhachhang = loaikhachhang;
    }

    
    @Column(name="makh", nullable=false)
    public String getMakh() {
        return this.makh;
    }
    
    public void setMakh(String makh) {
        this.makh = makh;
    }

    
    @Column(name="makhuvuc")
    public Short getMakhuvuc() {
        return this.makhuvuc;
    }
    
    public void setMakhuvuc(Short makhuvuc) {
        this.makhuvuc = makhuvuc;
    }

    
    @Column(name="ten")
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }

    
    @Column(name="diachi")
    public String getDiachi() {
        return this.diachi;
    }
    
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    
    @Column(name="masothue")
    public String getMasothue() {
        return this.masothue;
    }
    
    public void setMasothue(String masothue) {
        this.masothue = masothue;
    }

    
    @Column(name="dienthoai")
    public String getDienthoai() {
        return this.dienthoai;
    }
    
    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="taikhoan")
    public String getTaikhoan() {
        return this.taikhoan;
    }
    
    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    
    @Column(name="nganhang")
    public String getNganhang() {
        return this.nganhang;
    }
    
    public void setNganhang(String nganhang) {
        this.nganhang = nganhang;
    }

    
    @Column(name="gioihanno", precision=30, scale=10)
    public BigDecimal getGioihanno() {
        return this.gioihanno;
    }
    
    public void setGioihanno(BigDecimal gioihanno) {
        this.gioihanno = gioihanno;
    }

    
    @Column(name="nohientai", precision=30, scale=10)
    public BigDecimal getNohientai() {
        return this.nohientai;
    }
    
    public void setNohientai(BigDecimal nohientai) {
        this.nohientai = nohientai;
    }

    
    @Column(name="yahoo")
    public String getYahoo() {
        return this.yahoo;
    }
    
    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    
    @Column(name="skype")
    public String getSkype() {
        return this.skype;
    }
    
    public void setSkype(String skype) {
        this.skype = skype;
    }

    
    @Column(name="nguoilienhe")
    public String getNguoilienhe() {
        return this.nguoilienhe;
    }
    
    public void setNguoilienhe(String nguoilienhe) {
        this.nguoilienhe = nguoilienhe;
    }

    
    @Column(name="activite")
    public Byte getActivite() {
        return this.activite;
    }
    
    public void setActivite(Byte activite) {
        this.activite = activite;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="khachhang")
    public Set<Phieuxuat> getPhieuxuats() {
        return this.phieuxuats;
    }
    
    public void setPhieuxuats(Set<Phieuxuat> phieuxuats) {
        this.phieuxuats = phieuxuats;
    }




}


