package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Hanghoa.
 * 
 * @see com.qlbh.model.Hanghoa
 * @author Hibernate Tools
 */
@Stateless
public class HanghoaHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(HanghoaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Hanghoa transientInstance) {
		log.debug("persisting Hanghoa instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Hanghoa persistentInstance) {
		log.debug("removing Hanghoa instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Hanghoa merge(Hanghoa detachedInstance) {
		log.debug("merging Hanghoa instance");
		try {
			Hanghoa result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Hanghoa findById(Integer id) {
		log.debug("getting Hanghoa instance with id: " + id);
		try {
			Hanghoa instance = (Hanghoa) super.find(Hanghoa.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Hanghoa> getHangHoaList() {
		Session session = HibernateFactory.openSession();
		List<Hanghoa> hanghoas = null;
		try {
			String hql = "FROM Hanghoa Where Activity = true";
			Query query = session.createQuery(hql);
			hanghoas = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return hanghoas;
	}

	public Hanghoa layHangHoaTheoKho(int id, int khoId) {
		Session session = HibernateFactory.openSession();
		Hanghoa hanghoa = null;
		try {
			String hql = "FROM Hanghoa Where id = :id and khohangid = :khoid and Activity = true";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setParameter("khoid", khoId);
			hanghoa = (Hanghoa) query.uniqueResult();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return hanghoa;
	}
	
	public Hanghoa layHangHoa(int id){
		Session session = HibernateFactory.openSession();
		Hanghoa hanghoa = null;
		try {
			String hql = "FROM Hanghoa Where id = :id and Activity = true";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			hanghoa = (Hanghoa) query.uniqueResult();
		} catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return hanghoa;
	}
	

	public void themSoLuongHangHoa(Hanghoa hanghoa, int khoid, int soLuong) {
		Hanghoa hangHoaResult = layHangHoaTheoKho(hanghoa.getId(), khoid);
		if (hangHoaResult == null) {
			Khohang khohang = new KhohangHome().getKhoHang(khoid);
			hanghoa.setKhohang(khohang);
			hanghoa.setId(0);
			hanghoa.setTonkho(soLuong);
			super.save(hanghoa);
			super.saveNhatKy("Hàng hóa", "Thêm số lượng");
			return;
		}
		hangHoaResult.setTonkho(hangHoaResult.getTonkho() + soLuong);
		super.update(hangHoaResult);
	}

	public void giamSoLuongHangHoa(Hanghoa hanghoa, int khoid, int soLuong) {
		Hanghoa hangHoaResult = layHangHoaTheoKho(hanghoa.getId(), khoid);
		if (hangHoaResult == null) {
			Khohang khohang = new KhohangHome().getKhoHang(khoid);
			hanghoa.setKhohang(khohang);
			hanghoa.setId(0);
			hanghoa.setTonkho(soLuong);
			super.save(hanghoa);
			super.saveNhatKy("Hàng hóa", "Giảm số lượng");
			return;
		}
		hangHoaResult.setTonkho(hangHoaResult.getTonkho() - soLuong);
		super.update(hangHoaResult);
	}
	
	public void themSoLuongHangHoa(Hanghoa hanghoa, int soLuong){
		Hanghoa hangHoaResult =layHangHoa(hanghoa.getId());
		hangHoaResult.setTonkho(hangHoaResult.getTonkho() + soLuong);
		super.update(hangHoaResult);
	}
	
	public void giamSoLuongHangHoa(Hanghoa hanghoa, int soLuong){
		Hanghoa hangHoaResult = layHangHoa(hanghoa.getId());
		hangHoaResult.setTonkho(hangHoaResult.getTonkho() -  soLuong);
		super.update(hangHoaResult);
	}
	
	public void delete(Hanghoa hanghoa) {
		hanghoa.setActivity(false);
		super.update(hanghoa);
		super.saveNhatKy("Hàng hóa", "Xóa");
	}
}
