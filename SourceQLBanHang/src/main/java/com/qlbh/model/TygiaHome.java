package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateUtil;

/**
 * Home object for domain model class Tygia.
 * @see com.qlbh.model.Tygia
 * @author Hibernate Tools
 */
@Stateless
public class TygiaHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(TygiaHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Tygia.class);
	}
}
