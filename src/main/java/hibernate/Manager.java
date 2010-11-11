package hibernate;

import java.util.List;

import hibernate.util.HibernateUtil;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Query;
import org.hibernate.Session;

public class Manager {

	public static void main(String[] args) {
		Manager mgr = new Manager();

		mgr.createAndStoreEvent("reini");

		List<SimpleEntity> all = mgr.findAll();
		for (SimpleEntity simpleEntity : all) {
			System.out
					.println(ToStringBuilder.reflectionToString(simpleEntity));
		}

		HibernateUtil.getSessionFactory().close();

	}

	private void createAndStoreEvent(String name) {
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
