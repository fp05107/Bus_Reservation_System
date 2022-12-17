package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BusException;
import com.masai.exception.FeedbackException;
import com.masai.exception.UserException;
import com.masai.model.Feedback;
import com.masai.repository.FeedbackDAO;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDAO fdao;

	@Override
	public Feedback addFeedback(Feedback feedback, Integer busId, String key) throws BusException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback, String Key) throws FeedbackException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedback(Integer feedBackId) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}
    
	

}
