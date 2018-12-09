package views;


public class AdViewImpl extends ViewActions implements AdView{

    private AdViewElements adViewElements;

    public AdViewImpl(){
        this.adViewElements = new AdViewElements();
    }

    public Boolean isLoaded() {
            if (driver.getContextHandles().size() > 1) {
                driver.context(driver.getContextHandles().toArray()[1].toString());
                return findElement(adViewElements.adContainer) != null;
            } else {
                return false;
            }
    }

    public Boolean close() {
        driver.context(driver.getContextHandles().toArray()[1].toString());
        if (click(adViewElements.closeBtn, defaultWait)){
            driver.context("NATIVE_APP");
            return true;
        }
        return false;
    }

    public Boolean clickDownload() {
        return click(adViewElements.downloadBtn, defaultWait);
    }

    public Boolean clickLearnMore() {
        return click(adViewElements.learnMoreBtn, defaultWait);
    }


}
