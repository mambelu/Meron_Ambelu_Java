package com.trylogyed.musicstorecatalog.controller;
import com.trylogyed.musicstorecatalog.model.Album;
import com.trylogyed.musicstorecatalog.model.Artist;
import com.trylogyed.musicstorecatalog.repository.AlbumRepository;
import com.trylogyed.musicstorecatalog.repository.ArtistRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {
    @Autowired
    ArtistRepository repo;




    @GetMapping("/artists")
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getArtists() {
        return repo.findAll();
    }

    @GetMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistById(@PathVariable Integer id) throws NotFoundException {
        Optional<Artist> foundAlbum = repo.findById(id);

        if (foundAlbum.isPresent() == false ) {
            throw new com.trylogyed.musicstorecatalog.errors.NotFoundException("We couldn't find that album");
        }  return repo.findById(id).get();

    }

    @PostMapping("/artists")
    @ResponseStatus(HttpStatus.CREATED)
    public Artist addArtist(@RequestBody Artist artist) {
        return repo.save(artist);
    }





    @PutMapping("/artist")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@RequestBody Artist artist) {

        repo.save(artist);
    }


    @DeleteMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable Integer id) {
        Optional<Artist> artistToDelete = repo.findById(id);
        if(artistToDelete.isPresent() == false ){
            throw new IllegalArgumentException("No artist with the id "+id);
        }





        repo.deleteById(id);
    }
}
