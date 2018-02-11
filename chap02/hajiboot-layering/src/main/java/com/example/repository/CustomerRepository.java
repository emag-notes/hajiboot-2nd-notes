package com.example.repository;

import com.example.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {

  private final Map<Integer, Customer> customerMap = new ConcurrentHashMap<>();

  public List<Customer> findAll() {
    return new ArrayList<>(customerMap.values());
  }

  public Customer findOne(Integer customerId) {
    return customerMap.get(customerId);
  }

  public Customer save(Customer customer) {
    return customerMap.put(customer.getId(), customer);
  }

  public void delete(Integer customerId) {
    customerMap.remove(customerId);
  }

}
