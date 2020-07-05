package com.pluralsight.security;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

/** 
 * class yang digunakan untuk handling submit (pos) user dengan role tertentu saja
 * setting pada database
 * 
 * */

public class FitnessPermissionEvaluator implements PermissionEvaluator {

	private DataSource dataSource;

	public DataSource getDatasource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Object[] args = { ((User) authentication.getPrincipal()).getUsername(), targetDomainObject.getClass().getName(),
				permission.toString() };

		int count = template.queryForObject(
				"select count(*) from permissions p where p.username = ? and p.target = ? and p.permission = ?", args,
				Integer.class);

		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

}
