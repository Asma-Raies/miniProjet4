package com.asma.makeUp.controllers;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.entities.Marque;
import com.asma.makeUp.service.MakeUpService;

import jakarta.validation.Valid;

@Controller
public class MakeUpController {
	@Autowired
	MakeUpService makeUpService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Marque> cats = makeUpService.getAllMarques();
		Marque cat = new Marque();
		MakeUp make = new MakeUp();
		make.setMarque(cat);
		cat = cats.get(0);
	modelMap.addAttribute("makeUp", make);
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("marque", cats);
	modelMap.addAttribute("page",0);
	return "formMakeUp";
	}
	/*@RequestMapping("/saveMakeUp")
	public String saveMakeUp(@Valid MakeUp makeUp,BindingResult bindingResult, 
			@RequestParam(name="size",defaultValue="2")int size,
			@RequestParam(name="page",defaultValue="0")int page
			, RedirectAttributes redirectAtt)
	{
		
		if (bindingResult.hasErrors()) 
	return "formMakeUp";
	makeUpService.saveMakeUp(makeUp);
	Page<MakeUp>make= makeUpService.getAllMakeUpParPage(page, size);
	page=make.getTotalPages()-1;
	redirectAtt.addAttribute("page", page);
		makeUpService.saveMakeUp(makeUp);
		return "redirect:/ListeMakeUp";
		
	}*/
	@RequestMapping("/saveMakeUp")
    public String saveMakeUp(@Valid MakeUp makeUp,
    BindingResult bindingResult,
    ModelMap modelMap ,
    @ModelAttribute("page") int pageFromPrevious,
    @RequestParam (name="size", defaultValue = "2") int size,
    RedirectAttributes redirectAttributes)
    {
    int page;
    if (bindingResult.hasErrors()) {
    	
    	List<Marque> marq = makeUpService.getAllMarques();
       modelMap.addAttribute("marque",marq);
       modelMap.addAttribute("mode","edit");
       
    	return "formMakeUp";}
   
    if (makeUp.getRefMakeUp()==null) //adding
        page = makeUpService.getAllMakeUp().size()/size; // calculer le nbr de pages
    else //updating
        page = pageFromPrevious;
   
    makeUpService.saveMakeUp(makeUp);
   
    redirectAttributes.addAttribute("page", page);
    return "redirect:/ListeMakeUp";
    }
	@RequestMapping("/ListeMakeUp")
	public String listeMakeUp(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<MakeUp> prods =makeUpService.getAllMakeUpParPage(page, size);
	modelMap.addAttribute("makeUp", prods);
	 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeMakeUp";
	}

	@RequestMapping("/supprimerMakeUp")
	public String supprimerMakeUp(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		makeUpService.deleteMakeUpById(id);
	Page<MakeUp> prods = makeUpService.getAllMakeUpParPage(page, 
	size);
	modelMap.addAttribute("makeUp", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeMakeUp";
	}

	@RequestMapping("/modifierMakeUp")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam("page") int page)
	{
		MakeUp p= makeUpService.getMakeUp(id);
		List<Marque> marq = makeUpService.getAllMarques();
	modelMap.addAttribute("makeUp", p);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("marque", marq);
    modelMap.addAttribute("page",page);
	return "formMakeUp";
	}

	@RequestMapping("/updateMakeUp")
	public String updateProduit(@ModelAttribute("produit") MakeUp makeUp,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 makeUp.setDateCreation(dateCreation);
	 
	 makeUpService.updateMakeUp(makeUp);
	 List<MakeUp> prods = makeUpService.getAllMakeUp();
	 modelMap.addAttribute("makeUp", prods);
	return "listeMakeUp";
	}
	
	
}
