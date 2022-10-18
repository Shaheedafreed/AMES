package com.marlabs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associate_details_master")

public class AssociateDetailsMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	private String batchCode;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String associateId;

	private String associateName;

	private String assessorMark;

	private String mentorMark;

	private String assessorRemarks;

	private String mentorRemarks;

	public AssociateDetailsMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssociateDetailsMaster(String batchCode, String associateId, String associateName, String associateMark,
			String mentorMark, String assessorRemarks, String metorRemarks) {
		super();
		this.batchCode = batchCode;
		this.associateId = associateId;
		this.associateName = associateName;
		this.assessorMark = associateMark;
		this.mentorMark = mentorMark;
		this.assessorRemarks = assessorRemarks;
		this.mentorRemarks = metorRemarks;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getAssessorMark() {
		return assessorMark;
	}

	public void setAssessorMark(String assessorMark) {
		this.assessorMark = assessorMark;
	}

	public String getMentorMark() {
		return mentorMark;
	}

	public void setMentorMark(String mentorMark) {
		this.mentorMark = mentorMark;
	}

	public String getAssessorRemarks() {
		return assessorRemarks;
	}

	public void setAssessorRemarks(String assessorRemarks) {
		this.assessorRemarks = assessorRemarks;
	}

	public String getMentorRemarks() {
		return mentorRemarks;
	}

	public void setMentorRemarks(String mentorRemarks) {
		this.mentorRemarks = mentorRemarks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
