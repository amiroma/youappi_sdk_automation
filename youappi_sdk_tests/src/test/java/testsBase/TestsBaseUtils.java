package testsBase;

import com.applitools.eyes.Eyes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import testWatcher.TestBaseWatcher;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class TestsBaseUtils {

    static Logger log = Logger.getLogger(TestsBaseUtils.class);

    static InputStream input = null;

    /**
     * load config propeties file into properties Object
     *
     * @param props - project config properties file
     */
    public static void loadProperties(Properties props){
        try {
            input = new FileInputStream("./src/main/resources/config.properties");
            props.load(input);
            TestBaseWatcher.properties = props;
        }
        catch (Exception e){
            log.error("load properties file failed");
        }
    }

    /**
     * load log4j configuration file
     */
    public static void loadLogProperties(){
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }
}
