package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khachhang;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateUtil;

/**
 * Home object for domain model class Khachhang.
 * 
 * @see com.qlbh.model.Khachhang
 * @author Hibernate Tools
 */
@Stateless
public class KhachhangHome extends AbstractDao {
	final static Logger logger = Logger.getLogger(KhachhangHome.class);

	/**
	 * Finds all Events in the database.
	 * 
	 * @return
	 */
	public List findAll() throws DataAccessLayerException {
		return super.findAll(Khachhang.class);
	}
}
