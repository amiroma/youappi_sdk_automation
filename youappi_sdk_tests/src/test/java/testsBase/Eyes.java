package testsBase;

import testWatcher.TestBaseWatcher;
import views.ViewActions;

public class Eyes {

    protected static com.applitools.eyes.Eyes eyes;
    public Eyes(){
        eyes = new com.applitools.eyes.Eyes();
        eyes.setApiKey(TestBaseWatcher.properties.getProperty("eyesApiKey"));
    }

    /**
     * check onetime screenshot with open & close session
     * @param testStep - step name
     */
    public void checkWindow(String testStep){
        eyes.testWindow(ViewActions.driver, testStep, testStep);
    }

    /**
     * check multiple screenshots in one flow
     *
     * @param testName - flow name
     * @param testStep - step name
     */
    public void checkWindow(String testName, String testStep){
        if (!eyes.getIsOpen()){
            eyes.open(ViewActions.driver,"AppDemo", testName);
        }
        eyes.checkWindow(testStep);
    }

    /**
     *  close and check mismatches for multiple flow checks
     * @return
     */
    public Boolean checkResults(){
        return eyes.close(false).getMismatches() == 0;
    }
}
