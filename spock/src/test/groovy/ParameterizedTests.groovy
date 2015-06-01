import spock.genesis.Gen
import spock.lang.Specification
import spock.lang.Unroll

class ParameterizedTests extends Specification {

    def "should return maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 2 || 2
        2 | 1 || 2
        1 | 0 || 1
        0 | 0 || 0
    }

    @Unroll
    def "maximum of #a and #b should be #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 2 || 2
        2 | 1 || 2
        1 | 0 || 1
        0 | 0 || 0
    }

    def "even numbers"() {
        expect:
        a % 2 == 0

        where:
        a << [0, 2, 4, 6]
    }

    @Unroll
    def 'test reverse #string'() {
        when:
        String reversed = string.reverse()

        then: 'It maintains length'
        reversed.size() == string.size()

        and: 'It is not destructive'
        reversed.reverse() == string

        where:
        string << Gen.these('', 'aba', 'aa').then(Gen.string).take(10000)
    }
}
