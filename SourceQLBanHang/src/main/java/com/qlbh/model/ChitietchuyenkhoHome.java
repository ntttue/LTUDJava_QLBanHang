package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Chitietchuyenkho;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class ChitietchuyenkhoHome.
 * @see com.qlbh.model.Chitietchuyenkho
 * @author Hibernate Tools
 */
@Stateless
public class ChitietchuyenkhoHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(ChitietchuyenkhoHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Chitietchuyenkho.class);
	}

	public void save(Chitietchuyenkho ctck) {
		super.save(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Thêm");
	}

	public void update(Chitietchuyenkho ctck) {
		super.update(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Cập nhật");
	}

	public void deletePermanently(Chitietchuyenkho ctck) {
		super.delete(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Xóa");
	}

	public void delete(Chitietchuyenkho ctck) {
		ctck.setActivity(false);
		super.update(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Xóa");
	}
}
