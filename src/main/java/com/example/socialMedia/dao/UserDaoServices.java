package com.example.socialMedia.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.example.socialMedia.model.UserModel;

@Service
public class UserDaoServices {
	private static List<UserModel> model = new ArrayList<>();
	private static int usercount = 0;
	static {
		model.add(new UserModel(++usercount, "Ankush", LocalDate.now().minusYears(30)));
		model.add(new UserModel(++usercount, "Aditya", LocalDate.now().minusDays(20)));
		model.add(new UserModel(++usercount, "Karun", LocalDate.now().minusMonths(2)));
	}

	public List<UserModel> getAll() {
		return model;
	}

	public UserModel getUserById(int id) {
		Predicate<UserModel> predicate = user -> user.getId().equals(id);
		return model.stream().filter(predicate).findFirst().orElse(null);
	}

	public UserModel saveUser(UserModel users) {
		users.setId(++usercount);
		model.add(users);
		return users;
	}
	public void userDelete(int id) {
		Predicate<UserModel> predi=user->user.getId().equals(id);
		model.removeIf(predi);
	}
}
