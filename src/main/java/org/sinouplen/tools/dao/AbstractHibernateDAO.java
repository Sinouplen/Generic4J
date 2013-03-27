package org.sinouplen.tools.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.sinouplen.tools.CastTrouble;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sinouplen
 * 
 */
public abstract class AbstractHibernateDAO<T extends Serializable, PK extends Serializable>
		extends AbstractDAO<T> implements IGenericDAO<T, PK> {

	@Autowired
	SessionFactory sessionFactory;

	public T getById(final PK id) {
		return CastTrouble.cast(this.currentClass, this.getCurrentSession()
				.get(this.currentClass, id));
	}

	public List<T> getByIds(final List<PK> ids) {
		return CastTrouble.castList(
				this.currentClass,
				this.getCurrentSession().createCriteria(this.currentClass)
						.add(Restrictions.in("id", ids)).list());
	}

	public List<T> getAll() {
		return CastTrouble.castList(this.currentClass, this.getCurrentSession()
				.createQuery("from " + this.currentClass.getName()).list());
	}

	public void create(final T entity) {
		this.getCurrentSession().persist(entity);
	}

	public void update(final T entity) {
		this.getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		this.getCurrentSession().delete(entity);
	}

	public void deleteById(final PK entityId) {
		final T entity = this.getById(entityId);

		this.delete(entity);
	}

	public List<T> findByCriteria(List<Criterion> criterions) {
		Criteria criteria = this.getCurrentSession().createCriteria(
				this.currentClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return CastTrouble.castList(this.currentClass, criteria.list());
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
