package com.asma.makeUp.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.service.MakeUpService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MakeUpRESTController {
	@Autowired
     MakeUpService  makeUpService ; 
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MakeUp> getAllMakeUp() {
	return makeUpService.getAllMakeUp();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public MakeUp getMakeUpById(@PathVariable("id") Long id) {
	return makeUpService.getMakeUp(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public MakeUp createMakeUp(@RequestBody MakeUp makeUp) {
	return makeUpService.saveMakeUp(makeUp);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public MakeUp updateMakeUp(@RequestBody MakeUp makeUp) {
	return makeUpService.updateMakeUp(makeUp);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteMakeUp(@PathVariable("id") Long id)
	{
		makeUpService.deleteMakeUpById(id);
	}
	@RequestMapping(value="/makeMarq/{idMarq}",method = RequestMethod.GET)
	public List<MakeUp> getProduitsByCatId(@PathVariable("idMarq") Long idCat) {
	return makeUpService.findByMarqueIdMarq(idCat);
	}
}
