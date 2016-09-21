package com.qlbh.pojo;
// Generated 21/09/2016 7:11:19 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Congty generated by hbm2java
 */
@Entity
@Table(name="congty"
    ,catalog="qlbh"
)
public class Congty  implements java.io.Serializable {


     private short ma;
     private String ten;
     private String diachi;
     private String masothue;
     private String tel;
     private String fax;
     private String email;
     private String website;
     private byte[] logo;
     private Byte activite;

    public Congty() {
    }

	
    public Congty(short ma) {
        this.ma = ma;
    }
    public Congty(short ma, String ten, String diachi, String masothue, String tel, String fax, String email, String website, byte[] logo, Byte activite) {
       this.ma = ma;
       this.ten = ten;
       this.diachi = diachi;
       this.masothue = masothue;
       this.tel = tel;
       this.fax = fax;
       this.email = email;
       this.website = website;
       this.logo = logo;
       this.activite = activite;
    }
   
     @Id 

    
    @Column(name="ma", unique=true, nullable=false)
    public short getMa() {
        return this.ma;
    }
    
    public void setMa(short ma) {
        this.ma = ma;
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

    
    @Column(name="tel")
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    
    @Column(name="fax")
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="website")
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }

    
    @Column(name="logo")
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    
    @Column(name="activite")
    public Byte getActivite() {
        return this.activite;
    }
    
    public void setActivite(Byte activite) {
        this.activite = activite;
    }




}

