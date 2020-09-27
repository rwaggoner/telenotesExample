package com.interview.telenotesExample.api.v1.controller;


import com.interview.telenotesExample.api.v1.resource.TelenotesContact;
import com.interview.telenotesExample.api.v1.resource.TelenotesContacts;
import com.interview.telenotesExample.api.v1.rest.RestClient;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TelenotesContactController {

  private RestClient restClient = new RestClient();

  private Logger logger = LoggerFactory.getLogger(TelenotesContactController.class);

  public TelenotesContacts getAllContacts() {

    //Grab all contacts from the api
    TelenotesContact[] allContactsApiResponse = restClient.getContacts();

    //Create the new resource that will hold our list of contacts
    TelenotesContacts contactsResult = new TelenotesContacts();
    contactsResult.setTelenotesContactList(Arrays.asList(allContactsApiResponse));

    //Return whatever we found
    return contactsResult;
  }

}
