package io.github.greennlab.msa.customers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomersController {

  @GetMapping("{customerId}")
  public String getCustomerDetail(@PathVariable String customerId) {
    return String.format("{Customer id = %s at %d}",
        customerId,
        System.currentTimeMillis());
  }

}
