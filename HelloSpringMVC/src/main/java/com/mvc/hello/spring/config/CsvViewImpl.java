package com.mvc.hello.spring.config;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.supercsv.io.ICsvBeanWriter;
import com.mvc.hello.spring.model.Book;

/**
 * An implementation of the AbstractCsvView. This decides what model data to be
 * used to generate CSV data.
 * 
 * @author www.codejava.net
 *
 */
public class CsvViewImpl extends AbstractCsvView {

	@Override
	protected void buildCsvDocument(ICsvBeanWriter csvWriter, Map<String, Object> model) throws IOException {

		List<Book> listBooks = (List<Book>) model.get("csvData");
		String[] header = (String[]) model.get("csvHeader");

		csvWriter.writeHeader(header);

		for (Book aBook : listBooks) {
			csvWriter.write(aBook, header);
		}
	}
}