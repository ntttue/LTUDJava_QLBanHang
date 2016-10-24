package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khohang;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

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
	
	public Khohang getKhoHang(int id){
		return (Khohang) super.find(Khohang.class, id);
	}

	public List<Khohang> getKhoHangList() {
		Session session = HibernateFactory.openSession();
		List<Khohang> nhanviens = null;
		try {
			String hql = "FROM Khohang";
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
