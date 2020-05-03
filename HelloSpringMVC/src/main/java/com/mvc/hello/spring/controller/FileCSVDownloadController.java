package com.mvc.hello.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.mvc.hello.spring.model.Book;
import com.mvc.hello.spring.model.Novel;

@Controller
public class FileCSVDownloadController {

	@RequestMapping(value = "/viewCSV", method = RequestMethod.GET)
	public ModelAndView viewCSV(HttpServletResponse response) throws IOException {

		Book book1 = new Book("Effective Java", "Java Best Practices", "Joshua Bloch", "Addision-Wesley", "0321356683",
				"05/08/2008", 38);

		Book book2 = new Book("Head First Java", "Java for Beginners", "Kathy Sierra & Bert Bates", "O'Reilly Media",
				"0321356683", "02/09/2005", 30);

		Book book3 = new Book("Thinking in Java", "Java Core In-depth", "Bruce Eckel", "Prentice Hall", "0131872486",
				"02/26/2006", 45);

		Book book4 = new Book("Java Generics and Collections", "Comprehensive guide to generics and collections",
				"Naftalin & Philip Wadler", "O'Reilly Media", "0596527756", "10/24/2006", 27);

		List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);

		String[] header = { "Title", "Description", "Author", "Publisher", "isbn", "PublishedDate", "Price" };

		ModelAndView model = new ModelAndView("ViewCSV");
		model.addObject("csvData", listBooks);
		model.addObject("csvHeader", header);

		return model;
	}

	@RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
	public void downloadCSV(HttpServletResponse response) throws IOException {

		String csvFileName = "books.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
		response.setHeader(headerKey, headerValue);

		Book book1 = new Book("Effective Java", "Java Best Practices", "Joshua Bloch", "Addision-Wesley", "0321356683",
				"05/08/2008", 38);

		Book book2 = new Book("Head First Java", "Java for Beginners", "Kathy Sierra & Bert Bates", "O'Reilly Media",
				"0321356683", "02/09/2005", 30);

		Book book3 = new Book("Thinking in Java", "Java Core In-depth", "Bruce Eckel", "Prentice Hall", "0131872486",
				"02/26/2006", 45);

		Book book4 = new Book("Java Generics and Collections", "Comprehensive guide to generics and collections",
				"Naftalin & Philip Wadler", "O'Reilly Media", "0596527756", "10/24/2006", 27);

		List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);

		// uses the Super CSV API to generate CSV data from the model data
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "Title", "Description", "Author", "Publisher", "isbn", "PublishedDate", "Price" };

		csvWriter.writeHeader(header);

		for (Book aBook : listBooks) {
			csvWriter.write(aBook, header);
		}

		csvWriter.close();
	}

	/**
	 * Handle request to download an Excel document
	 */
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		// create some sample data
		List<Novel> listBooks = new ArrayList<Novel>();
		listBooks.add(new Novel("Effective Java", "Joshua Bloch", "0321356683", "May 28, 2008", 38.11F));
		listBooks.add(new Novel("Head First Java", "Kathy Sierra & Bert Bates", "0596009208", "February 9, 2005", 30.80F));
		listBooks.add(new Novel("Java Generics and Collections", "Philip Wadler", "0596527756", "Oct 24, 2006", 29.52F));
		listBooks.add(new Novel("Thinking in Java", "Bruce Eckel", "0596527756", "February 20, 2006", 43.97F));
		listBooks.add(new Novel("Spring in Action", "Craig Walls", "1935182358", "June 29, 2011", 31.98F));

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("excelView", "listBooks", listBooks);
	}
}
