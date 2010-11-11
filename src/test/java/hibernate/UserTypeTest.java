package hibernate;

import hibernate.util.HibernateUtil;

import java.util.List;

import static org.testng.Assert.*;
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

		assertEquals(checkDb(mgr),1);

	}

	private int checkDb(Manager mgr) {
		List<SimpleEntity> all = mgr.findAllSimple();
		for (SimpleEntity simpleEntity : all) {
			Assert.assertEquals(simpleEntity.getUserName(), NAME);
		}
		System.out.println("stored in db: " + all.size());
		return all.size();
	}

	@Test
	public void test2() {
		Manager mgr = new Manager();
		mgr.storeEnhanced(NAME);
		
		assertEquals(checkDb(mgr),2);
		
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
