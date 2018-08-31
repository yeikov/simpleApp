package com.jmfrei.simpleapp;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.jmfrei.simpleapp.Center;

/*public interface CenterRepository extends CrudRepository<Center, Integer> {

}*/
/*
public interface CenterRepository extends JpaRepository<Center, Long> {
	Optional<Center> findByName(String name);
}
*/

public interface CenterRepository extends CrudRepository<Center, Integer> {
	Optional<Center> findByName(String name);
}