package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new UserEntity(rs.getLong("userID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("username"), rs.getString("password"));
		
	}

}
