package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khuvuc;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Khuvuc.
 * @see com.qlbh.model.Khuvuc
 * @author Hibernate Tools
 */
@Stateless
public class KhuvucHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(KhuvucHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Khuvuc.class);
	}
	public void save(Khuvuc khuVuc) {
		super.save(khuVuc);
	}
	public void update(Khuvuc khuVuc) {
		super.update(khuVuc);
	}
	public void deletePermanently(Khuvuc khuVuc) {
		super.delete(khuVuc);
	}
	public void delete(Khuvuc khuVuc) {
		khuVuc.setActivity(false);
		super.update(khuVuc);
	}
}
