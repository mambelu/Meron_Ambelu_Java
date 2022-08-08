package com.trylogyed.musicstorecatalog.controller;

import com.trylogyed.musicstorecatalog.errors.NotFoundException;
import com.trylogyed.musicstorecatalog.model.Album;
import com.trylogyed.musicstorecatalog.model.Artist;
import com.trylogyed.musicstorecatalog.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbumById(@PathVariable Integer id) throws Exception {

        Optional<Album> foundAlbum = albumRepository.findById(id);

        if (foundAlbum.isPresent() == false ) {
            throw new NotFoundException("We couldn't find that album");
        }  return albumRepository.findById(id).get();

    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping("/album")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody Album album) {

        albumRepository.save(album);
    }


    @DeleteMapping("/album/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable Integer id) {
        Optional<Album> albumToDelete = albumRepository.findById(id);
        if(albumToDelete.isPresent() == false ){
            throw new IllegalArgumentException("No album with the id "+id);
        }
        albumRepository.deleteById(id);
    }
}
