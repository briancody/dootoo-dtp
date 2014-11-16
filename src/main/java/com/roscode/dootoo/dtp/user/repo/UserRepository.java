package com.roscode.dootoo.dtp.user.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.roscode.dootoo.dtp.user.model.User;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	User findById(@Param("email") String id);
	List<User> findByIdAndConnectionsGroupsIn(@Param("email") String id, @Param("groups") String groups);
}
