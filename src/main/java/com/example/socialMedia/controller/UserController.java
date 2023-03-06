package com.example.socialMedia.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.socialMedia.dao.UserDaoServices;
import com.example.socialMedia.handleException.UserNotFoundException;
import com.example.socialMedia.model.UserModel;

@RestController
public class UserController {
	@Autowired
	UserDaoServices service;
	private MessageSource message;

	public UserController(MessageSource message) {
		this.message = message;
	}

	@GetMapping("/")
	public String helloWorldInternationalised() {
		Locale local = LocaleContextHolder.getLocale();
		return message.getMessage("good.morning.message", null, "Default message", local);
	}

	@GetMapping("/all")
	public List<UserModel> getUsers() {
		return service.getAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<UserModel> getUserById(@PathVariable Integer id) {
		UserModel user = service.getUserById(id);
		if (user == null) {
			throw new UserNotFoundException("User not exist with this Id  :" + id);
		}
		EntityModel<UserModel> entitymodel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		entitymodel.add(link.withRel("all_users"));
		return entitymodel;
	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> saveUser(@Validated @RequestBody UserModel model) {
		UserModel saveduser = service.saveUser(model);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable Integer id) {
		service.userDelete(id);
		return "User Deleted";
	}
}
