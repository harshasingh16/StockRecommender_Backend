package com.abhinendra.controllers;

import com.abhinendra.domain.CompanyDetails;
import com.abhinendra.domain.Person;
import com.abhinendra.services.CompanyDetailLoader;
import com.abhinendra.services.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController

@Api(tags = "/person", description = "Operations pertaining to person")
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private CompanyDetailLoader companyDetailLoader;
    @RequestMapping("/")
    public String check() {
    	return "Greetings";
    }
  /*  @RequestMapping("/api")
    public CompanyDetails getCompanyDetails()
    {
    	return companyDetailLoader.loadDetailsWithout();
    }
*/
    @GetMapping(value = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable("id") int id) throws Exception {
        return personService.findPersonById(id);
    }

    @GetMapping(value="/",produces="application/json")
    public Person findPersonByName(@RequestParam("name") String  name) throws Exception {
        System.out.println("Path param : "+name);
        return personService.findPersonByName(name);
    }

    @PostMapping(value = "/{name}",produces = "application/json")
    public Person savePerson(@PathVariable("name") String name) throws Exception {
         return personService.savePerson(name);
    }

}
