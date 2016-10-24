package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khuvuc;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Khuvuc.
 * 
 * @see com.qlbh.model.Khuvuc
 * @author Hibernate Tools
 */
@Stateless
public class KhuvucHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(KhuvucHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Khuvuc.class);
	}

	public void save(Khuvuc khuVuc) {
		super.save(khuVuc);
	}

	public void update(Khuvuc khuVuc) {
		super.update(khuVuc);
	}

	public void deletePermanently(Khuvuc khuVuc) {
		super.delete(khuVuc);
	}

	public void delete(Khuvuc khuVuc) {
		khuVuc.setActivity(false);
		super.update(khuVuc);
	}
	
	public List<Khuvuc> getKhuVucList() {
		Session session = HibernateFactory.openSession();
		List<Khuvuc> khuvucs = null;
		try {
			String hql = "FROM Khuvuc Where Activity = true";
			Query query = session.createQuery(hql);
			khuvucs = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return khuvucs;
	}
}
