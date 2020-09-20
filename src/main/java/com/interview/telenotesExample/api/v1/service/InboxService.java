package com.interview.telenotesExample.api.v1.service;

import java.net.URI;
import javax.annotation.PostConstruct;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InboxService {

  Logger logger = LoggerFactory.getLogger(InboxService.class);

  private  ExchangeService exchangeService;

  private final String emailAddress = "telenotes.canidate@telenotes.com";
  private final String emailPassword ="Mux08925";
  private final String emailDomain = "Telenotes.local";
  private final String emailUrl = "https://outlook.office365.com/EWS/Exchange.asmx";


  /**
   * Small helper method we will use just to do the initial setup work for our exchange inbox
   */
  @PostConstruct
  private void setupExchangeService() {

    try {

      //If the service is null, which is should be in the post construct, lets populate it
      //so the other code can actually use it
      if (exchangeService == null) {

        //We are just going to use 2010, because that is what an example had...
        exchangeService = new ExchangeService(ExchangeVersion.Exchange2010_SP2);

        //Use all of the email properties we have to create our credientals for the server
        ExchangeCredentials credentials = new WebCredentials(emailAddress, emailPassword, emailDomain);
        exchangeService.setCredentials(credentials);

        //Set the location of the mail box...
        exchangeService.setUrl(new URI(emailUrl));

      }
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }


  /**
   * This method will take the email properties already set up in the class
   * and try to ensure we have a real connection with those properties
   * @return A {@link Boolean} - True if we could make a connection, False if we could not
   */
  public Boolean verifyInboxConnected() {

    Boolean isInboxConnected = Boolean.FALSE;

    try {

      //Pretty simple check to make sure all is well and we can connect to the server
      exchangeService.validate();
      isInboxConnected = Boolean.TRUE;

    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    //REturn whether or not we were able to connect to the mail box
    return isInboxConnected;
  }


}
