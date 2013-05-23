package org.sinouplen.tools.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * @author Sinouplen
 * 
 */
public interface IGenericDAO<T, K extends Serializable> {

	/**
	 * @param currentClass
	 */
	void setClazz(final Class<T> currentClass);

	/**
	 * @param id
	 * @return
	 */
	T getById(final K id);

	/**
	 * @param id
	 * @return
	 */
	List<T> getByIds(final List<K> id);

	/**
	 * @return
	 */
	List<T> getAll();

	/**
	 * @param criterions
	 * @return
	 */
	List<T> findByCriteria(List<Criterion> criterions);

	/**
	 * @param newInstance
	 */
	void create(final T newInstance);

	/**
	 * @param transientObject
	 */
	void update(final T transientObject);

	/**
	 * @param persistentObject
	 */
	void delete(final T persistentObject);

	/**
	 * @param idObject
	 */
	void deleteById(final K idObject);
}
