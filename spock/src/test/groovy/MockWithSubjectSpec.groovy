import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import spock.lang.Specification

class MockWithSubjectSpec extends Specification {

    @Collaborator
    Notifier notifier = Mock()

    @Subject
    BuildListener listener

    def "should send notification when build succeed"() {
        when:
        listener.onSuccess(new BuildResult())

        then:
        1 * notifier.isReady() >> true
        1 * notifier.send("Build success !")
    }
}
