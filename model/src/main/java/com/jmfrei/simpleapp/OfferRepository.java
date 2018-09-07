package com.jmfrei.simpleapp;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Integer> {
	Optional<Offer> findByTitle(String title);
	Iterable<Offer> findAllByTitleLike(String title);
	//Iterable<Offer> findAllByBussinesUnitLike(BussinesUnit bu);
	
	Iterable<Offer> findAllByTitleLikeAndCodeLike(String string, String code);
	Iterable<Offer> findAllByTitleLikeAndCodeLikeAndBussinesUnitLike(String string, String code, BussinesUnit unit);
	
}
