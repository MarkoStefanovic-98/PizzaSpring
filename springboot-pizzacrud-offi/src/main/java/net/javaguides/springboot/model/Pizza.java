package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@Column(name="nompizz")
	private String nompizz;
	
	@Column(name="tarifpizz")
	private Float tarifpizz;
	
	@Column(name="description")
	private String description;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNompizz() {
		return nompizz;
	}
	public void setNompizz(String nompizz) {
		this.nompizz = nompizz;
	}
	public Float getTarifpizz() {
		return tarifpizz;
	}
	public void setTarifpizz(Float tarifpizz) {
		this.tarifpizz = tarifpizz;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
