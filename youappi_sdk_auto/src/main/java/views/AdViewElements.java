package views;

import org.openqa.selenium.By;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM;

public class AdViewElements {


    protected By adContainer;
    protected By closeBtn;
    protected By downloadBtn;
    protected By learnMoreBtn;

    public AdViewElements(){
        setLocators();
    }

    private void setLocators(){
        if (System.getProperty(PLATFORM).toLowerCase().equals("android")){
            loadAndroid();
        }else
            loadIos();
    }

    private void loadAndroid(){
        adContainer = By.id("youAppiAd");
        closeBtn = By.id("close");
        downloadBtn = By.id("downloadBtn");
        learnMoreBtn = By.name("Learn More");
    }

    private void loadIos(){
        adContainer = By.id("youAppiAd");
        closeBtn = By.id("close");
        downloadBtn = By.id("downloadBtn");
        learnMoreBtn = By.name("Learn More");

    }
}
