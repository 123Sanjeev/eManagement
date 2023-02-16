package com.eManagement.eManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eManagement.eManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT u.* FROM users u left join user_roles ur on u.userid = ur.userid left join roles r on ur.roleid = r.roleid where r.roleName =?1", nativeQuery = true)
	public List<User> getUserWithRoles(String rolename);
}
