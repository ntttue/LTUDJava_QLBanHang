package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khohang;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Khohang.
 * 
 * @see com.qlbh.model.Khohang
 * @author Hibernate Tools
 */
@Stateless
public class KhohangHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(KhohangHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Khohang.class);
	}

	public void save(Khohang kh) {
		super.save(kh);
	}

	public void update(Khohang kh) {
		super.update(kh);
	}

	public void delete(Khohang kh) {
		kh.setActivity(false);
		super.update(kh);
	}
}
