package com.qlbh.model.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

public abstract class AbstractDao {
    private Session session;
    private Transaction tx;
    final static Logger logger = Logger.getLogger(AbstractDao.class);

    public AbstractDao() {
        HibernateFactory.buildIfNeeded();
    }
    
    protected void saveOrUpdate(Object obj) {
    	try {
    		startOperation();
    		session.saveOrUpdate(obj);
    		tx.commit();
    	} catch (HibernateException e) {
    		handleException(e);
    	} finally {
    		HibernateFactory.close(session);
    	}
    }
    
    protected void update(Object obj) {
    	try {
    		startOperation();
    		session.update(obj);
    		tx.commit();
    	} catch (HibernateException e) {
    		handleException(e);
    	} finally {
    		HibernateFactory.close(session);
    	}
    }

    protected void save(Object obj) {
        try {
            startOperation();
            session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected void delete(Object obj) {
        try {
            startOperation();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected Object find(Class clazz, Integer id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }

    protected List findAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }

    protected void handleException(HibernateException e){
        HibernateFactory.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        session = HibernateFactory.openSession();
        tx = session.beginTransaction();
    }
}