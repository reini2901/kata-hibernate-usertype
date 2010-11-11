package hibernate;

import java.util.List;

import hibernate.util.HibernateUtil;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Query;
import org.hibernate.Session;

public class Manager {

	

	void storeSimple(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		SimpleEntity simpleEntity = new SimpleEntity();
		simpleEntity.setUserName(name);

		session.save(simpleEntity);
		session.getTransaction().commit();
	}

	void storeEnhanced(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		BetterEntity be = new BetterEntity();
		Person person = new Person();
		person.setName(name);
		
		be.setPerson(person);
		
		session.save(be);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<SimpleEntity> findAllSimple() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery(" from SimpleEntity");
		List result = query.list();
		
		session.getTransaction().commit();
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<BetterEntity> findAllBetter() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery(" from BetterEntity");
		List result = query.list();
		
		session.getTransaction().commit();
		
		return result;
	}

}
