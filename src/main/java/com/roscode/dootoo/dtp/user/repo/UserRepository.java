package com.roscode.dootoo.dtp.user.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.roscode.dootoo.dtp.user.model.User;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
