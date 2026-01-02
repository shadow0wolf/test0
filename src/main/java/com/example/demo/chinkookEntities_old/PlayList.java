package com.example.demo.chinkookEntities_old;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Playlist")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer PlaylistId;
    String Name;
    @ManyToMany(mappedBy = "PlayLists")
    Set<Track> Tracks;
}