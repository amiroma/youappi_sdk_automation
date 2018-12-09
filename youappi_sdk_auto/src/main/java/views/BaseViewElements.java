package views;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class BaseViewElements {

    public static final String PLATFORM = "platform";

    protected By loadRewardedVideoBtn;
    protected By showRewardedVideoBtn;
    protected By loadInterstitialVideoBtn;
    protected By showInterstitialVideoBtn;
    protected By loadInterstitialAdBtn;
    protected By showInterstitialAdBtn;

    public BaseViewElements(){
        setLocators();
    }

    private void setLocators(){
        if (System.getProperty(PLATFORM).toLowerCase().equals("android")){
            loadAndroid();
        }else
            loadIos();
    }

    private void loadAndroid(){
        loadRewardedVideoBtn = MobileBy.id("rewardedLoadVideoBtn");
        showRewardedVideoBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"SHOW REWARDED VIDEO\")");
        loadInterstitialVideoBtn = MobileBy.id("videoLoadBtn");
        showInterstitialVideoBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"SHOW VIDEO\")");
        loadInterstitialAdBtn = MobileBy.id("cardLoadBtn");
        showInterstitialAdBtn = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"SHOW CARD\")");
    }
    private void loadIos(){
        loadRewardedVideoBtn = MobileBy.name("Load Rewarded Video");
        showRewardedVideoBtn = MobileBy.name("Show Rewarded Video");
        loadInterstitialVideoBtn = MobileBy.name("Load Interstitial Video");
        showInterstitialVideoBtn = MobileBy.name("Show Interstitial Video");
        loadInterstitialAdBtn = MobileBy.name("Load Interstitial Ad");
        showInterstitialAdBtn = MobileBy.name("Show Interstitial Ad");
    }
}
