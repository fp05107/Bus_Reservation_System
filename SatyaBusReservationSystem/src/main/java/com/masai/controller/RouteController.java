package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Route;

import com.masai.service.RouteService;

@RestController
public class RouteController {
		@Autowired
		RouteService routeService;

//=========================================ADD NEW ROUTE=================================================================
		@PostMapping("/Route")
		public ResponseEntity<Route> AddNewRoute(@Valid @RequestBody  Route route){
			Route Rot=routeService.AddRout(route);
			return new ResponseEntity<Route>(Rot,HttpStatus.CREATED);
		}

//=========================================UPDATE ROUTE USING ROUTE OBJECT================================================
		@PutMapping("/Route")
		public ResponseEntity<Route> UpdateRoute(@Valid @RequestBody  Route route){
			Route Rot=routeService.UpdateRoute(route);
			return new ResponseEntity<Route>(Rot,HttpStatus.OK);
		}

//==========================================DELETE ROUTE BY ID=============================================================
		@DeleteMapping("/Rout/{id}")
		public ResponseEntity<Route> DeleteRoute(@PathVariable("id") Integer id){
			Route Rot=routeService.DeleteRoute(id);
			return new ResponseEntity<Route>(Rot,HttpStatus.OK);
		} 
//===========================================GET ROUTE 	DETAILS BY ID======================================================
		@GetMapping("/Route/{id}")
		public ResponseEntity<Route> ViewRouteById(@PathVariable("id") Integer id){
			Route Rot=routeService.ViewRoute(id);
			return new ResponseEntity<Route>(Rot,HttpStatus.OK);
		}

//===========================================GET ALL ROUTE DETAILS=========================================================
		@GetMapping("/Route")
		public ResponseEntity<List<Route>> ViewRoute(){
			List<Route> Rot=routeService.ViewAllRoute();
			return new ResponseEntity<List<Route>>(Rot,HttpStatus.OK);
		}


//======================================================END=================================================================

}
