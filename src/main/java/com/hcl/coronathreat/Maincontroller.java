package com.hcl.coronathreat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/coronalist") 
public class Maincontroller {
	 @Autowired 	 
private CoronaListRepository coronaListRepository;
	
	
	 @GetMapping(path="/{state}/{city}")
	 public @ResponseBody String getDataForGender(@PathVariable String state,@PathVariable String city) {
		CoronalistEntity coronalistEntity = coronaListRepository.findByStateAndCity(state, city);
		List<CoronalistEntity> entityList = new ArrayList<CoronalistEntity>();
		entityList.add(coronalistEntity);
		return Utils.getHtmlData(entityList);
	 }
	 @GetMapping(path="/{state}")
	 public @ResponseBody String getDataForState(@PathVariable String state) {
		 List<CoronalistEntity> coronalist= coronaListRepository.findByState(state);
		 return Utils.getHtmlData(coronalist);
	 }
	 @GetMapping(path="/")
	 public @ResponseBody String getDataForAll() {
		 List<CoronalistEntity> entityList=new ArrayList<CoronalistEntity>();
    Iterable<CoronalistEntity> coronalist= coronaListRepository.findAll();
	 for (Iterator iterator = coronalist.iterator(); iterator.hasNext();) {
		 CoronalistEntity type = (CoronalistEntity) iterator.next();
		 entityList.add(type);	 
	 }
	 return Utils.getHtmlData(entityList);
	 }
}
