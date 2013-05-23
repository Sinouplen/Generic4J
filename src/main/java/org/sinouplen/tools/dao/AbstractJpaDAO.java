/**
 * 
 */
package org.sinouplen.tools.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sinouplen.tools.CastTrouble;

/**
 * @author Sinouplen
 * 
 */
public abstract class AbstractJpaDAO<T extends Serializable, K extends Serializable>
		extends AbstractDAO<T> implements IGenericDAO<T, K> {

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#getById(java.io.Serializable)
	 */
	public T getById(final K id) {
		return this.entityManager.find(this.currentClass, id);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#getAll()
	 */
	public List<T> getAll() {
		return CastTrouble.castList(this.currentClass, this.entityManager
				.createQuery("from " + this.currentClass.getName())
				.getResultList());
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#create(java.lang.Object)
	 */
	public void create(final T entity) {
		this.entityManager.persist(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#update(java.lang.Object)
	 */
	public void update(final T entity) {
		this.entityManager.merge(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#delete(java.lang.Object)
	 */
	public void delete(final T entity) {
		this.entityManager.remove(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#deleteById(java.io.Serializable)
	 */
	public void deleteById(final K entityId) {
		final T entity = this.getById(entityId);

		this.delete(entity);
	}
}
