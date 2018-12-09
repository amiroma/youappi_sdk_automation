package views;

public class VideoViewImpl extends ViewActions implements VideoView{

    private VideoViewElements videoViewElements;

    public VideoViewImpl(){
        this.videoViewElements = new VideoViewElements();
    }

    public Boolean isLoaded() {
        return findElement(videoViewElements.videoContainer) != null; // TODO: change to container id
    }

    public Boolean skip() {
        return click(videoViewElements.skipBtn,
                20,
                videoViewElements.skipBtn); // TODO : change to container id
    }

    public Boolean clickLearnMore() {
        return null;
    }

}
