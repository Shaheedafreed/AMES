package com.marlabs.helper;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.marlabs.entity.AssociateDetailsMaster;

public class PDFExporter {

	private List<AssociateDetailsMaster> listUsers;

	public PDFExporter(List<AssociateDetailsMaster> listUsers) {
		this.listUsers = listUsers;
	}

	// Table creation details

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("BatchCode", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("AssociateId", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("AssociateName", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("AssessorMark", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("MentorMark", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("AssessorRemarks", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("MentorRemarks", font));
		table.addCell(cell);
	}

	// Get data from DB
	private void writeTableData(PdfPTable table) {
		for (AssociateDetailsMaster user : listUsers) {
//			table.addCell(String.valueOf(user.getSerialversionuid()));
			table.addCell(user.getBatchCode());
			table.addCell(user.getAssociateId());
			table.addCell(user.getAssociateName().toString());
			table.addCell(user.getAssessorMark());
			table.addCell(user.getMentorMark());
			table.addCell(user.getAssessorRemarks());
			table.addCell(user.getMentorRemarks());

		}
	}

	// Documentation method
	public void export(HttpServletResponse response) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Image imgSoc = Image.getInstance("C:\\Users\\Lenovo\\marlabs_logo.jpg");
		imgSoc.scaleToFit(110, 110);
		imgSoc.setAbsolutePosition(390, 720);

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Resource Performance report", font);

		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		// watermark
		Document document1 = new Document();
		PdfWriter writer = PdfWriter.getInstance(document1, response.getOutputStream());

		// add header and footer
		writer.setPageEvent(new WatermarkPageEvent());

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.5f, 2.5f, 2.5f });
		table.setSpacingBefore(80);

		System.out.println("the file is loading");
		document1.open();

		document1.add(imgSoc);

		writeTableHeader(table);

		System.out.println("the file is loaded");

		writeTableData(table);

		document1.add(table);

		document1.close();

	}

}
