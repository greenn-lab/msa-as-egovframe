package io.github.greennlab.msa.catalogs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerApiServiceImpl implements CustomerApiService {

  private final RestTemplate restTemplate;

  @Override
  public String getCustomerDetail(String customerId) {
    final String url = "http://localhost:8082/customers/" + customerId;

    return restTemplate.getForObject(url, String.class);
  }

}
