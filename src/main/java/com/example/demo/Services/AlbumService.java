package com.example.demo.Services;

import com.example.demo.chinookEntities.Album;
import com.example.demo.reposotries.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    public AlbumRepository albumRepository;

    public Album findById(Integer id){
        return albumRepository.findById(id).orElse(null);
    }

    public List<Album> findAll(){
        List<Album> albums =  albumRepository.findAll();
        albums.stream().forEach(System.out::println);
        return  albums;
    }





}
