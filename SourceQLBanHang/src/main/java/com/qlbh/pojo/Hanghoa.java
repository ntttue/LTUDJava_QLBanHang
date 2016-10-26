package com.qlbh.pojo;
// Generated 26/10/2016 3:07:02 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hanghoa generated by hbm2java
 */
@Entity
@Table(name = "hanghoa", catalog = "qlbh")
public class Hanghoa implements java.io.Serializable {

	private Integer id;
	private Donvitinh donvitinh;
	private Khohang khohang;
	private Loaihang loaihang;
	private Nhacungcap nhacungcap;
	private Nhomhanghoa nhomhanghoa;
	private String ma;
	private String ten;
	private String xuatxu;
	private Double giamua;
	private Double giabanle;
	private Double giabansi;
	private Integer tonkho;
	private String anh;
	private Boolean activity;
	private Set<Chitietphieunhap> chitietphieunhaps = new HashSet<Chitietphieunhap>(0);
	private Set<Chitietphieuxuat> chitietphieuxuats = new HashSet<Chitietphieuxuat>(0);
	private Set<Chitietchuyenkho> chitietchuyenkhos = new HashSet<Chitietchuyenkho>(0);

	public Hanghoa() {
	}

	public Hanghoa(Donvitinh donvitinh, Khohang khohang, Loaihang loaihang, Nhacungcap nhacungcap,
			Nhomhanghoa nhomhanghoa, String ma, String ten, String xuatxu, Double giamua, Double giabanle,
			Double giabansi, Integer tonkho, String anh, Boolean activity, Set<Chitietphieunhap> chitietphieunhaps,
			Set<Chitietphieuxuat> chitietphieuxuats, Set<Chitietchuyenkho> chitietchuyenkhos) {
		this.donvitinh = donvitinh;
		this.khohang = khohang;
		this.loaihang = loaihang;
		this.nhacungcap = nhacungcap;
		this.nhomhanghoa = nhomhanghoa;
		this.ma = ma;
		this.ten = ten;
		this.xuatxu = xuatxu;
		this.giamua = giamua;
		this.giabanle = giabanle;
		this.giabansi = giabansi;
		this.tonkho = tonkho;
		this.anh = anh;
		this.activity = activity;
		this.chitietphieunhaps = chitietphieunhaps;
		this.chitietphieuxuats = chitietphieuxuats;
		this.chitietchuyenkhos = chitietchuyenkhos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donviid")
	public Donvitinh getDonvitinh() {
		return this.donvitinh;
	}

	public void setDonvitinh(Donvitinh donvitinh) {
		this.donvitinh = donvitinh;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khohangid")
	public Khohang getKhohang() {
		return this.khohang;
	}

	public void setKhohang(Khohang khohang) {
		this.khohang = khohang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loaihangid")
	public Loaihang getLoaihang() {
		return this.loaihang;
	}

	public void setLoaihang(Loaihang loaihang) {
		this.loaihang = loaihang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nhaccid")
	public Nhacungcap getNhacungcap() {
		return this.nhacungcap;
	}

	public void setNhacungcap(Nhacungcap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nhomhangid")
	public Nhomhanghoa getNhomhanghoa() {
		return this.nhomhanghoa;
	}

	public void setNhomhanghoa(Nhomhanghoa nhomhanghoa) {
		this.nhomhanghoa = nhomhanghoa;
	}

	@Column(name = "ma", length = 20)
	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	@Column(name = "ten")
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "xuatxu")
	public String getXuatxu() {
		return this.xuatxu;
	}

	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}

	@Column(name = "giamua", precision = 22, scale = 0)
	public Double getGiamua() {
		return this.giamua;
	}

	public void setGiamua(Double giamua) {
		this.giamua = giamua;
	}

	@Column(name = "giabanle", precision = 22, scale = 0)
	public Double getGiabanle() {
		return this.giabanle;
	}

	public void setGiabanle(Double giabanle) {
		this.giabanle = giabanle;
	}

	@Column(name = "giabansi", precision = 22, scale = 0)
	public Double getGiabansi() {
		return this.giabansi;
	}

	public void setGiabansi(Double giabansi) {
		this.giabansi = giabansi;
	}

	@Column(name = "tonkho")
	public Integer getTonkho() {
		return this.tonkho;
	}

	public void setTonkho(Integer tonkho) {
		this.tonkho = tonkho;
	}

	@Column(name = "anh", length = 65535)
	public String getAnh() {
		return this.anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	@Column(name = "activity")
	public Boolean getActivity() {
		return this.activity;
	}

	public void setActivity(Boolean activity) {
		this.activity = activity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hanghoa")
	public Set<Chitietphieunhap> getChitietphieunhaps() {
		return this.chitietphieunhaps;
	}

	public void setChitietphieunhaps(Set<Chitietphieunhap> chitietphieunhaps) {
		this.chitietphieunhaps = chitietphieunhaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hanghoa")
	public Set<Chitietphieuxuat> getChitietphieuxuats() {
		return this.chitietphieuxuats;
	}

	public void setChitietphieuxuats(Set<Chitietphieuxuat> chitietphieuxuats) {
		this.chitietphieuxuats = chitietphieuxuats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hanghoa")
	public Set<Chitietchuyenkho> getChitietchuyenkhos() {
		return this.chitietchuyenkhos;
	}

	public void setChitietchuyenkhos(Set<Chitietchuyenkho> chitietchuyenkhos) {
		this.chitietchuyenkhos = chitietchuyenkhos;
	}

	@Override
	public String toString() {
		return this.getTen();
	}

}
