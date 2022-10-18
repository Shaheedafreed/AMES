package com.marlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

import com.marlabs.entity.AssociateDetailsMaster;

public interface AssociateDetailsMasterRepo extends JpaRepository<AssociateDetailsMaster, String> {

	void save(Model model);
}
