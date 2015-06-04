import spock.lang.Specification

class ExceptionSpec extends Specification {

    def "should not throw exception"() {
        when:
        [1].get(0)

        then:
        noExceptionThrown()
    }

    def "should not throw IndexOutOfBoundsException"() {
        when:
        [1].get(0)

        then:
        notThrown(IndexOutOfBoundsException)
    }

    def "should throw exception"() {
        when:
        [1].get(1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def "should throw exception with message"() {
        when:
        [1].get(1)

        then:
        IndexOutOfBoundsException e = thrown()
        e.message == 'Index: 1, Size: 1'
    }
}
