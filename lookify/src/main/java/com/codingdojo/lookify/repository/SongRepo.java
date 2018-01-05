package com.codingdojo.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.lookify.models.Song;

public interface SongRepo extends CrudRepository<Song,Long> {
 List<Song> findAll();
 List<Song> findByArtist(String artist);
 List<Song> findTop10ByOrderByRatingDesc();
}
