package io.github.greennlab.msa.catalogs;

import io.github.greennlab.msa.catalogs.service.CustomerApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("catalogs/customer-info")
@RequiredArgsConstructor
@Slf4j
public class CatalogsController {

  private final CustomerApiService service;

  private final Environment env;

  @GetMapping("{customerId}")
  public String getCustomerInfo(@PathVariable String customerId) {
    final String info = service.getCustomerDetail(customerId);

    final String message = String.format("[Customer id = %s at %s %s ]",
        customerId,
        System.currentTimeMillis(),
        info);


    log.info("[CATALOGS] {}", message);

    return message;
  }

  @GetMapping("env")
  public String getEnvironments(String property) {
    return env.getProperty(property);
  }

}
