package com.interview.telenotesExample.api.v1.resource;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
public class TelenotesContacts {

  private List<TelenotesContact> telenotesContactList;

}
