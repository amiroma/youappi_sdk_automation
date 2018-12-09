package mobileSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import views.ViewActions;


public class MobileSessionImpl implements MobileSession {

    MobileSessionCapabilities sessionCapabilities;
    AppiumDriver driver;

    public MobileSessionImpl(){
        this.sessionCapabilities = new MobileSessionCapabilities();
    }


    public AppiumDriver start() {
        try {
            driver = new AppiumDriver(sessionCapabilities.capsObject.getEnv().getEnvUrl(System.getProperty("env").toLowerCase()), sessionCapabilities.capabilities);
            ViewActions.driver = driver;
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void stop() {
        try {
            driver.removeApp(sessionCapabilities.capabilities.getCapability("bundleId").toString());
            driver.quit();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
