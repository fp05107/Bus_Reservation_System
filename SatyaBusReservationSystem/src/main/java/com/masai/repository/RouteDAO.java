package com.masai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.Route;

@Repository
public interface RouteDAO extends JpaRepository<Route, Integer>{
	public Route findByRouteFromAndRouteTo(String routeFrom, String routeTo);
}