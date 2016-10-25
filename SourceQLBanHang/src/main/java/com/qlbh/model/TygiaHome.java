package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Tygia.
 * 
 * @see com.qlbh.model.Tygia
 * @author Hibernate Tools
 */
@Stateless
public class TygiaHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(TygiaHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Tygia.class);
	}

	public void save(Tygia tyGia) {
		super.save(tyGia);
		super.saveNhatKy("Tỷ giá", "Thêm");
	}

	public void update(Tygia tyGia) {
		super.update(tyGia);
		super.saveNhatKy("Tỷ giá", "Cập nhật");
	}

	public void deletePermanently(Tygia tyGia) {
		super.delete(tyGia);
		super.saveNhatKy("Tỷ giá", "Xóa");
	}

	public void delete(Tygia tyGia) {
		tyGia.setActivity(false);
		super.update(tyGia);
		super.saveNhatKy("Tỷ giá", "Xóa");
	}
}
