package io.github.greennlab.msa.catalogs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerApiServiceImpl implements CustomerApiService {

  @Override
  public String getCustomerDetail(String customerId) {
    return customerId;
  }

}
