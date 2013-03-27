package org.sinouplen.tools.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * @author Sinouplen
 * 
 */
public interface IGenericDAO<T, PK extends Serializable> {

	public void setClazz(final Class<T> currentClass);

	public T getById(final PK id);

	public List<T> getByIds(final List<PK> id);

	public List<T> getAll();

	public List<T> findByCriteria(List<Criterion> criterions);

	void create(final T newInstance);

	void update(final T transientObject);

	void delete(final T persistentObject);

	void deleteById(final PK idObject);
}
