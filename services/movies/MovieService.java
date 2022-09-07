package com.postgres.services.movies;

import com.postgres.models.Movies;
import com.postgres.models.dto.MovieDTO;
import com.postgres.services.CrudService;

public interface MovieService extends CrudService<MovieDTO, Integer> {

}
