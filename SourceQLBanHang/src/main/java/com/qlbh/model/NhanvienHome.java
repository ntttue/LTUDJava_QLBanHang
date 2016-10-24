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
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Nhanvien.
 * 
 * @see com.qlbh.model.Nhanvien
 * @author Hibernate Tools
 */
@Stateless
public class NhanvienHome extends AbstractDao {

	private static final Logger logger = Logger.getLogger(NhanvienHome.class);
	private Session session;

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Nhanvien.class);
	}

	/*
	 * save checksave
	 * */
	public Boolean saveReturnObj(Nhanvien obj) {
		Integer result = super.saveReturnID(obj);
		System.out.println(result);
		if (result != null) {
			return true;
		}
		return false;
	}

	public Boolean update(Nhanvien obj) {
		try {
			super.update(obj);
			return true;
		} catch (Exception e) {
			logger.error("error in update Nhanvien:  \n" + e.getMessage());
		}
		return false;
	}

	public void deletePermanently(Nhanvien obj) {
		super.delete(obj);
	}

	public void delete(Nhanvien obj) {
		obj.setActivity(false);
		super.update(obj);
	}

	public Nhanvien findByMa(String ma) {
		Nhanvien nv = null;
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			// startOperation();
			String hql = "from Nhanvien bp where bp.ma = :ma and activity = true";
			Query query = session.createQuery(hql);
			query.setParameter("ma", ma);
			List<Nhanvien> ds = query.list();
			if (!ds.isEmpty()) {
				nv = new Nhanvien();
				nv = ds.get(0);
				System.out.println(nv.getTen());
			}
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findByMa:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return nv;
	}

	public List<Nhanvien> getNhanVienList() {
		Session session = HibernateFactory.openSession();
		List<Nhanvien> nhanviens = null;
		try {
			String hql = "FROM Nhanvien Where Activity = true";
			Query query = session.createQuery(hql);
			nhanviens = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return nhanviens;
	}
}
