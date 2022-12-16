package com.masai.service;

import java.util.List;

import com.masai.exceptions.BusException;
import com.masai.exceptions.LoginException;
import com.masai.model.Bus;

public interface BusService {

	public Bus addBus(Bus bus,String key)throws BusException,LoginException;
	public Bus updateBus(Bus bus,String key)throws BusException,LoginException;
	public Bus deleteBus(int busId,String key)throws BusException,LoginException;
	public Bus viewBus(int busId)throws BusException;
	public List<Bus> viewBusByType(String BusType) throws BusException;
	public List<Bus> viewAllBuses() throws BusException;
}
