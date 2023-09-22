package com.group.libraryapp;

import com.group.libraryapp.dto.request.user.RequestUser;
import com.group.libraryapp.dto.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import com.group.libraryapp.service.user.UserServiceV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static com.group.libraryapp.config.DBConfig.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserTest {
	private UserJdbcRepository userJdbcRepository;
	private UserServiceV1 userServiceV1;
	@BeforeEach
	void init(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userJdbcRepository = new UserJdbcRepository(jdbcTemplate);
		userServiceV1 = new UserServiceV1(userJdbcRepository);
	}


	@Test
	public void addUser(){
		userServiceV1.saveUser("soon1",12);
		List<UserResponse> users = userServiceV1.getUsers();
		assertThat(users.size()).isEqualTo(1);
		assertThat(users.get(0).getName()).isEqualTo("soon1");
	}
	@Test
	public void deleteUser(){
		RequestUser param = new RequestUser(1L,"soon1");
		userServiceV1.deleteUser(param);
		List<UserResponse> users = userServiceV1.getUsers();
		assertThat(users.size()).isEqualTo(0);
	}
	@Test
	public void updateUser(){
		userServiceV1.updateUser(new RequestUser(2L,"soon3"));
		List<UserResponse> users = userServiceV1.getUsers();
		assertThat(users.size()).isEqualTo(1);
		assertThat(users.get(0).getName()).isEqualTo("soon3");
	}
}
