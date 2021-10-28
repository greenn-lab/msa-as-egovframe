package io.github.greennlab.msa.catalogs;

import io.github.greennlab.msa.catalogs.service.CustomerApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalogs/customer-info")
@RequiredArgsConstructor
public class CatalogsController {

  private final CustomerApiService service;

  @GetMapping("{customerId}")
  public String getCustomerInfo(@PathVariable String customerId) {
    final String info = service.getCustomerDetail(customerId);

    return String.format("[Customer id = %s at %s %s ]",
        customerId,
        System.currentTimeMillis(),
        info);
  }

}
