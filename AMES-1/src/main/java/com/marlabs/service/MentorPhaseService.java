package com.marlabs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marlabs.entity.MentorPhaseMasterTable;
import com.marlabs.helper.ExcelSheet;
import com.marlabs.repo.MentorPhaseRepo;

@Service
public class MentorPhaseService {

	@Autowired
	private MentorPhaseRepo mentorRepo;

	public void save(MultipartFile file) {

		try {
			List<MentorPhaseMasterTable> list = ExcelSheet.convertExcelToList(file.getInputStream());
			this.mentorRepo.saveAll(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Iterable<MentorPhaseMasterTable> getAll() {
		return this.mentorRepo.findAll();
	}

}
