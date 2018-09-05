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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmfrei.simpleapp.BackOffice;

@Controller
public class OfferController {

	@Autowired
	private OfferRepository offerRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path= BackOffice.backOfficeUrl + "/offers")
	public @ResponseBody Iterable<Offer> getAllOffers() {
		// This returns a JSON or XML with the users
		return offerRepository.findAll();
	}
	
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path= BackOffice.backOfficeUrl + "/ofertas")
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Offer> readOffers() {
		
		return (Collection<Offer>) this.offerRepository.findAll();
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path= BackOffice.backOfficeUrl + "/offers/{Id}")
	public @ResponseBody Offer getOffer(@PathVariable("Id") int id) {
		// This returns a JSON or XML with the offers
		// return offerRepository.findOne(id); crud repo
		return offerRepository.findOne(id);
	}
	
	
	//{jmf exp solo retorna coincidencias completas...
	//http://localhost:8080/backoffice/offers/?title=titleOferta%202
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = BackOffice.backOfficeUrl+"/offers/", method = RequestMethod.GET)
	public @ResponseBody Iterable<Offer> findAllByTitle(
			@RequestParam("title") String title){
		
		return offerRepository.findAllByTitleLike('%'+title+'%');
		
	}
	
	//jmf exp}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path= BackOffice.backOfficeUrl + "/offers/{Id}")
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String offerId, @RequestBody Offer input) {
		// this.validateOffer(offerId);

		return this.offerRepository
				.findByTitle(offerId)
				.map(offer -> {
					Offer result = offerRepository.save(new Offer());

					URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(result.getId()).toUri();

					return ResponseEntity.created(location).build();
				})
				.orElse(ResponseEntity.noContent().build());

	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path= BackOffice.backOfficeUrl + "/offers/add") // Map ONLY GET Requests
	public @ResponseBody Offer addOffer (@RequestParam String title
			) {
		// @ResponseBody means the returned String is the response, not a view title
		// @RequestParam means it is a parameter from the GET or POST request
		System.out.println("offers/add::");
		Offer n = new Offer();
		n.setTitle(title);
		
		offerRepository.save(n);
		return n;
	}
	
	
	
}
