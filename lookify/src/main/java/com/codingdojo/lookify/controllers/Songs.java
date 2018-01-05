package com.codingdojo.lookify.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.service.SongServices;

@Controller
public class Songs {
	SongServices songService;
	public Songs(SongServices songServ) {
		this.songService = songServ;
	}
	@RequestMapping("/")
	public String Index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String Dash(@ModelAttribute("song") Song song,@ModelAttribute("Currentartist") Song artist,Model model) {
		model.addAttribute("songs", songService.allSongs());
		return "dashboard";
	}
	@RequestMapping("/songs/new")
	public String New(@ModelAttribute("newSong")Song song) {
		return "new";
	}
	@PostMapping("/search")//form searching artist
	public String Search(@ModelAttribute("Currentartist") Song song,BindingResult result,Model model) {
		//songService.getSongsByArtist(song.getArtist());
		System.out.println("in search");
		//System.out.println(id);
		model.addAttribute("allsongs", songService.getSongsByArtist(song.getArtist()));
		return "searchArtist";
	}
	@PostMapping("/addSong")
	public String CreateSong(@Valid @ModelAttribute("newSong") Song song,BindingResult result,Model model) {
		System.out.println(result);
		if(result.hasErrors()) {
			System.out.println("in errors");
			model.addAttribute("songs", songService.allSongs());
			return "new";
		}else {
			System.out.println(song.getTitle());
			System.out.println(song.getRating());
			songService.addSong(song);
			return "redirect:/dashboard";
		}

	}
	
	@RequestMapping("/show/{id}")
	public String Show(Model model,@PathVariable("id") Long id) {
		System.out.println("in show");
		Song song = songService.getSong(id);
		System.out.println(song);
		model.addAttribute("song",song);
		return "details";
	}
	@RequestMapping("/TopSongs")
	public String TopTen(Model model) {
		System.out.println("In top songs");
		model.addAttribute("topSongs", songService.TopTenSongs());
		return "searchSong";
	}
	@RequestMapping("/song/delete/{id}")
	public String DelSong(@PathVariable("id") Long id) {
		System.out.println(id);
		songService.delSong(id);
		return "redirect:/dashboard";
	}

}
