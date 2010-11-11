package hibernate;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UserTypeTest  {

	private static final String NAME = "reini";

	@Test
	public void test1() {
		Manager mgr = new Manager();

		mgr.storeSimple(NAME);

		List<SimpleEntity> all = mgr.findAllSimple();
		for (SimpleEntity simpleEntity : all) {
			Assert.assertEquals(simpleEntity.getUserName(), NAME);
		}

	}

	@Test
	public void test2() {
		Manager mgr = new Manager();
		mgr.storeEnhanced(NAME);
		
		List<BetterEntity> all = mgr.findAllBetter();
		for (BetterEntity e : all) {
			Assert.assertEquals(e.getPerson().getName(), NAME);
		}
		
	}
	
	@AfterTest
	public void onEnd() {
		HibernateUtil.getSessionFactory().close();
	}
	
}
