package com.marlabs.repo;

import org.springframework.data.repository.CrudRepository;

import com.marlabs.entity.MentorPhaseMasterTable;

public interface MentorPhaseRepo extends CrudRepository<MentorPhaseMasterTable, String> {

}
