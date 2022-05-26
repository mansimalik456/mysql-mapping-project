package com.mySqlMapping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "oodlesEmployee")
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class OodlesEmployee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "employee_name")
    private String employeeName;
    
 //   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  //  @JoinColumn(name = "oodles", referencedColumnName = "id")
  //  @JsonIgnoreProperties("oodlesEmployee")
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "oodles_id", referencedColumnName = "id")
    @JsonIgnoreProperties("empList")
    private Oodles oodles;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "oodlesEmployee")
    @JsonManagedReference
    private Laptop laptop;
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oodlesEmployee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("oodlesEmployee")
	private List<EmployeeRole> emproleList = new ArrayList<>();	
    
   
    
}
