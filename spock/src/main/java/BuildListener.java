public class BuildListener {

    private final Notifier notification;

    public BuildListener(Notifier notification) {
        if (notification.checkCompatibility(System.getProperty("os.name"))) {
            throw new IllegalArgumentException("Notifier not compatible with current os");
        }
        this.notification = notification;
    }

    public void onSuccess(BuildResult result) {
        if (notification.isReady()) {
            notification.send("Build success !");
        }
    }
}
