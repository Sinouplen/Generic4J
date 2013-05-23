package org.sinouplen.tools.services;

import java.io.Serializable;
import java.util.List;

import org.sinouplen.tools.dao.IGenericDAO;
import org.sinouplen.tools.services.exception.GenericServiceException;

/**
 * @author Sinouplen
 * 
 */
public interface IGenericService<T, K extends Serializable, D extends IGenericDAO<T, K>> {

	/**
	 * @param id
	 * @return
	 * @throws GenericServiceException
	 */
	T get(K id) throws GenericServiceException;

	/**
	 * @param ids
	 * @return
	 * @throws GenericServiceException
	 */
	List<T> getList(List<K> ids) throws GenericServiceException;

	/**
	 * @param newInstance
	 * @throws GenericServiceException
	 */
	void create(final T newInstance) throws GenericServiceException;

	/**
	 * @param newInstance
	 * @throws GenericServiceException
	 */
	void update(final T newInstance) throws GenericServiceException;
}
