package com.tyss.library.management.librarymanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Entity
@Table(name="student_book_info")
@Data
public class StudentBookDto {
	@Id
	@Column(name="book_id")
	private int bookId;
	@Column(name="book_name")
	private String bookName;
	@Column(name="author_name")
	private String authorName;
	@Column(name="category")
	private String category;
	@Column(name="user_id")
	private int userId;
	@Column(name="issue_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date issueDate;
	@Column(name="return_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date returnDate;
}
