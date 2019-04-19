package hrsystem;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/applicationContext-*.xml","classpath:/config/applicationContext-beans-*.xml","classpath:/config/applicationContext-beans.xml"})
public class BaseTest {
	 
}
