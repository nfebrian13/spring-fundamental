package com.mvc.hello.spring.config;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.mvc.hello.spring.model.Novel;

public class ExcelBuilder extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Novel> listBooks = (List<Novel>) model.get("listBooks");

		Sheet sheet = workbook.createSheet("\"Java Books");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Book Title");
		header.createCell(1).setCellValue("Author");
		header.createCell(2).setCellValue("ISBN");
		header.createCell(3).setCellValue("Published Date");
		header.createCell(4).setCellValue("PPrice");

		int rowCount = 1;
		for (Novel aBook : listBooks) {
			Row fruitRow = sheet.createRow(rowCount++);
			fruitRow.createCell(0).setCellValue(aBook.getTitle());
			fruitRow.createCell(1).setCellValue(aBook.getAuthor());
			fruitRow.createCell(2).setCellValue(aBook.getIsbn());
			fruitRow.createCell(3).setCellValue(aBook.getPublishedDate());
			fruitRow.createCell(4).setCellValue(aBook.getPrice());
		}
	}

}