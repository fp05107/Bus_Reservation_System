package com.masai.service;

import java.util.List;

import com.masai.DTO.AdminLoginDTO;
import com.masai.exception.BusException;
import com.masai.exception.FeedbackException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Bus;
import com.masai.model.CurrentAdminSession;
import com.masai.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback, Integer busId,String key)throws BusException, UserException;
	public Feedback updateFeedback(Feedback feedback, String Key)throws FeedbackException, UserException;
	public Feedback viewFeedback(Integer feedBackId)throws FeedbackException;
	public List<Feedback> viewAllFeedback() throws FeedbackException;

}
