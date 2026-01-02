package com.example.demo.chinkookEntities_old;
import jakarta.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer AlbumId;
    String Title;
    @ManyToOne
    @JoinColumn(name = "ArtistId")
    Artist Artist;
}