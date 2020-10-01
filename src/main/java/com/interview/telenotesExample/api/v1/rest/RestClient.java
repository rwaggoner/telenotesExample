package com.interview.telenotesExample.api.v1.rest;

import com.interview.telenotesExample.api.v1.resource.TelenotesContact;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public class RestClient {

  private final String telenotesBaseUrlGetContacts = "https://jpi.telenotes.com/candidate/emailContacts";

  public TelenotesContact[] getContacts() {

    CloseableHttpClient httpClient = HttpClients.custom()
        .setSSLHostnameVerifier(new NoopHostnameVerifier())
        .build();
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);
    TelenotesContact[] result = restTemplate.getForObject(telenotesBaseUrlGetContacts, TelenotesContact[].class);

    return result;
  }

}
