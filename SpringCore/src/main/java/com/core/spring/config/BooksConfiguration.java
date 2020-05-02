package com.core.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.core.spring.model.Book;
import com.core.spring.model.Chapter;
import com.core.spring.model.Title;

@Import(ChaptersConfiguration.class)
@Configuration
public class BooksConfiguration {
	
      @Autowired Title bookTitle;
      @Autowired Chapter chapter1;
      @Autowired Chapter chapter2;
       
      @Bean
      public Book myFirstSpringBook(){
            Book book = new Book();
            book.setIsbn(1);
            book.setAuthor("Mr. XYZ");
            book.setTitle(bookTitle);
            List<Chapter> chapters = new ArrayList<Chapter>();
            chapters.add(chapter1);
            chapters.add(chapter2);
            book.setChapters(chapters );
            return book;
      }

}