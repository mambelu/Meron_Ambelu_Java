package com.trylogyed.musicstorerecommendations.repsitory;

import com.trylogyed.musicstorerecommendations.model.ArtistRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRecommendationRepo extends JpaRepository<ArtistRecommendation, Integer> {

}
