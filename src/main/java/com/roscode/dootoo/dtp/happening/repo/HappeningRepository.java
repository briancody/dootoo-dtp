package com.roscode.dootoo.dtp.happening.repo;

import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.roscode.dootoo.dtp.happening.model.Happening;

@RepositoryRestResource(collectionResourceRel="happenings",path="happenings")
public interface HappeningRepository extends PagingAndSortingRepository<Happening, String> {

	List<Happening> findByTagsIn(@Param("tags") String [] tags);
	List<Happening> findByLocNear(@Param("loc") Point point);
}
