package mobileSession;

import io.appium.java_client.AppiumDriver;

public interface MobileSession {
    AppiumDriver start();
    void stop();
}
