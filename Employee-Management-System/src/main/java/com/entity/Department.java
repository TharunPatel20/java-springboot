package com.entity;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Changed to IDENTITY for MySQL auto-increment
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	
	@JsonManagedReference
	private List<Employee> employees;

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employees.add(employee);
		
	}
	
}
