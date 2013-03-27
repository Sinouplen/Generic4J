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
public abstract class AbstractJpaDAO<T extends Serializable, PK extends Serializable>
		extends AbstractDAO<T> implements IGenericDAO<T, PK> {

	@PersistenceContext
	EntityManager entityManager;

	public T getById(final PK id) {
		return this.entityManager.find(this.currentClass, id);
	}

	public List<T> getAll() {
		return CastTrouble.castList(
				this.currentClass,
				this.entityManager.createQuery(
						"from " + this.currentClass.getName()).getResultList());
	}

	public void create(final T entity) {
		this.entityManager.persist(entity);
	}

	public void update(final T entity) {
		this.entityManager.merge(entity);
	}

	public void delete(final T entity) {
		this.entityManager.remove(entity);
	}

	public void deleteById(final PK entityId) {
		final T entity = this.getById(entityId);

		this.delete(entity);
	}
}
