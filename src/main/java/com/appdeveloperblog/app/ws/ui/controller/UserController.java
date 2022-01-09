package com.appdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.app.ws.ui.model.request.UserRequest;
import com.appdeveloperblog.app.ws.ui.model.response.UserModel;

@RestController
@RequestMapping("/users") // https://localhost:8080/users/
public class UserController {

	Map<String, UserModel> map;

	// http://localhost:8080/users?page=1&limit=50 (1st page with limit of 50
	// records)
	// Open the @RequestParam interface, default,defValue, value is there. Postman
	// params is same as this.

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user is called for user = " + page + " with limit = " + limit + " with sort " + sort;
	}

	// Sending the user id details as a path Variable

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) // Returns
																														// XML
																														// +
																														// JSON
	public ResponseEntity<UserModel> getUser(@PathVariable String userId) {
		UserModel user = new UserModel();
		user.setFirstName("Anshul");
		user.setLastName("Jaiswal");
		user.setEmail("anshul@gmail.com");
		user.setUserId(userId);
		if (map.containsKey(userId)) {
			return new ResponseEntity<UserModel>(user, HttpStatus.OK);
			// Response Entity is just a method to return Response Code as well. Check
			// Implementations for more.
			// Normal UserModel type will work as well.
		} else {
			return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserModel> postUser(@Valid @RequestBody UserRequest userDetails) {
		UserModel user = new UserModel();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
//		user.setPassword(userDetails.getPassword());
		String userId = UUID.randomUUID().toString();
		if (map == null)
			map = new HashMap<>();

		map.put(userId, user);
		user.setUserId(userId);

		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}

	@PutMapping
	public String putUser() {
		return "Put User is called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete user is called";
	}

}
