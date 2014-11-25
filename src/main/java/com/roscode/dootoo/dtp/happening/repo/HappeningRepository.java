package com.roscode.dootoo.dtp.happening.repo;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.roscode.dootoo.dtp.happening.model.Happening;

@RepositoryRestResource(collectionResourceRel="happenings",path="happenings")
public interface HappeningRepository extends MongoRepository<Happening, String> {
	
	@Override
	<S extends Happening> S save(S entity);

	List<Happening> findByTagsIn(@Param("tags") String [] tags);
	List<Happening> findByLocNear(@Param("loc") Point point, @Param("distance") Distance distance);
	List<Happening> findByTagsInAndLocNear(@Param("tags") String [] tags, @Param("loc") Point point, @Param("distance") Distance distance);
}
