package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Bophan;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Bophan.
 * 
 * @see com.qlbh.model.Bophan
 * @author Hibernate Tools
 */
@Stateless
public class BophanHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(BophanHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Bophan.class);
	}

	public void save(Bophan obj) {
		super.save(obj);
	}

	public void update(Bophan obj) {
		super.update(obj);
	}

	public void deletePermanently(Bophan obj) {
		super.delete(obj);
	}

	public void delete(Bophan obj) {
		obj.setActivity(false);
		super.update(obj);
	}
}
