#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;

public abstract class AppComponentTests {

    static {
        CONFIG_FILES = new String[]{"classpath:conf/test-context.xml"};
    }

    private ApplicationContext applicationConfig;

    private final static String[] CONFIG_FILES;

    @BeforeClass
    public void setupSuite () {
        applicationConfig = getApplicationContext();
    }

    protected ApplicationContext getApplicationContext () {

        if (applicationConfig == null) {
            applicationConfig = new ClassPathXmlApplicationContext(CONFIG_FILES);
        }

        return applicationConfig;
    }

}
