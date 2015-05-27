import spock.lang.Specification

class BlockSpec extends Specification {

    def "fail when size is not the expected one"() {
        given:
        def list = []

        when:
        list.add(1)

        then:
        list.size() == 10
    }
}
