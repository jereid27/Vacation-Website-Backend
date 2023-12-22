package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        if (customerRepository.count() == 1) {

            Division d = divisionRepository.findById(12L).orElse(null);


            Customer joe = new Customer("Joe", "Mama",
                    "321 West Street", "32012",
                    "8889991000", d);
            customerRepository.save(joe);

            Customer jason = new Customer("Jason", "Riede",
                    "123 Ocean Drive", "39389", "6667778888", d);
            customerRepository.save(jason);

            Customer abby = new Customer("Abby", "Riede",
                    "124 Ocean Drive", "36378", "8889991010", d);
            customerRepository.save(abby);

            Customer josie = new Customer("Josie", "Reid",
                    "8536 Ruth Lane", "39324", "9999999999", d);
            customerRepository.save(josie);

            Customer olivia = new Customer("Olivia", "Reed",
                    "301 Rainbow Road", "55586", "1112223333", d);
            customerRepository.save(olivia);
        }

    }
}
