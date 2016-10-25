package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Nguoidung;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

import java.util.List;

/**
 * Home object for domain model class Nguoidung.
 * 
 * @see com.qlbh.model.Nguoidung
 * @author Hibernate Tools
 */
@Stateless
public class NguoidungHome extends AbstractDao {
	private Session session;
	final static Logger logger = Logger.getLogger(NguoidungHome.class);

	public void create(Nguoidung nd) throws DataAccessLayerException {
		super.save(nd);
		super.saveNhatKy("Người dùng", "Thêm");
	}

	public NguoidungHome() {
		super();
	}

	public void update(Nguoidung obj) {
		super.update(obj);
		super.saveNhatKy("Người dùng", "Cập nhật");
	}

	public Nguoidung findByUsenamePass(String tenDangNhap, String matKhau) {
		Nguoidung nd = null;
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			// startOperation();
			String hql = "from Nguoidung nd where nd.tennd = :tennd and nd.matkhau = :matkhau and activity = true";
			Query query = session.createQuery(hql);
			query.setParameter("tennd", tenDangNhap);
			query.setParameter("matkhau", matKhau);
			List<Nguoidung> ds = query.list();
			if (!ds.isEmpty()) {
				nd = new Nguoidung();
				nd = ds.get(0);
			}
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findByUsenamePass:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return nd;
	}
}
