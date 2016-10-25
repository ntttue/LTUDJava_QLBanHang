package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Keeplogged;
import com.qlbh.pojo.Phieuxuat;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Phieuxuat.
 * 
 * @see com.qlbh.model.Phieuxuat
 * @author Hibernate Tools
 */
@Stateless
public class PhieuxuatHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(PhieuxuatHome.class);
	private Session session;

	public List findAll() throws DataAccessLayerException {
//		 System.out.println("find all");
		 return super.findAll(Phieuxuat.class);
//		try {
//			session = HibernateFactory.getSessionFactory().openSession();
//			// startOperation();
//			String hql = "from "+Phieuxuat.class+" where activity = true";
//			Query query = session.createQuery(hql);
//			List<Phieuxuat> ds = query.list();
//			return ds;
//		} catch (HibernateException e) {
//			handleException(e);
//			logger.error("error in findFirst:  \n" + e.getMessage());
//		} finally {
//			HibernateFactory.close(session);
//		}
//		return null;
	}

	public void save(Phieuxuat phieuXuat) {
		super.save(phieuXuat);
	}

	public void update(Phieuxuat phieuXuat) {
		super.update(phieuXuat);
	}

	public void deletePermanently(Phieuxuat phieuXuat) {
		super.delete(phieuXuat);
	}

	public void delete(Phieuxuat phieuXuat) {
		phieuXuat.setActivity(false);
		super.update(phieuXuat);
	}
}
