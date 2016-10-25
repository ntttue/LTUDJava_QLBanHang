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

import com.qlbh.pojo.Nhacungcap;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Nhacungcap.
 * 
 * @see com.qlbh.model.Nhacungcap
 * @author Hibernate Tools
 */
@Stateless
public class NhacungcapHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(NhacungcapHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Nhacungcap.class);
	}

	public void save(Nhacungcap ncc) {
		super.save(ncc);
		super.saveNhatKy("Nhà cung cấp", "Thêm");
	}

	public void update(Nhacungcap ncc) {
		super.update(ncc);
		super.saveNhatKy("Nhà cung cấp", "Cập nhật");
	}

	public void delete(Nhacungcap ncc) {
		ncc.setActivity(false);
		super.update(ncc);
		super.saveNhatKy("Nhà cung cấp", "Xóa");
	}

	public List<Nhacungcap> getNhaCungCapList() {
		Session session = HibernateFactory.openSession();
		List<Nhacungcap> khohangs = null;
		try {
			String hql = "FROM Nhacungcap Where Activity = true";
			Query query = session.createQuery(hql);
			khohangs = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return khohangs;
	}
}
