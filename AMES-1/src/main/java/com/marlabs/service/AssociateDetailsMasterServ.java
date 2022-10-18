package com.marlabs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.marlabs.entity.AssociateDetailsMaster;
import com.marlabs.repo.AssociateDetailsMasterRepo;

@Service

public class AssociateDetailsMasterServ {

	@Autowired
	private AssociateDetailsMasterRepo repo;

	public List<AssociateDetailsMaster> listAll() {
		return repo.findAll();
	}

	public void getPieChart(Model model) throws IllegalStateException, IOException {
		repo.save(model);
	}
}
