package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Donvitinh;
import com.qlbh.util.DataAccessLayerException;

@Stateless
public class DonvitinhHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(DonvitinhHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Donvitinh.class);
	}

	public void save(Donvitinh dvt) {
		super.save(dvt);
		super.saveNhatKy("Đơn vị tính", "Thêm");
	}

	public void update(Donvitinh dvt) {
		super.update(dvt);
		super.saveNhatKy("Đơn vị tính", "Cập nhật");
	}

	public void delete(Donvitinh dvt) {
		dvt.setActivity(false);
		super.update(dvt);
		super.saveNhatKy("Đơn vị tính", "Xóa");
	}
}
