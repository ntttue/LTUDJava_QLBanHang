package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.ArrayList;
import java.util.Date;
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
import com.qlbh.pojo.Chitietphieunhap;
import com.qlbh.pojo.Chitietphieuxuat;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Nhomhanghoa;
import com.qlbh.render.combobox.BaoCaoBanHang;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Chitietphieuxuat.
 * 
 * @see com.qlbh.model.Chitietphieuxuat
 * @author Hibernate Tools
 */
@Stateless
public class ChitietphieuxuatHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(ChitietphieuxuatHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Chitietphieuxuat transientInstance) {
		log.debug("persisting Chitietphieuxuat instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Chitietphieuxuat persistentInstance) {
		log.debug("removing Chitietphieuxuat instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Chitietphieuxuat merge(Chitietphieuxuat detachedInstance) {
		log.debug("merging Chitietphieuxuat instance");
		try {
			Chitietphieuxuat result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Chitietphieuxuat findById(Integer id) {
		log.debug("getting Chitietphieuxuat instance with id: " + id);
		try {
			Chitietphieuxuat instance = entityManager.find(Chitietphieuxuat.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Chitietphieuxuat> layDSChiTietTheoMaPhieuId(int id) {
		Session session = HibernateFactory.openSession();
		List<Chitietphieuxuat> loaiHangs = new ArrayList<>();
		try {
			String hql = "FROM Chitietphieuxuat Where phieuxuatid = :id and Activity = true";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			loaiHangs = query.list();
			System.out.println(loaiHangs.size());
			return loaiHangs;
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	public Chitietphieuxuat save(Chitietphieuxuat chitietphieuxuat) {
		super.save(chitietphieuxuat);
		return chitietphieuxuat;
	}

	public Chitietphieuxuat update(Chitietphieuxuat chitietphieuxuat) {
		super.update(chitietphieuxuat);
		return chitietphieuxuat;
	}

	public ArrayList<BaoCaoBanHang> LayBaoCaoBanHang(int khoId, Date dateFrom, Date dateTo) {
		ArrayList<BaoCaoBanHang> baoCaoBanHangs = new ArrayList<>();
		ArrayList<Chitietphieuxuat> chitietphieuxuats = new ArrayList<>();
		ArrayList<Integer> idList = new PhieuxuatHome().getPhieuXuatIdListByDate(khoId, dateFrom, dateTo);
		for (Integer id : idList) {
			List<Chitietphieuxuat> chitietphieuxuats2 = layDSChiTietTheoMaPhieuId(id);
			if (chitietphieuxuats2 != null) {
				chitietphieuxuats.addAll(chitietphieuxuats2);
			}
		}
		System.out.println(chitietphieuxuats.size());
		// Gom dữ liệu
		for (Chitietphieuxuat chitietphieuxuat : chitietphieuxuats) {
			boolean isNew = true;
			Hanghoa hanghoa = chitietphieuxuat.getHanghoa();
			for (BaoCaoBanHang baoCaoBanHang : baoCaoBanHangs) {
				if (baoCaoBanHang.getHanghoa().getId() == hanghoa.getId()) {
					isNew = false;
					baoCaoBanHang.setSoLuongXuat(baoCaoBanHang.getSoLuongXuat() + chitietphieuxuat.getSoluong());
					baoCaoBanHang.setDoanhSoBan(baoCaoBanHang.getDoanhSoBan() + chitietphieuxuat.getThanhtien());
				}
			}
			if (isNew) {
				BaoCaoBanHang banHang = new BaoCaoBanHang();
				banHang.setHanghoa(hanghoa);
				banHang.setSoLuongXuat(chitietphieuxuat.getSoluong());
				banHang.setDoanhSoBan(chitietphieuxuat.getThanhtien());
			}
		}

		for (BaoCaoBanHang banHang : baoCaoBanHangs) {
			banHang.setThanhTienNhap(banHang.getSoLuongXuat() * banHang.getHanghoa().getGiamua());
			banHang.setChenhLech(banHang.getDoanhSoBan() - banHang.getThanhTienNhap());
		}
		System.out.println(baoCaoBanHangs.size());
		return baoCaoBanHangs;
	}
}
