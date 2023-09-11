package com.mycompany.group234.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.mycompany.group234.model.Bus;
import com.mycompany.group234.model.Route;
import com.mycompany.group234.model.Driver;
import com.mycompany.group234.model.Trip;
import com.mycompany.group234.converter.DurationConverter;
import com.mycompany.group234.converter.UUIDToByteConverter;
import com.mycompany.group234.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Bus")
@Table(name = "\"Bus\"", schema =  "\"generated_app\"")
@Data
                        
public class Bus {
	public Bus () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"BusId\"", nullable = true )
  private Integer busId;
	  
  @Column(name = "\"BusNumber\"", nullable = true )
  private String busNumber;
  
	  
  @Column(name = "\"MfgDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date mfgDate;  
  
	  
  @Column(name = "\"Capacity\"", nullable = true )
  private Integer capacity;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"BusDrivers\"",
            joinColumns = @JoinColumn( name="\"BusId\""),
            inverseJoinColumns = @JoinColumn( name="\"DriverId\""), schema = "\"generated_app\"")
private List<Driver> drivers = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"BusTrips\"",
            joinColumns = @JoinColumn( name="\"BusId\""),
            inverseJoinColumns = @JoinColumn( name="\"TripId\""), schema = "\"generated_app\"")
private List<Trip> trips = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Bus [" 
  + "BusId= " + busId  + ", " 
  + "BusNumber= " + busNumber  + ", " 
  + "MfgDate= " + mfgDate  + ", " 
  + "Capacity= " + capacity 
 + "]";
	}
	
}