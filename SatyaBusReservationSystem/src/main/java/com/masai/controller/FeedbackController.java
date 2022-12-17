package com.masai.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.BusException;
import com.masai.exception.FeedbackException;
import com.masai.exception.UserException;
import com.masai.model.Feedback;
import com.masai.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackservice;
	
	@PostMapping("/feedback/user/{busid}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback, @PathVariable("busid") Integer busId, @RequestParam(required = false) String key) throws UserException,BusException{
		
		Feedback fb = feedbackservice.addFeedback(feedback,busId,key);
		
		return new ResponseEntity<Feedback>(fb,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/feedback/user")
	public ResponseEntity<Feedback> updateFeedback(@Valid @RequestBody Feedback feedback,@RequestParam(required = false) String key) throws FeedbackException, UserException {
		
		Feedback fb = feedbackservice.updateFeedback(feedback,key);
		
		return new ResponseEntity<Feedback>(fb,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws FeedbackException {
		
		Feedback fb = feedbackservice.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(fb,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() throws FeedbackException {
		
		List<Feedback> fb =  feedbackservice.viewAllFeedback();
		
		return new ResponseEntity<List<Feedback>>(fb,HttpStatus.ACCEPTED);
		
	}
	
}
