package views;

public class BaseViewImpl extends ViewActions implements BaseView{

    BaseViewElements baseViewElements;

    public BaseViewImpl(){
        this.baseViewElements = new BaseViewElements();
    }

    public Boolean isLoaded() {
        return findElement(baseViewElements.loadRewardedVideoBtn) != null;
    }

    public Boolean loadRewardedVideo() {
        return click(baseViewElements.loadRewardedVideoBtn,
                baseViewElements.showRewardedVideoBtn,
                30);
    }

    public Boolean loadInterstitialVideo() {
        return click(baseViewElements.loadInterstitialVideoBtn,
                baseViewElements.showInterstitialVideoBtn,
                30);
    }

    public Boolean loadInterstitialAd() {
        return click(baseViewElements.loadInterstitialAdBtn,
                baseViewElements.showInterstitialAdBtn,
                30);
    }

    public Boolean showRewardedVideo() {
        return click(baseViewElements.showRewardedVideoBtn,
                10,
                baseViewElements.showRewardedVideoBtn);
    }

    public Boolean showInterstitialVideo() {
        return click(baseViewElements.showInterstitialVideoBtn,
                10,
                baseViewElements.showInterstitialVideoBtn);
    }

    public Boolean showInterstitialAd() {
        return click(baseViewElements.showInterstitialAdBtn,
                10,
                baseViewElements.showInterstitialAdBtn);
    }
}
