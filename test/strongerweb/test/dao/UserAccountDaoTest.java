package strongerweb.test.dao;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import strongerweb.dao.UserAccount;
import strongerweb.dao.UserAccountDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {	"classpath:strongerweb/xmlconfig/dao-context.xml",
		"classpath:strongerweb/xmlconfig/service-context.xml",
		"classpath:strongerweb/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAccountDaoTest {
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from useraccount");
	}
	
	@Test
	public void testCreate() {
		UserAccount userAccount = new UserAccount("Madman", "hellohello");
		assertTrue("Should be able to create account", userAccountDao.create(userAccount));
		assertEquals("Should have user in list of accounts", userAccountDao.getUserAccounts().get(0).getUsername(), "Madman");
		assertEquals("Shouldn't have password in list of accounts", userAccountDao.getUserAccounts().get(0).getPassword(), null);
		
		int userId = userAccountDao.getUserAccounts().get(0).getId();
		assertEquals("Should be able to get user by id", userAccountDao.getUserAccount(userId).getUsername(), "Madman");
	}
	
	
}
