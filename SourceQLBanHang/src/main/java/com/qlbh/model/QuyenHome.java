package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Quyen;
import com.qlbh.util.DataAccessLayerException;

/**
 * Home object for domain model class Tygia.
 * @see com.qlbh.model.Tygia
 * @author Hibernate Tools
 */
@Stateless
public class QuyenHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(QuyenHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Quyen.class);
	}
}
