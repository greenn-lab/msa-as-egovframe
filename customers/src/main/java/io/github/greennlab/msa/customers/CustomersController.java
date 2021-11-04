package io.github.greennlab.msa.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
@Slf4j
public class CustomersController {

  @GetMapping("{customerId}")
  public String getCustomerDetail(@PathVariable String customerId) {
    final String message = String.format("{Customer id = %s at %d}",
        customerId,
        System.currentTimeMillis());

    log.info("[CUSTOMERS] {}", message);

    return message;
  }

}
