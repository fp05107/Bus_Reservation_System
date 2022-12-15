package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Route;
@Service
public interface RouteService {
	public Route AddRout(Route route);
	public Route UpdateRoute(Route route);
	public Route DeleteRoute(Integer RouteId);
	public Route ViewRoute(Integer RouteId);
	public List<Route> ViewAllRoute();

}
