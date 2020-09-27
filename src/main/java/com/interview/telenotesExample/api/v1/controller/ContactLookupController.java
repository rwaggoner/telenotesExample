package com.interview.telenotesExample.api.v1.controller;

import com.interview.telenotesExample.api.v1.model.SearchType;
import com.interview.telenotesExample.api.v1.resource.TelenotesContact;
import com.interview.telenotesExample.api.v1.resource.TelenotesContacts;
import com.sun.tools.javac.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactLookupController {

  Logger logger = LoggerFactory.getLogger(ContactLookupController.class);

  @Autowired
  private InboxController inboxController;

  @Autowired
  private TelenotesContactController telenotesContactController;

  private List<TelenotesContact> commonContacts;

  public TelenotesContacts findBySearchType(SearchType searchType) {

    //The List of contacts we are going to return
    TelenotesContacts searchedContacts = new TelenotesContacts();
    searchedContacts.setTelenotesContactList(new ArrayList<>());

    //First we need a list of contacts we can be search, so make sure we have that list
    if(commonContacts == null && commonContacts.size() <= 0)
    {
      //If we do not have our list of contact, try to get one
      populateCommonContacts();
    }

    //Check the list of contacts again
    if(commonContacts != null && commonContacts.size() > 0)
    {
      //Now we know we have contacts, so we can do some searching
      searchContacts(searchType);

    } else {
      logger.error("Could not find any common contacts to search.");
    }

    //Return whatever we found, even if it was nothing
    return searchedContacts;
  }

  private void searchContacts(SearchType searchType) {
  }

  private void populateCommonContacts() {
  }
}
