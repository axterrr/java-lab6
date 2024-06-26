package hibskyi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StackTest {

    @Test
    void testSize() {
        Stack<Integer> stack = new Stack<>();
        assumeTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertThat(stack.size()).isEqualTo(3);
    }

    @ParameterizedTest()
    @CsvSource({
            "One, Two, Three",
            "Three, Two, One",
            "One, Three, Two",
            "One, One, One",
    })
    void testPushAndPop(String a, String b, String c) {
        assumeTrue(a!=null && b!=null && c!=null);
        Stack<String> stack = new Stack<>();
        stack.push(a);
        stack.push(b);
        stack.push(c);
        assertThat(stack.pop()).isEqualTo(c);
        assertThat(stack.pop()).isEqualTo(b);
        assertThat(stack.pop()).isEqualTo(a);
    }
}
