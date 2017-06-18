package com.service;

import java.util.List;

import com.entity.IdCard;
import com.entity.User;

public interface UserService {

    void saveUser(User user,IdCard idCard);
	
	List<User> queryAll();
}
