public class BuildListener {

    private final Notifier notification;

    public BuildListener(Notifier notification) {
        this.notification = notification;
    }

    public void onSuccess(BuildResult result) {
        if (notification.isReady()) {
            notification.send("Build success !");
        }
    }
}
