package com.example.demo.reposotries;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.chinookEntities.Album;

public interface AlbumRepository  extends JpaRepository<Album,Integer> {

}
