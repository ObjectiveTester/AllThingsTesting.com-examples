package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.*;
import java.util.List;
import org.junit.Assert;

public class MathDefinitions {

    private int value1;
    private int value2;
    private int actual;

    @Given("I have {int} and {int}")
    public void i_have(int first, int second) {
        value1 = first;
        value2 = second;
    }

    @When("I multiply the values")
    public void multiply() {
        actual = value1 * value2;
    }

    @When("I add the values")
    public void add() {
        actual = value1 + value2;
    }

    @Then("The result should be {int}")
    public void the_result_should_be(Integer expected) {
        Assert.assertEquals(expected, actual, 0);
    }

    @Given("I add a series of values")
    public void i_add_a_series_of_values(DataTable dt) {
        List<List<String>> list = dt.asLists(String.class);
        //i starts from 1 if there is a header
        for (int i = 0; i < list.size(); i++) {
            value1 = Integer.valueOf(list.get(i).get(0));
            value2 = Integer.valueOf(list.get(i).get(1));
            add();
            System.out.println(value1 + "+" + value2 + "=" + actual);
            the_result_should_be(Integer.valueOf(list.get(i).get(2)));

        }
    }

    @When("I multiply a series of values")
    public void i_multiply_a_series_of_values(DataTable dt) {
        List<List<String>> list = dt.asLists(String.class);
        //i starts from 1 if there is a header
        for (int i = 1; i < list.size(); i++) {
            value1 = Integer.valueOf(list.get(i).get(0));
            value2 = Integer.valueOf(list.get(i).get(1));
            multiply();
            System.out.println(value1 + "*" + value2 + "=" + actual);
            the_result_should_be(Integer.valueOf(list.get(i).get(2)));
        }
    }
}

