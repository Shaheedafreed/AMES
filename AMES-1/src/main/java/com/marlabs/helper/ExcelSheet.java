package com.marlabs.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.marlabs.entity.MentorPhaseMasterTable;

public class ExcelSheet {

	// check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

	// convert excel to list of products

	public static List<MentorPhaseMasterTable> convertExcelToList(InputStream is) {
		List<MentorPhaseMasterTable> list = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);

			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;

				MentorPhaseMasterTable p = new MentorPhaseMasterTable(null, null, null, null);

				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						p.setPhaseId(cell.getStringCellValue());
						break;
					case 1:
						p.setTechId(cell.getStringCellValue());
						break;
					case 2:
						p.setPhaseName(cell.getStringCellValue());
						break;
					case 3:
						p.setPhaseMaxMarks(cell.getNumericCellValue());
						break;
					default:
						break;
					}
					cid++;

				}

				list.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
