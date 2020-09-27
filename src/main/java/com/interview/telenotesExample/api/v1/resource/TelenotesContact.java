package com.interview.telenotesExample.api.v1.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.interview.telenotesExample.api.v1.model.Address;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelenotesContact implements Serializable {

  private Long id;

  private String firstName;
  private String lastName;
  private String title;
  private String email;

  //Phones
  private String phone;
  private String ext;
  private String mobilePhone;
  private String fax;

  private Address address;

  private boolean deleted;

  @JsonInclude(value= Include.NON_NULL)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private Date deletedDate;

  private Long account;
  private String dept;

  @JsonInclude(value= JsonInclude.Include.NON_NULL)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private Date birthday;






}
