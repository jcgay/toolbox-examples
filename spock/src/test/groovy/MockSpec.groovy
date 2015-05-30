import spock.lang.Specification

class MockSpec extends Specification {

    Notifier notifier = Mock()

    BuildListener listener = new BuildListener(notifier)

    def "should send notification when build succeed"() {
        when:
        listener.onSuccess(new BuildResult())

        then:
        1 * notifier.isReady() >> true
        1 * notifier.send("Build success !")
    }

    def "should send notification when build succeed (stub)"() {
        given:
        notifier.isReady() >> true

        when:
        listener.onSuccess(new BuildResult())

        then:
        1 * notifier.send("Build success !")
    }

    def "should send notification when build succeed (argument captor)"() {
        def captured

        given:
        notifier.isReady() >> true

        when:
        listener.onSuccess(new BuildResult())

        then:
        1 * notifier.send(_) >> { arguments -> captured = arguments[0] }

        captured == "Build success !"
    }
}
