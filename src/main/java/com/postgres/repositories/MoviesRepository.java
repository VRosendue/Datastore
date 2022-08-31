package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.models.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}
