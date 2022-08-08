package com.trylogyed.musicstorerecommendations.repsitory;

import com.trylogyed.musicstorerecommendations.model.LabelRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRecommendationRepo extends JpaRepository<LabelRecommendation, Integer> {


}
