package com.example.demo.chinkookEntities_old;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer TrackId;
    String Name;
    @ManyToOne
    @JoinColumn(name="AlbumId")
    Album Album ;
    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    MediaType MediaType ;
    @ManyToOne
    @JoinColumn(name = "GenreId")
    Genre Genre;
    String Composer;
    Integer Milliseconds;
    Integer Bytes;
    BigDecimal UnitPrice;
    @ManyToMany
    @JoinTable(
            name = "PlaylistTrack"
            ,joinColumns = @JoinColumn(name="TrackId")
            ,inverseJoinColumns = @JoinColumn(name="PlaylistId")
    )
    Set<PlayList> PlayLists;
}
