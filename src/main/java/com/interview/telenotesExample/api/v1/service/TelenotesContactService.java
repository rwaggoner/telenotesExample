package com.interview.telenotesExample.api.v1.service;

import com.interview.telenotesExample.api.v1.controller.TelenotesContactController;
import com.interview.telenotesExample.api.v1.resource.TelenotesContact;
import com.interview.telenotesExample.api.v1.resource.TelenotesContacts;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelenotesContactService {

  @Autowired
  private TelenotesContactController telenotesContactController;

  @ApiOperation(value = "This would get a contact, if implemented.")
  @GetMapping("/contacts/{id}")
  public TelenotesContact getContact() {
        return null;
  }

  @ApiOperation(value = "Get all contacts.")
  @GetMapping("/contacts")
  public TelenotesContacts getAllContacts() {

    //Return whatever we found
    return telenotesContactController.getAllContacts();
  }

  @ApiOperation(value = "This would add a contact, if implemented.")
  @PostMapping("/contacts")
  public TelenotesContact createContact() {
    return null;
  }

  @ApiOperation(value = "This would update a contact, if implemented.")
  @PutMapping("/contacts/{id}")
  public TelenotesContact updateContact() {
    return null;
  }

  @ApiOperation(value = "This would delete a contact, if implemented.")
  @DeleteMapping("/contacts/{id}")
  public Boolean deleteContact() {
    return true;
  }

}
