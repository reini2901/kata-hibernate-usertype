package hibernate;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTypeTest  {

	private static final String NAME = "reini";

	@Test
	public void test1() {
		Manager mgr = new Manager();

		mgr.createAndStoreEvent(NAME);

		List<SimpleEntity> all = mgr.findAll();
		for (SimpleEntity simpleEntity : all) {
			Assert.assertEquals(simpleEntity.getUserName(), NAME);
		}

		HibernateUtil.getSessionFactory().close();
	}
	
}
