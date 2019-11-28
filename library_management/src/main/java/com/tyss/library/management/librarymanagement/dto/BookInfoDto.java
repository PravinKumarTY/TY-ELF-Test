package com.tyss.library.management.librarymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="book_info")
@Data
public class BookInfoDto {
	@Id
	@Column(name="book_id")
	private int bookId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="author_name")
	private String authorName;
	@Column(name="category")
	private String category;
}
