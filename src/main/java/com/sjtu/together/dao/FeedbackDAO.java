package com.sjtu.together.dao;

import com.sjtu.together.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

    List<Feedback> findAll();

    void deleteByFeedbackID(int feedbackID);

}
