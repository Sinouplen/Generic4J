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
public abstract class AbstractHibernateDAO<T extends Serializable, K extends Serializable>
		extends AbstractDAO<T> implements IGenericDAO<T, K> {

	@Autowired
	SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#getById(java.io.Serializable)
	 */
	public T getById(final K id) {
		return CastTrouble.cast(this.currentClass, this.getCurrentSession()
				.get(this.currentClass, id));
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#getByIds(java.util.List)
	 */
	public List<T> getByIds(final List<K> ids) {
		return CastTrouble.castList(
				this.currentClass,
				this.getCurrentSession().createCriteria(this.currentClass)
						.add(Restrictions.in("id", ids)).list());
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#getAll()
	 */
	public List<T> getAll() {
		return CastTrouble.castList(this.currentClass, this.getCurrentSession()
				.createQuery("from " + this.currentClass.getName()).list());
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#create(java.lang.Object)
	 */
	public void create(final T entity) {
		this.getCurrentSession().persist(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#update(java.lang.Object)
	 */
	public void update(final T entity) {
		this.getCurrentSession().merge(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#delete(java.lang.Object)
	 */
	public void delete(final T entity) {
		this.getCurrentSession().delete(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#deleteById(java.io.Serializable)
	 */
	public void deleteById(final K entityId) {
		final T entity = this.getById(entityId);

		this.delete(entity);
	}

	/* (non-Javadoc)
	 * @see org.sinouplen.tools.dao.IGenericDAO#findByCriteria(java.util.List)
	 */
	public List<T> findByCriteria(List<Criterion> criterions) {
		Criteria criteria = this.getCurrentSession().createCriteria(
				this.currentClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return CastTrouble.castList(this.currentClass, criteria.list());
	}

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return
	 */
	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
