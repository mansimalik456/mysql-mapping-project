package com.mySqlMapping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "oodles")
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Oodles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "working_fields")
	private String workingFields;
	
//	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "oodles", cascade = CascadeType.ALL)   
//	 @JsonIgnoreProperties("oodles")
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oodles", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("oodles")
	private List<OodlesEmployee> empList = new ArrayList<>();	
    
    
	    
	 
}
