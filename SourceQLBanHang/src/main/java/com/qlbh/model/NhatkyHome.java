package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Nhatky;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Tygia.
 * 
 * @see com.qlbh.model.Tygia
 * @author Hibernate Tools
 */
@Stateless
public class NhatkyHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(NhatkyHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Nhatky.class);
	}

	public void save(Nhatky obj) {
		super.save(obj);
	}

	public void update(Nhatky obj) {
		super.update(obj);
	}

	public void deletePermanently(Nhatky obj) {
		super.delete(obj);
	}

	public void delete(Nhatky obj) {
		obj.setActivity(false);
		obj.setNgay(null);
		super.update(obj);
	}
}
