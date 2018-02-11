package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class HajibootJpaApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.err.println(created + " is created!");

    Pageable pageable = new PageRequest(0, 3);
    Page<Customer> page = customerRepository.findAllOrderByName(pageable);

    System.err.println("1 ページのデータ数: " + page.getSize());
    System.err.println("現在のページ: " + page.getNumber());
    System.err.println("全ページ数: " + page.getTotalPages());
    System.err.println("全データ数: " + page.getTotalElements());

    page.getContent().forEach(System.err::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJpaApplication.class, args);
	}

}
