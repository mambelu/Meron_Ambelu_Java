package com.trylogyed.musicstorerecommendations.repsitory;

import com.trylogyed.musicstorerecommendations.model.LabelRecommendation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class LabelRecommendationRepoTest {
    @Autowired
    LabelRecommendationRepo repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void addGetDeleteLabelRecommendation() {

        LabelRecommendation label = new LabelRecommendation();
        label.setLabelId(1);
        label.setUserId(1);
        label.setLiked(true);

        label = repo.save(label);

        Optional<LabelRecommendation> found = repo.findById(label.getLabelRecommendationId());

        assertEquals(found.get(), label);

        repo.deleteById(label.getLabelRecommendationId());

        found = repo.findById(label.getLabelRecommendationId());

        assertFalse(found.isPresent());
    }

    @Test
    public void updateLabelRecommendation() {

        LabelRecommendation label = new LabelRecommendation();
        label.setLabelRecommendationId(1);
        label.setLabelId(1);
        label.setUserId(1);
        label.setLiked(true);

        label = repo.save(label);

        LabelRecommendation updated = new LabelRecommendation();
        updated.setLabelRecommendationId(1);
        updated.setLabelId(1);
        updated.setUserId(1);
        updated.setLiked(false);

        updated = repo.save(label);

        Optional<LabelRecommendation> found = repo.findById(updated.getLabelRecommendationId());
        assertEquals(found.get(), label);
    }

    @Test
    public void getAllLabelRecommendations() {

        LabelRecommendation label1 = new LabelRecommendation();
        label1.setLabelRecommendationId(1);
        label1.setLabelId(1);
        label1.setUserId(1);
        label1.setLiked(true);

        label1=repo.save(label1);

        LabelRecommendation label2 = new LabelRecommendation();
        label2.setLabelRecommendationId(2);
        label2.setLabelId(2);
        label2.setUserId(2);
        label2.setLiked(false);

        label2=repo.save(label2);

        List<LabelRecommendation> aList = repo.findAll();
        assertEquals(aList.size(), 2);

    }
}