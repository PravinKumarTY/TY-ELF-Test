package com.tyss.library.management.librarymanagement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.library.management.librarymanagement.dto.BookInfoDto;
import com.tyss.library.management.librarymanagement.dto.LibraryResponse;
import com.tyss.library.management.librarymanagement.dto.StudentBookDto;
import com.tyss.library.management.librarymanagement.dto.UserInfoDto;
import com.tyss.library.management.librarymanagement.service.LibraryManagementService;

@CrossOrigin
@RestController
@RequestMapping("librarymanagement")
public class LibraryManagementController {
	@Autowired
	private LibraryManagementService service;

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse registerUser(@RequestBody UserInfoDto userInfo) {
		LibraryResponse resonse = new LibraryResponse();
		if (service.registerUser(userInfo)) {
			resonse.setStatusCode(200);
			resonse.setMessage("success");
			resonse.setDescrition("Record Added successfully");
		} else {
			resonse.setStatusCode(401);
			resonse.setMessage("failure");
			resonse.setDescrition("Record Not Added successfully");
		}
		return resonse;
	}

	@GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse loginUser(@RequestParam("userName") String name, @RequestParam("password") String password) {
		LibraryResponse resonse = new LibraryResponse();
		UserInfoDto user = service.loginUser(name, password);
		if (user == null) {
			resonse.setStatusCode(401);
			resonse.setMessage("failure");
			resonse.setDescrition("Data not found");
		} else {
			resonse.setStatusCode(200);
			resonse.setMessage("success");
			resonse.setDescrition("data found");
			resonse.setUserList(Arrays.asList(user));
		}
		return resonse;
	}

	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse updateUser(@RequestBody UserInfoDto userInfo) {
		LibraryResponse response = new LibraryResponse();
		if (service.updateUser(userInfo)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescrition("Rrcord udated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescrition("Rrcord not udated");

		}
		return response;
	}

	@DeleteMapping(path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse deleteUser(@PathVariable("id") int id) {
		LibraryResponse response = new LibraryResponse();
		if (service.removeUser(id)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescrition("Rrcord deleted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescrition("Rrcord not deleted");

		}
		return response;
	}

	@GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse getAllUsers() {
		LibraryResponse response = new LibraryResponse();
		if (service.getAllUsers().size() > 0) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescrition("Rrcord found");
			response.setUserList(service.getAllUsers());
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescrition("Rrcord not found");

		}
		return response;
	}

	@PostMapping(path = "/addBook", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse addBook(@RequestBody BookInfoDto bookDto) {
		LibraryResponse resonse = new LibraryResponse();
		if (service.addBook(bookDto)) {
			resonse.setStatusCode(200);
			resonse.setMessage("success");
			resonse.setDescrition("Book Added");
		} else {
			resonse.setStatusCode(401);
			resonse.setMessage("failure");
			resonse.setDescrition("Book not added");
		}
		return resonse;
	}

	@PutMapping(path = "/updateBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse updateBook(@RequestBody BookInfoDto bookInfo) {
		LibraryResponse resonse = new LibraryResponse();
		if (service.updateBook(bookInfo)) {
			resonse.setStatusCode(200);
			resonse.setMessage("success");
			resonse.setDescrition("Book updated");
		} else {
			resonse.setStatusCode(401);
			resonse.setMessage("failure");
			resonse.setDescrition("Book not updated");
		}
		return resonse;
	}

	@DeleteMapping(path = "/deleteBook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteBook(@PathVariable("id") int id) {
		return service.deleteBook(id);
	}

	@GetMapping(path = "/getBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookInfoDto getBook(BookInfoDto book) {
		return service.getBook(book);
	}

	@GetMapping(path = "/getAllBook", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryResponse getAllBooks() {
		LibraryResponse resonse=new LibraryResponse();
		if(service.getAllBooks().size()>0) {
			resonse.setStatusCode(200);
			resonse.setMessage("success");
			resonse.setDescrition("Books Found");
			resonse.setBookList(service.getAllBooks());
		}else {
			resonse.setStatusCode(401);
			resonse.setMessage("failure");
			resonse.setDescrition("Books not Found");
		}
		return resonse;
	}// End of getAllBooks

	@GetMapping(path = "/acceptBookRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentBookDto acceptBookRequest(@RequestParam("userId") int userId, @RequestParam("bookId") int bookId) {
		return service.acceptBookRequest(userId, bookId);
	}

	@GetMapping(path = "/getIssueBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentBookDto> getIssueBooks(@RequestParam("userId") int userId) {
		return service.getIssueBookList(userId);
	}

	@DeleteMapping(path = "/returnBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean returnIssueBook(@RequestParam("bookId") int bookId) {
		return service.returnBook(bookId);
	}

	@GetMapping(path = "/getByName", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserInfoDto> searchByName(@RequestParam("userName") String userName) {
		List<UserInfoDto> users = service.searchByName(userName.trim());
		return users;
	}

}
