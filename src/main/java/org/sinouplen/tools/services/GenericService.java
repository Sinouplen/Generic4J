/**
 * 
 */
package org.sinouplen.tools.services;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.sinouplen.tools.CastTrouble;
import org.sinouplen.tools.dao.IGenericDAO;
import org.sinouplen.tools.services.exception.GenericServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sinouplen
 * 
 */
@Transactional
public abstract class GenericService<T extends Serializable, K extends Serializable, D extends IGenericDAO<T, K>>
		implements IGenericService<T, K, D> {

	private static final Logger LOGGER = Logger.getLogger(GenericService.class);
	
	private static final String CREATE = "Create ";

	protected Class<T> entityClass;

	protected D baseDao;

	/**
	 * @param entity
	 */
	public void setEntityClass(T entity) {
		this.entityClass = CastTrouble.getClass(entity);
	}

	/**
	 * @param baseDao
	 */
	public void setBaseDao(D baseDao) {
		this.baseDao = baseDao;
		this.baseDao.setClazz(this.entityClass);
	}

	/**
	 * @param entity
	 * @param baseDAO
	 */
	@Autowired
	public void setGenericParameters(T entity, D baseDAO) {
		this.setEntityClass(entity);
		this.setBaseDao(baseDAO);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.services.IGenericService#get(java.io.Serializable)
	 */
	public T get(final K primaryKey) throws GenericServiceException {

		T returnObject = null;

		try {
			LOGGER.info(CREATE + entityClass);
			returnObject = this.baseDao.getById(primaryKey);
		} catch (Exception e) {
			LOGGER.error("Error during get " + entityClass, e);
			throw new GenericServiceException(e);
		}
		return returnObject;
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.services.IGenericService#getList(java.util.List)
	 */
	public List<T> getList(final List<K> primaryKeys)
			throws GenericServiceException {

		List<T> returnObject = null;

		try {
			LOGGER.info(CREATE + entityClass);
			returnObject = this.baseDao.getByIds(primaryKeys);
		} catch (Exception e) {
			LOGGER.error("Error during listing all " + entityClass, e);
			throw new GenericServiceException(e);
		}
		return returnObject;
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.services.IGenericService#create(java.lang.Object)
	 */
	public void create(final T newInstance) throws GenericServiceException {
		try {
			LOGGER.info(CREATE + entityClass);
			this.baseDao.create(newInstance);
		} catch (Exception e) {
			LOGGER.error("Error during creating " + entityClass, e);
			throw new GenericServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.services.IGenericService#update(java.lang.Object)
	 */
	public void update(final T newInstance) throws GenericServiceException {
		try {
			LOGGER.info(CREATE + entityClass);
			this.baseDao.update(newInstance);
		} catch (Exception e) {
			LOGGER.error("Error during updating " + entityClass, e);
			throw new GenericServiceException(e);
		}
	}
}
