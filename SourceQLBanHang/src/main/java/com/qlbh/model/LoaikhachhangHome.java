package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;
import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Loaikhachhang;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Loaikhachhang.
 * @see com.qlbh.model.Loaikhachhang
 * @author Hibernate Tools
 */
@Stateless
public class LoaikhachhangHome extends AbstractDao {
	final static Logger logger = Logger.getLogger(KhachhangHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Loaikhachhang.class);
	}
	public Loaikhachhang findById(Integer id) throws DataAccessLayerException {
		Loaikhachhang lkh = (Loaikhachhang)super.findById(Loaikhachhang.class, id);
		return lkh;
	}
	public void save(Loaikhachhang lkh) {
		super.save(lkh);
		super.saveNhatKy("Loại khách hàng", "Thêm");
	}
	public void update(Loaikhachhang lkh) {
		super.update(lkh);
		super.saveNhatKy("Loại khách hàng", "Cập nhật");
	}
	public void deletePermanently(Loaikhachhang lkh) {
		super.delete(lkh);
		super.saveNhatKy("Loại khách hàng", "Xóa");
	}
	public void delete(Loaikhachhang lkh) {
		lkh.setActivity(false);
		super.update(lkh);
		super.saveNhatKy("Loại khách hàng", "Xóa");
	}
}
