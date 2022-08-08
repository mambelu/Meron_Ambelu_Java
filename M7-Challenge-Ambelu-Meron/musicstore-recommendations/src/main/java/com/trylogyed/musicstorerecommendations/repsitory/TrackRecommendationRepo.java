package com.trylogyed.musicstorerecommendations.repsitory;

import com.trylogyed.musicstorerecommendations.model.TrackRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRecommendationRepo extends JpaRepository<TrackRecommendation, Integer> {


}
