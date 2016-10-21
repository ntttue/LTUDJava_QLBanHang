package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataAccessLayerException;


/**
 * Home object for domain model class Khachhang.
 * 
 * @see com.qlbh.model.Khachhang
 * @author Hibernate Tools
 */
@Stateless
public class KhachhangHome extends AbstractDao {
	final static Logger logger = Logger.getLogger(KhachhangHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Khachhang.class);
	}
	public Khachhang findById(Integer id) throws DataAccessLayerException {
		Khachhang kh = (Khachhang)super.find(Khachhang.class, id);
		return kh;
	}
	public void save(Khachhang khachHang) {
		super.save(khachHang);
	}
	public void update(Khachhang khachHang) {
		super.update(khachHang);
	}
	public void deletePermanently(Khachhang khachHang) {
		super.delete(khachHang);
	}
	public void delete(Khachhang khachHang) {
		khachHang.setActivity(false);
		super.update(khachHang);
	}
}
