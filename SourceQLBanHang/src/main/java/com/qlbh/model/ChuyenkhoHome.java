package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;
import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Chuyenkho;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Chuyenkho.
 * @see com.qlbh.model.Chuyenkho
 * @author Hibernate Tools
 */
@Stateless
public class ChuyenkhoHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(ChuyenkhoHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Chuyenkho.class);
	}

	public void save(Chuyenkho chuyenKho) {
		super.save(chuyenKho);
		super.saveNhatKy("Chuyển kho", "Thêm");
	}

	public void update(Chuyenkho chuyenKho) {
		super.update(chuyenKho);
		super.saveNhatKy("Chuyển kho", "Cập nhật");
	}

	public void deletePermanently(Chuyenkho chuyenKho) {
		super.delete(chuyenKho);
		super.saveNhatKy("Chuyển kho", "Xóa");
	}

	public void delete(Chuyenkho chuyenKho) {
		chuyenKho.setActivity(false);
		super.update(chuyenKho);
		super.saveNhatKy("Chuyển kho", "Xóa");
	}
}
