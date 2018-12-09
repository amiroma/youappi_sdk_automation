package mobileSession;
import com.google.gson.Gson;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;

public class MobileSessionCapabilities {


    DesiredCapabilities capabilities;
    Caps capsObject = null;

    public MobileSessionCapabilities() {
        this.capabilities = new DesiredCapabilities();
        setCapabilities();
    }

    private void setCapabilities() {
        Gson gson = new Gson();
        try {
            capsObject = gson.fromJson(new FileReader("./src/main/resources/mobileSessionCaps/local.json"), Caps.class);
            // set values from input
            capabilities.setCapability("autoGrantPermissions", capsObject.getAutoGrantPermissions());
            capabilities.setCapability("autoAcceptAlerts", capsObject.getAutoAcceptAlerts());
            capabilities.setCapability("autoAcceptAlerts", capsObject.getWaitForQuiesence());
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, capsObject.getNewCommandTimeout());
                if (System.getProperty("platform").toLowerCase().equals("android")) {
                    capsObject.getEnv().getBrowserStack().setOs(System.getProperty(MobilePlatform.ANDROID));
                    capsObject.getAndroid().setPlatformVersion(System.getProperty("platformVersion"));
                    capsObject.getAndroid().setDeviceName(System.getProperty("deviceName"));
                    capsObject.getAndroid().setUdid(System.getProperty("deviceId"));
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                    capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, capsObject.getAndroid().getPlatformVersion());
                    capabilities.setCapability("chromedriverExecutableDir", capsObject.getAndroid().getChromedriverExecutableDir());
                    capabilities.setCapability("bundleId", capsObject.getAndroid().getApp(System.getProperty("app")).getBundleId());
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, capsObject.getAndroid().getAutomationName());
                    if (System.getProperty("env").toLowerCase().equals("browserstack")) {
                        loadBrowserStackCaps();
                    }else if (System.getProperty("env").toLowerCase().equals("bitbar")) {
                        loadBitBarCaps();
                    }else{
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, capsObject.getAndroid().getDeviceName());
                        capabilities.setCapability(MobileCapabilityType.UDID, capsObject.getAndroid().getUdid());
                        capabilities.setCapability(MobileCapabilityType.APP, capsObject.getAndroid().getApp(System.getProperty("app")).getUrl());
                        capabilities.setCapability("appActivity", capsObject.getAndroid().getApp(System.getProperty("app")).getAppActivity());
                        capabilities.setCapability("appPackage", capsObject.getAndroid().getApp(System.getProperty("app")).getAppPackage());
                    }
                } else {
                    capsObject.getEnv().getBrowserStack().setOs(System.getProperty(MobilePlatform.IOS));
                    capsObject.getIos().setPlatformVersion(System.getProperty("platformVersion"));
                    capsObject.getIos().setDeviceName(System.getProperty("deviceName"));
                    capsObject.getIos().setUdid(System.getProperty("deviceId"));
                    capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, capsObject.getIos().getAutomationName());
                    capabilities.setCapability("bundleId", capsObject.getIos().getApp(System.getProperty("app")).getBundleId());
                    if (System.getProperty("env").toLowerCase().equals("browserstack")) {
                        loadBrowserStackCaps();
                    }else if (System.getProperty("env").toLowerCase().equals("bitbar")) {
                        loadBitBarCaps();
                    }else {
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, capsObject.getIos().getPlatformVersion());
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, capsObject.getAndroid().getDeviceName());
                        capabilities.setCapability(MobileCapabilityType.APP, capsObject.getIos().getApp(System.getProperty("app")).getUrl());
                    }
                }
        }catch (Exception ee) {
            System.out.println(ee);
        }
    }

    private void loadBrowserStackCaps(){
        capsObject.getEnv().getBrowserStack().setDevice(System.getProperty("deviceName"));
        capsObject.getEnv().getBrowserStack().setOs_version(System.getProperty("platformVersion"));
        capabilities.setCapability("device", capsObject.getEnv().getBrowserStack().getDevice());
        capabilities.setCapability("browserstack.appium_version", capsObject.getEnv().getBrowserStack().getBrowserstackappium_version());
        capabilities.setCapability("os_version", capsObject.getEnv().getBrowserStack().getOs_version());
        capabilities.setCapability("app", "bs://4107cd1c5c2f61443eb7db8d87556cbfbe7245f6");
        capabilities.setCapability("browserstack.debug", capsObject.getEnv().getBrowserStack().getBrowserstackdebug());
    }

    private void loadBitBarCaps(){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, capsObject.getAndroid().getDeviceName());
        capabilities.setCapability("testdroid_target", "android");
        capabilities.setCapability("testdroid_apiKey", "gWAufM8RR7PjqqHYhNZPqIwl6uB7msZv");
        capabilities.setCapability("testdroid_project", "Project 3");
        capabilities.setCapability("testdroid_testrun", "Test Run 1");
        capabilities.setCapability("testdroid_device", capsObject.getAndroid().getDeviceName());
        capabilities.setCapability("testdroid_app", "latest");
    }

}