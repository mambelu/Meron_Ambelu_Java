package com.trylogyed.musicstorerecommendations.repsitory;

import com.trylogyed.musicstorerecommendations.model.AlbumRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRecommendationRepo extends JpaRepository<AlbumRecommendation, Integer> {


}
