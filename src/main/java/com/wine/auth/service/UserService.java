package com.wine.auth.service;

import com.wine.auth.domain.User;

public interface UserService {
	void save(User user);

    User findByUsername(String username);
}
