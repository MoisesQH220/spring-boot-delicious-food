package com.projects.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"vehicle\"")
public class Vehicle implements Serializable {
  
  private static final long serialVersionUID = 5491943028700542523L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;
  
  @Column(name = "type", nullable = false)
  private String type;
  
  @Column(name = "make", nullable = false)
  private String make;
  
  @Column(name = "license_plate", nullable = false)
  private String licensePlate;
  
  @Column(name = "date_create")
  private Date dateCreate;
  
  @Column(name = "username_create")
  private String usernameCreate;
  
  @Column(name = "date_update")
  private Date dateUpdate;
  
  @Column(name = "username_update")
  private String usernameUpdate;
  
}
