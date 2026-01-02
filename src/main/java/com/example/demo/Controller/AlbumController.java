package com.example.demo.Controller;

import com.example.demo.Services.AlbumService;
import com.example.demo.chinookEntities.Album;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {

    AlbumService albumService;
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> findAll(){
        List<Album> albums =  albumService.findAll();
        return ResponseEntity.ok().body(albums);
    }

    @GetMapping("/albums/{id}")
    public Album findById(@PathVariable Integer id){
        return albumService.findById(id);
    }
}
