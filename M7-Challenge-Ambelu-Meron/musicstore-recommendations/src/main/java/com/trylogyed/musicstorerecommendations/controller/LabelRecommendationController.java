package com.trylogyed.musicstorerecommendations.controller;


import com.trylogyed.musicstorerecommendations.model.LabelRecommendation;
import com.trylogyed.musicstorerecommendations.repsitory.LabelRecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LabelRecommendationController {

    @Autowired
    LabelRecommendationRepo labelRecommendationRepo;

    @GetMapping("/labelRecommendations")
    public List<LabelRecommendation> getLabelRecommendations() {
        return labelRecommendationRepo.findAll();
    }

    @GetMapping("/labelRecommendations/{id}")
    public LabelRecommendation getLabelRecommendationById(@PathVariable Integer id) {
        return labelRecommendationRepo.findById(id).get();
    }

    @PostMapping("/labelRecommendations")
    @ResponseStatus(HttpStatus.CREATED)
    public LabelRecommendation createLabelRecommendation(@RequestBody LabelRecommendation rec) {
        return labelRecommendationRepo.save(rec);
    }



    @PutMapping("/labelRecommendations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabelRecommendation(@RequestBody LabelRecommendation rec) {

        labelRecommendationRepo.save(rec);
    }

    @DeleteMapping("/labelRecommendations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabelRecommendation(@PathVariable Integer id) {
        Optional<LabelRecommendation> albumToDelete = labelRecommendationRepo.findById(id);
        if (albumToDelete.isPresent() == false) {
            throw new IllegalArgumentException("No label with the id " + id);
        }
        labelRecommendationRepo.deleteById(id);
    }
}

