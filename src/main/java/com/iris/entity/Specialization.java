package com.iris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="specialization_tab")
public class Specialization {

	@Id
	@GeneratedValue
	@Column(name="spec_id")
	private Long id;
	@Column(name="spec_code")
	private String specCode;
	@Column(name="spec_name")
	private String specName;
	@Column(name="spec_note")
	private String spec_Note;

	public Specialization() {
	}
	public Specialization(Long id, String specCode, String specName, String spec_Note) {
		this.id = id;
		this.specCode = specCode;
		this.specName = specName;
		this.spec_Note = spec_Note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSpecCode() {
		return specCode;
	}
	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSpec_Note() {
		return spec_Note;
	}
	public void setSpec_Note(String spec_Note) {
		this.spec_Note = spec_Note;
	}

	@Override
	public String toString() {
		return "Specialization [id=" + id + ", specCode=" + specCode + ", specName=" + specName + ", spec_Note="
				+ spec_Note + "]";
	}


}
