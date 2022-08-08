package com.trylogyed.musicstorecatalog.controller;


import com.trylogyed.musicstorecatalog.model.Album;
import com.trylogyed.musicstorecatalog.model.Label;
import com.trylogyed.musicstorecatalog.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LabelController {
    @Autowired
    LabelRepository repo;

    @GetMapping("/labels")
    public List<Label> getLabels() {
        return repo.findAll();
    }

    @GetMapping("/labels/{id}")
    public Label getLabelById(@PathVariable int id) {
        Optional<Label> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/labels")
    @ResponseStatus(HttpStatus.CREATED)
    public Label addLabel(@RequestBody Label label) {
        return repo.save(label);
    }



    @PutMapping("/label")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@RequestBody Label label) {

        repo.save(label);
    }


    @DeleteMapping("/label/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable Integer id) {
        Optional<Label> labelToDelete = repo.findById(id);
        if(labelToDelete.isPresent() == false ){
            throw new IllegalArgumentException("No label with the id "+id);
        }
        repo.deleteById(id);
    }
}
