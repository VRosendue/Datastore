package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgres.models.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}
