package com.projects.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"delivery_man\"")
public class DeliveryMan implements Serializable {
  
  private static final long serialVersionUID = 5491943028700542523L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "address", nullable = false)
  private String address;
  
  @Column(name = "cellphone", nullable = false)
  private String cellphone;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "vehicle_id")
  private Vehicle vehicle;
  
  @Column(name = "date_create")
  private Date dateCreate;
  
  @Column(name = "username_create")
  private String usernameCreate;
  
  @Column(name = "date_update")
  private Date dateUpdate;
  
  @Column(name = "username_update")
  private String usernameUpdate;
  
}
