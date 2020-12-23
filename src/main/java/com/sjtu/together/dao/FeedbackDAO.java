package com.sjtu.together.dao;

import com.sjtu.together.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

}
