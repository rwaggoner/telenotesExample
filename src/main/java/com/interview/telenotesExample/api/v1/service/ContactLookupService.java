package com.interview.telenotesExample.api.v1.service;


import com.interview.telenotesExample.api.v1.controller.ContactLookupController;
import com.interview.telenotesExample.api.v1.model.SearchType;
import com.interview.telenotesExample.api.v1.resource.TelenotesContacts;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactLookupService {

  @Autowired
  private ContactLookupController contactLookupController;

  @ApiOperation(value = "Get contacts by specified search type.")
  @GetMapping("/findbysearchtype/{searchType}")
  public TelenotesContacts findBySearchType(@PathVariable("searchType") SearchType searchType) {

    //Return whatever we found
    return contactLookupController.findBySearchType(searchType);
  }

}
