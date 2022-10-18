package com.marlabs.helper;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class WatermarkPageEvent extends PdfPageEventHelper {

	Font FONT = new Font(Font.HELVETICA, 52, Font.BOLD, new GrayColor(0.85f));

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		ColumnText.showTextAligned(writer.getDirectContentUnder(), Element.ALIGN_CENTER,
				new Phrase("Marlabs.com", FONT), 297.5f, 221, writer.getPageNumber() % 2 == 1 ? 45 : -45);
	}
}
