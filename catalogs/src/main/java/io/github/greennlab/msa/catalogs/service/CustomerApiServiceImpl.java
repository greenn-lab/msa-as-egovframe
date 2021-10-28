package io.github.greennlab.msa.catalogs.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerApiServiceImpl implements CustomerApiService {

  private final RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "getCustomerDetailFallback")
  @Override
  public String getCustomerDetail(String customerId) {
    final String url = "http://customer/customers/" + customerId;

    return restTemplate.getForObject(url, String.class);
  }

  @SuppressWarnings("unused")
  private String getCustomerDetailFallback(String customerId, Throwable thrown) {
    return String.format("Sorry for too late loading %s information: %s",
        customerId,
        thrown.getMessage());
  }

}
