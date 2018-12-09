package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import testWatcher.TestClassDescription;
import testWatcher.TestDescription;
import testsBase.TestsBase;

@TestClassDescription(
        info ="flow going to test these steps ... ",
        priority = TestClassDescription.Priority.HIGH,
        createdBy = "amiro",
        env = {"qa","staging"})
public class demoTest extends TestsBase {

    @Ignore
    @Test
    @TestDescription("testing  1 bla bla")
    public void testRewarded(){
        Assert.assertTrue(baseView.isLoaded());
        Assert.assertTrue(baseView.loadRewardedVideo());
        Assert.assertTrue(baseView.showRewardedVideo());
    }

    @Ignore
    @Test
    @TestDescription("testing 2 bla bla")
    public void testInterstitial(){
        Assert.assertTrue(baseView.isLoaded());
        Assert.assertTrue(baseView.loadInterstitialVideo());
        Assert.assertTrue(baseView.showInterstitialVideo());
        // videoView.isLoaded(); // missing container id
        Assert.assertTrue(videoView.skip());
        if (adView.isLoaded()) {Assert.assertTrue(adView.close());}
        Assert.assertTrue(baseView.isLoaded());
    }

    @Test
    @TestDescription("load ad view , verify and click close button")
    public void testAd(){
        Assert.assertTrue(baseView.isLoaded());
        Assert.assertTrue(baseView.loadInterstitialAd());
        Assert.assertTrue(baseView.showInterstitialAd());
        Assert.assertTrue(adView.isLoaded());
        /*eyesSession.checkWindow("views.AdView");
        eyesSession.checkWindow(classDescription.getClassName(), "views.AdView");*/
        Assert.assertTrue(adView.close());
        Assert.assertTrue(baseView.isLoaded());
    }
}
