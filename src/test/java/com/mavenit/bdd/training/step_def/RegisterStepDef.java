package com.mavenit.bdd.training.step_def;

import com.mavenit.bdd.training.page_objects.RegisterPage;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class RegisterStepDef {

    @When("^I provide email register details as below:$")
    public void i_provide_email_register_details_as_below(List<Map<String, String>> data) {
        new RegisterPage().doRegister(data.get(0).get("gender"),data.get(0).get("fitst_name"),data.get(0).get("last_name"),data.get(0).get("email"),data.get(0).get("password"),data.get(0).get("confirm_passowd"));
    }

}
