package org.patsimas.aop.services;

import org.patsimas.aop.models.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    public Company createCompany(String id, String name) {

        return Company.builder()
                .id(id)
                .name(name)
                .build();
    }
}
