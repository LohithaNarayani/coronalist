package com.hcl.coronathreat;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CoronaListRepository  extends CrudRepository<CoronalistEntity, Integer> {
	/* int getData(String state,String city,String gender); */

CoronalistEntity findById(int id);

CoronalistEntity findByStateAndCity(String state,String city);

List<CoronalistEntity> findByState(String state);

}
