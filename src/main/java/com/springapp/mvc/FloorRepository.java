package com.springapp.mvc;

import com.springapp.bo.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jnguyen on 1/30/2015.
 */
public interface FloorRepository extends JpaRepository<Floor, Long > {
}
