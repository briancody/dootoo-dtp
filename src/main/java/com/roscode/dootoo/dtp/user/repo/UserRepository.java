package com.roscode.dootoo.dtp.user.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.roscode.dootoo.dtp.user.model.User;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRepository extends MongoRepository<User, String> {

//	@PostAuthorize("returnObejct.id == principal.username")
	User findById(@Param("email") String id);
//	@PreAuthorize("hasRole('ROLE_USER')")
	List<User> findByIdAndConnectionsGroupsIn(@Param("email") String id, @Param("groups") String groups);
}
