package com.sjtu.together.service;

import com.sjtu.together.dao.FeedbackDAO;
import com.sjtu.together.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FeedbackService {
    @Autowired
    FeedbackDAO feedbackDAO;

    public void addFeedbackRecord(int actid, String comment) {
        Feedback feedback = new Feedback();
        feedback.setActivityID(actid);
        feedback.setComment(comment);
        feedbackDAO.save(feedback);
    }

    public void addFeedbackRecord(Feedback feedback) {
        feedbackDAO.save(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackDAO.findAll();
    }

    public void deleteFeedback(int feedbackID) {
        feedbackDAO.deleteByFeedbackID(feedbackID);
    }
}
