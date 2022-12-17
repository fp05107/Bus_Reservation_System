package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.BusException;
import com.masai.exception.FeedbackException;
import com.masai.exception.UserException;
import com.masai.model.Bus;
import com.masai.model.CurrentUserSession;
import com.masai.model.Feedback;
import com.masai.model.User;
import com.masai.repository.BusRepo;
import com.masai.repository.FeedbackDAO;
import com.masai.repository.UserDao;
import com.masai.repository.UserSessionDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDAO fdao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BusRepo busRepo;
    
    @Autowired
    private UserSessionDao uSession;

	@Override
	public Feedback addFeedback(Feedback feedback, Integer busId, String key) throws BusException, UserException {
		CurrentUserSession loggedInuser = uSession.findByUserUID(key);
		if(loggedInuser == null)
			throw new UserException("Key Not Valid!");
	
		User user = userDao.findById(loggedInuser.getUserId()).orElseThrow(()-> new UserException("User not found!"));
	    Optional <Bus> busOptional = busRepo.findById(busId);
	    if(busOptional.isEmpty()) {
	    	throw new BusException("Bus Not present with Id "+busId);
	    }
	    
	    feedback.setBus(busOptional.get());
	    feedback.setUser(user);
	    feedback.setFeedbackDateTime(LocalDateTime.now());
	    Feedback saved = fdao.save(feedback);
	    return saved;
	}
	

	@Override
	public Feedback updateFeedback(Feedback feedback, String Key) throws FeedbackException, UserException {
		CurrentUserSession loggedInUser = uSession.findByUserUID(Key);
		if(loggedInUser == null)
			throw new UserException("Not a valid key to update Feedback!");
		
		User user = userDao.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User Not Found!"));
		
		Optional <Feedback> optional = fdao.findById(feedback.getFeedBackId());
		if(optional.isPresent()) {
            Feedback fb = optional.get();
			
			Optional<Bus> busOptional = busRepo.findById(fb.getBus().getBusId());
			
			if(!busOptional.isPresent()) throw new FeedbackException("bus details are invalid!");
			
			feedback.setBus(busOptional.get());
			
			feedback.setUser(user);

			feedback.setFeedbackDateTime(LocalDateTime.now());

			return fdao.save(feedback);
		}
		throw new FeedbackException("No Feedback Found!!");
	}

	@Override
	public Feedback viewFeedback(Integer feedBackId) throws FeedbackException {
		Optional<Feedback> fo = fdao.findById(feedBackId);
		if (fo.isPresent()) {

			return fo.get();

		}
		throw new FeedbackException("No Feedback Found!!");
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		Optional<List<Feedback>> fo = Optional.of(fdao.findAll());
		if (fo.isPresent()) {

			return fo.get();

		}
		throw new FeedbackException("No Feedbacks Found!!");
	}
    
	

}
