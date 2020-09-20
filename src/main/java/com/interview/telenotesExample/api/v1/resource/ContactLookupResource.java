package com.interview.telenotesExample.api.v1.resource;


import com.interview.telenotesExample.api.v1.service.InboxService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactLookupResource {

  @Autowired
  private InboxService inboxService;

  @ApiOperation(value = "A simple call that will verify our mailbox is accessible.")
  @GetMapping("/verifyInbox")
  public Boolean verifyInbox() {

    //The boolean we will use to keep track of what we find about the inbox
    Boolean isInboxConnected = false;

    //find out what the inbox is looking like, from our little inbox service
    isInboxConnected = inboxService.verifyInboxConnected();

    //return the what we found about the inbox being connected
    return isInboxConnected;
  }
}
