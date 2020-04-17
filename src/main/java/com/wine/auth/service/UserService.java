package com.wine.auth.service;

import com.wine.auth.model.User;

public interface UserService {
	void save(User user);

    User findByUsername(String username);
}
