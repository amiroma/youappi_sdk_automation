package views;

import org.openqa.selenium.By;

public class VideoViewElements {

    public static final String PLATFORM = "platform";

    protected By videoContainer;
    protected By skipBtn;
    protected By learnMoreBtn;

    public VideoViewElements(){
        setLocators();
    }

    private void setLocators(){
        if (System.getProperty(PLATFORM).toLowerCase().equals("android")){
            loadAndroid();
        }else
            loadIos();
    }

    private void loadAndroid(){
        skipBtn = By.xpath("//android.widget.TextView[contains(@text,'Skip')]");
        learnMoreBtn =  By.xpath("//android.widget.TextView[contains(@text,'Learn more')]");
    }
    private void loadIos(){
        skipBtn = By.xpath("//*[contains(@name,'Skip')]");
        learnMoreBtn = By.name("Learn More");
    }
}
