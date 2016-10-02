package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Nguoidung;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateUtil;
import java.util.List;

/**
 * Home object for domain model class Nguoidung.
 * 
 * @see com.qlbh.model.Nguoidung
 * @author Hibernate Tools
 */
@Stateless
public class NguoidungHome extends AbstractDao {

	final static Logger logger = Logger.getLogger(NguoidungHome.class);
	Session session = HibernateUtil.getSessionFactory().openSession();

	public void create(Nguoidung nd) throws DataAccessLayerException {
		super.saveOrUpdate(nd);
	}

	public NguoidungHome() {
		super();
	}

	public Nguoidung findByUsenamePass(String tenDangNhap, String matKhau) {
		Nguoidung nd = new Nguoidung();
		String hql = "from Nguoidung nd where nd.tennd = :tennd and nd.matkhau = :matkhau";
		// String hql = "from Nguoidung";

		Query query = session.createQuery(hql);
		query.setParameter("tennd", tenDangNhap);
		query.setParameter("matkhau", matKhau);
		List<Nguoidung> ds = query.list();
		if (!ds.isEmpty()) {
			nd = ds.get(0);
			System.out.println(nd.getTennd());
			return nd;
		}

		return null;
	}
}
