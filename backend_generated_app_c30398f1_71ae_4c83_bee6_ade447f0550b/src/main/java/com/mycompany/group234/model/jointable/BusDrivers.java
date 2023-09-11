package com.mycompany.group234.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.mycompany.group234.model.Bus;
import com.mycompany.group234.model.Route;
import com.mycompany.group234.model.Driver;
import com.mycompany.group234.model.Trip;

@Entity(name = "BusDrivers")
@Table(schema = "\"generated_app\"", name = "\"BusDrivers\"")
@Data
public class BusDrivers{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"BusId\"")
	private Integer busId;

    
    @Column(name = "\"DriverId\"")
    private Integer driverId;
 
}