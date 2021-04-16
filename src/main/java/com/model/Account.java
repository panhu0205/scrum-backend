package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    @Column( name = "Username")
    private String username;
    
    @Column( name = "Password")
    private String password;
    
}
