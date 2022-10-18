package com.marlabs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mentor_phase_master_table")
public class MentorPhaseMasterTable implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
//	@Column(name = "phaseId")
	private String phaseId;

//	@Column(name = "techId")
	private String techId;

//	@Column(name = "phaseName")
	private String phaseName;

//	@Column(name = "phaseMaxMarks")
	private Double phaseMaxMarks;

	public MentorPhaseMasterTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentorPhaseMasterTable(String phaseId, String techId, String phaseName, Double phaseMaxMarks) {
		super();
		this.phaseId = phaseId;
		this.techId = techId;
		this.phaseName = phaseName;
		this.phaseMaxMarks = phaseMaxMarks;
	}

	public String getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
	}

	public String getTechId() {
		return techId;
	}

	public void setTechId(String techId) {
		this.techId = techId;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public Double getPhaseMaxMarks() {
		return phaseMaxMarks;
	}

	public void setPhaseMaxMarks(Double phaseMaxMarks) {
		this.phaseMaxMarks = phaseMaxMarks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MentorPhase [phaseId=" + phaseId + ", techId=" + techId + ", phaseName=" + phaseName
				+ ", phaseMaxMarks=" + phaseMaxMarks + "]";
	}

}
