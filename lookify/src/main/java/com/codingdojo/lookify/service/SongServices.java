package com.codingdojo.lookify.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repository.SongRepo;

@Service
public class SongServices {
	private ArrayList<Song> songs;
	private SongRepo songRepo;
	//private String artist;
	public SongServices(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	//public SongServices(String artist) {
		//this.artist = artist;
	//}
	public void addSong(Song song) {
		songRepo.save(song);
	}
	public ArrayList<Song> allSongs() {
		return (ArrayList<Song>) songRepo.findAll();
	}
	public Song getSong(Long id) {
		return songRepo.findOne(id);
	}
	
	public ArrayList<Song> getSongsByArtist(String artist){
		
		return (ArrayList<Song>) songRepo.findByArtist(artist);
	}
	public ArrayList<Song> TopTenSongs(){
		return (ArrayList<Song>) songRepo.findTop10ByOrderByRatingDesc();
	}
	public void delSong(Long id) {
		songRepo.delete(id);
	}

}
