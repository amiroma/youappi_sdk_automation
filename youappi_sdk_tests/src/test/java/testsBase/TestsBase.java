package testsBase;

import mobileSession.MobileSession;
import mobileSession.MobileSessionImpl;
import org.apache.log4j.Logger;
import org.junit.*;
import testWatcher.TestBaseWatcher;
import views.*;


public class TestsBase extends TestBaseWatcher {

    static Logger log = Logger.getLogger(TestsBase.class);
    static MobileSession mobileSession = new MobileSessionImpl();
    protected BaseView baseView = new BaseViewImpl();
    protected VideoView videoView = new VideoViewImpl();
    protected AdView adView = new AdViewImpl();
    protected static Eyes eyesSession = new Eyes();


    @BeforeClass
    public static void init() {
        Assert.assertNotNull(mobileSession.start());
    }

    @AfterClass
    public static void clean() {
        mobileSession.stop();
        //Assert.assertTrue(eyesSession.checkResults());
    }

}
