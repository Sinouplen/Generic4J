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
public abstract class GenericService<T extends Serializable, ID extends Serializable, DAO extends IGenericDAO<T, ID>>
		implements IGenericService<T, ID, DAO> {

	private final static Logger LOGGER = Logger.getLogger(GenericService.class);

	protected Class<T> entityClass;

	protected DAO baseDao;

	public void setEntityClass(T entity) {
		this.entityClass = CastTrouble.getClass(entity);
	}

	public void setBaseDao(DAO baseDao) {
		this.baseDao = baseDao;
		this.baseDao.setClazz(this.entityClass);
	}

	@Autowired
	public void setGenericParameters(T entity, DAO baseDAO) {
		this.setEntityClass(entity);
		this.setBaseDao(baseDAO);
	}

	public T get(final ID primaryKey) throws Exception {

		T returnObject = null;

		try {
			LOGGER.info("create " + entityClass);
			returnObject = this.baseDao.getById(primaryKey);
		} catch (Throwable e) {
			LOGGER.error("Error during listing all " + entityClass, e);
			throw new GenericServiceException(e);
		}
		return returnObject;
	}

	public List<T> getList(final List<ID> primaryKeys) throws Exception {

		List<T> returnObject = null;

		try {
			LOGGER.info("create " + entityClass);
			returnObject = this.baseDao.getByIds(primaryKeys);
		} catch (Throwable e) {
			LOGGER.error("Error during listing all " + entityClass, e);
			throw new GenericServiceException(e);
		}
		return returnObject;
	}

	public void create(final T newInstance) throws Exception {
		try {
			LOGGER.info("create " + entityClass);
			this.baseDao.create(newInstance);
		} catch (Throwable e) {
			LOGGER.error("Error during creating " + entityClass, e);
			throw new GenericServiceException(e);
		}
	}

	public void update(final T newInstance) throws Exception {
		try {
			LOGGER.info("create " + entityClass);
			this.baseDao.update(newInstance);
		} catch (Throwable e) {
			LOGGER.error("Error during updating " + entityClass, e);
			throw new GenericServiceException(e);
		}
	}
}
