package com.qlbh.pojo;
// Generated 21/09/2016 7:11:19 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tygia generated by hbm2java
 */
@Entity
@Table(name="tygia"
    ,catalog="qlbh"
)
public class Tygia  implements java.io.Serializable {


     private int ma;
     private String ten;
     private Float tygiaquydoi;
     private Byte activite;

    public Tygia() {
    }

	
    public Tygia(int ma) {
        this.ma = ma;
    }
    public Tygia(int ma, String ten, Float tygiaquydoi, Byte activite) {
       this.ma = ma;
       this.ten = ten;
       this.tygiaquydoi = tygiaquydoi;
       this.activite = activite;
    }
   
     @Id 

    
    @Column(name="ma", unique=true, nullable=false)
    public int getMa() {
        return this.ma;
    }
    
    public void setMa(int ma) {
        this.ma = ma;
    }

    
    @Column(name="ten")
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }

    
    @Column(name="tygiaquydoi", precision=4, scale=0)
    public Float getTygiaquydoi() {
        return this.tygiaquydoi;
    }
    
    public void setTygiaquydoi(Float tygiaquydoi) {
        this.tygiaquydoi = tygiaquydoi;
    }

    
    @Column(name="activite")
    public Byte getActivite() {
        return this.activite;
    }
    
    public void setActivite(Byte activite) {
        this.activite = activite;
    }




}


