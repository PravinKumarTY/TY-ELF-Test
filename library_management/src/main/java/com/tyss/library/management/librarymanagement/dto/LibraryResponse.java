package com.tyss.library.management.librarymanagement.dto;

import java.util.List;

import lombok.Data;
@Data
public class LibraryResponse {
	private int statusCode;
	private String message;
	private String descrition;
	private List<UserInfoDto> userList;
	private List<BookInfoDto> bookList;
}
