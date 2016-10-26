package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.pojo.Quyen;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

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
	
	public List<Quyen> getQuyenList() {
		Session session = HibernateFactory.openSession();
		List<Quyen> quyens = null;
		try {
			String hql = "FROM Quyen Where Activity = true";
			Query query = session.createQuery(hql);
			quyens = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return quyens;
	}
	
	
}
