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
import com.qlbh.pojo.Nguoidung;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Tygia.
 * 
 * @see com.qlbh.model.Tygia
 * @author Hibernate Tools
 */
@Stateless
public class KeepLoggedHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(KeepLoggedHome.class);
	private Session session;

	public List<Keeplogged> findAll() throws DataAccessLayerException {
		return super.findAll(KeepLoggedHome.class);
	}

	public Keeplogged findFirst() {
		Keeplogged keeplogged = null;
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			// startOperation();
			String hql = "from Keeplogged";
			Query query = session.createQuery(hql);
			List<Keeplogged> ds = query.list();
			if (!ds.isEmpty()) {
				keeplogged = new Keeplogged();
				keeplogged = ds.get(0);
			}
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findFirst:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return keeplogged;
	}

	public void save(Keeplogged obj) {
		this.deleteAll();
		super.save(obj);
	}

	public void update(Keeplogged obj) {
		super.update(obj);
	}

	public void delete(Keeplogged obj) {
		super.delete(obj);
	}

	public void deleteAll() {
		try {
			System.out.println("dell all");
			session = HibernateFactory.getSessionFactory().openSession();
			// startOperation();
			String hql = "from Keeplogged";
			Query query = session.createQuery(hql);
			List<Keeplogged> ds = query.list();
			for (Keeplogged keeplogged : ds) {
				this.delete(keeplogged);
			}
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in deleteAll:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
	}
}
