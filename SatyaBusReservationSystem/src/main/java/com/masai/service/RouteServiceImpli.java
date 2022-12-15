package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Route;
import com.masai.repository.RouteDAO;
@Service
public class RouteServiceImpli implements RouteService{
	@Autowired
	private RouteDAO Routedao;

//====================================================ADD ROUTE SERVICE=====================================================
	@Override
	public Route AddRout(Route route) {
		Route R1=Routedao.save(route);
		return R1;
	}

//====================================================UPDATE ROUTE SERVICE=====================================================
	@Override
	public Route UpdateRoute(Route route) {
		Optional<Route> R1=Routedao.findById(route.getRouteId());
		if(R1.isPresent()) {
			Route R2= Routedao.save(R1.get());
			return R2;
		}
		return null;
	}
//====================================================DELETE ROUTE SERVICE=====================================================
	@Override
	public Route DeleteRoute(Integer RouteId) {
		Optional<Route> R1=Routedao.findById(RouteId);
		if(R1.isPresent()) {
			Routedao.deleteById(RouteId);
			return R1.get();
		}
		return null;
	}
//====================================================VIEW ROUTE BY ID SERVICE=====================================================
	@Override
	public Route ViewRoute(Integer RouteId) {
		Optional<Route> R1=Routedao.findById(RouteId);
		if(R1.isPresent()) {
			return R1.get();
		}
		return null;
	}

//====================================================VIEW ALL ROUTE SERVICE=====================================================
	@Override
	public List<Route> ViewAllRoute() {
		List<Route> RLst=Routedao.findAll();
		// TODO Auto-generated method stub
		if(RLst.size()!=0) {
			return RLst;
		}
		return null;
	}

}
