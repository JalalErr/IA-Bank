package com.ebankservice.ebnakservice.feign;

import com.ebankservice.ebnakservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers")
    Customer getCustomerById(@PathVariable Long id);
}
