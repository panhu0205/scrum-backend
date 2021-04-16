package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ShipperUser")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "username")
    private String username;
    
    @Column( name = "FirstName")
    private String firstName;
    
    @Column( name = "LastName")
    private String lastName;
    
    @Column( name = "PhoneNumber")
    private String phoneNumber;
    
    @Column( name = "DoB")
    private Date dob;
    
    @Column( name = "VehiclesType")
    private String vehiclesType;
    
    @Column( name = "VehiclesNumber")
    private String vehiclesNumber;
}
