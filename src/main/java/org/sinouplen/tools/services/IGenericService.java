package org.sinouplen.tools.services;

import java.io.Serializable;
import java.util.List;

import org.sinouplen.tools.dao.IGenericDAO;

/**
 * @author Sinouplen
 * 
 */
public interface IGenericService<T, ID extends Serializable, DAO extends IGenericDAO<T, ID>> {

	public T get(ID id) throws Exception;

	public List<T> getList(List<ID> ids) throws Exception;

	public void create(final T newInstance) throws Exception;

	public void update(final T newInstance) throws Exception;
}
