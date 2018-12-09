package views;

public interface BaseView {

    Boolean isLoaded();
    Boolean loadRewardedVideo();
    Boolean loadInterstitialVideo();
    Boolean loadInterstitialAd();
    Boolean showRewardedVideo();
    Boolean showInterstitialVideo();
    Boolean showInterstitialAd();
}
