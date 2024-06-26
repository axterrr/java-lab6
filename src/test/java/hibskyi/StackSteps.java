package hibskyi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StackSteps {

    private Stack<String> stack;
    private String poppedValue;

    @Given("an empty stack")
    public void an_empty_stack() {
        stack = new Stack<>();
    }

    @When("I push {string} into the stack")
    public void i_push_into_the_stack(String value) {
        stack.push(value);
    }

    @When("I pop from the stack")
    public void i_pop_from_the_stack() {
        poppedValue = stack.pop();
    }

    @Then("the value popped from the stack should be {string}")
    public void the_value_popped_from_the_stack_should_be(String expected) {
        assertThat(poppedValue).isEqualTo(expected);
    }

    @Then("the size of the stack should be {int}")
    public void the_size_of_the_stack_should_be(int expected) {
        assertThat(stack.size()).isEqualTo(expected);
    }

    @Then("the stack should be empty")
    public void the_stack_should_be_empty() {
        assertThat(stack.size()).isEqualTo(0);
    }
}
