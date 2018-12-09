package testWatcher;

import org.apache.log4j.Logger;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import testsBase.TestsBaseUtils;

import java.util.Properties;

public class TestBaseWatcher {

    static Logger log = Logger.getLogger(TestBaseWatcher.class);
    public static Properties properties = new Properties();
    public static Description classDescription;

    @ClassRule
    public static TestRule classWatcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            classDescription = description;
            TestsBaseUtils.loadLogProperties();
            TestsBaseUtils.loadProperties(properties);
            log.info("@"+description.getClassName());
            log.info(description.getAnnotation(TestClassDescription.class).info());
            log.info("Priority = " + description.getAnnotation(TestClassDescription.class).priority());
            log.info("Created by = " + description.getAnnotation(TestClassDescription.class).createdBy());
            String envStr = "Env =" ;
            for (String en : description.getAnnotation(TestClassDescription.class).env()){
                envStr+= " "+ en;
            }
            log.info(envStr);
            log.info("@Tests");
        }

        @Override
        protected void failed(Throwable e, Description description) {
        }

        @Override
        protected void succeeded(Description description) {
        }

        @Override
        protected void finished(Description description) {
            log.info("@Info");
            log.info("@Logs");
        }
    };


    @Rule
    public TestWatcher testWatcher= new TestWatcher() {

        @Override
        protected void starting(Description description) {
            System.out.print("\n"+description.getAnnotation(TestDescription.class).value() + " .. ");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.print("Fail");
        }

        @Override
        protected void succeeded(Description description) {
            System.out.print("Ok");
        }
    };
}
