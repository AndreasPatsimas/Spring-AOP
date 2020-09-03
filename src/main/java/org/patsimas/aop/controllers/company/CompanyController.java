package org.patsimas.aop.controllers.company;

import org.patsimas.aop.models.Company;
import org.patsimas.aop.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/add/company/{id}/{name}")
    public Company addCompany(@PathVariable("id") String id,
                              @PathVariable("name") String name) {
        return companyService.createCompany(id, name);
    }
}
