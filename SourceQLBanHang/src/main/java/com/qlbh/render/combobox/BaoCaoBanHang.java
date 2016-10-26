package com.qlbh.render.combobox;

import java.io.Serializable;

import com.qlbh.pojo.Hanghoa;

public class BaoCaoBanHang implements Serializable{
	
	private Hanghoa hanghoa;
	private int SoLuongXuat;
	private double doanhSoBan;
	private double thanhTienNhap;
	private double chenhLech;
	public Hanghoa getHanghoa() {
		return hanghoa;
	}
	public void setHanghoa(Hanghoa hanghoa) {
		this.hanghoa = hanghoa;
	}
	public int getSoLuongXuat() {
		return SoLuongXuat;
	}
	public void setSoLuongXuat(int soLuongXuat) {
		SoLuongXuat = soLuongXuat;
	}
	public double getDoanhSoBan() {
		return doanhSoBan;
	}
	public void setDoanhSoBan(double doanhSoBan) {
		this.doanhSoBan = doanhSoBan;
	}
	public double getThanhTienNhap() {
		return thanhTienNhap;
	}
	public void setThanhTienNhap(double thanhTienNhap) {
		this.thanhTienNhap = thanhTienNhap;
	}
	public double getChenhLech() {
		return chenhLech;
	}
	public void setChenhLech(double chenhLech) {
		this.chenhLech = chenhLech;
	}
	
	

}
