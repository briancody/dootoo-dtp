package com.roscode.dootoo.dtp.happening.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.roscode.dootoo.dtp.happening.model.Happening;

@RepositoryRestResource(collectionResourceRel="happenings",path="happenings")
public interface HappeningRepository extends PagingAndSortingRepository<Happening, String> {

}
