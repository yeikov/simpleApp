package com.jmfrei.simpleapp;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class OfferController {
	
	@Autowired
	private CenterRepository centerRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/centers")
	public @ResponseBody Iterable<Center> getAllCenters() {
		// This returns a JSON or XML with the users
		return centerRepository.findAll();
	}
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/centros")
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Center> readCenters() {
		
		return (Collection<Center>) this.centerRepository.findAll();
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/centers/{Id}")
	public @ResponseBody Center getCenter(@PathVariable("Id") int id) {
		// This returns a JSON or XML with the centers
		// return centerRepository.findOne(id); crud repo
		return centerRepository.findOne(id);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/centers/{Id}")
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String centerId, @RequestBody Center input) {
		// this.validateCenter(centerId);

		return this.centerRepository
				.findByName(centerId)
				.map(center -> {
					Center result = centerRepository.save(new Center());

					URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(result.getId()).toUri();

					return ResponseEntity.created(location).build();
				})
				.orElse(ResponseEntity.noContent().build());

	}
	
}
