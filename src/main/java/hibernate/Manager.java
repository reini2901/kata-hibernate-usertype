package hibernate;

import java.util.List;

import hibernate.util.HibernateUtil;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Query;
import org.hibernate.Session;

public class Manager {

	

	void createAndStoreEvent(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		SimpleEntity simpleEntity = new SimpleEntity();
		simpleEntity.setUserName(name);

		session.save(simpleEntity);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<SimpleEntity> findAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery(" from SimpleEntity");
		List result = query.list();
		
		session.getTransaction().commit();
		
		return result;
	}

}
