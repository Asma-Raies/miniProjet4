package com.asma.makeUp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.entities.Marque;
import com.asma.makeUp.repos.MakeUpRepository;
import com.asma.makeUp.repos.MarqueRepository;
@Service
public class MakeUpServiceImpl implements MakeUpService {
	@Autowired
	MakeUpRepository makeUpRepository;
	@Autowired
	MarqueRepository marqueRepository;
	@Override
	public MakeUp saveMakeUp(MakeUp p) {
	return makeUpRepository.save(p); 
	}
	@Override
	public MakeUp updateMakeUp(MakeUp p) {
	return makeUpRepository.save(p);
	}
	@Override
	public void deleteMakeUp(MakeUp p) {
		makeUpRepository.delete(p);
	}
	 @Override
	public void deleteMakeUpById(Long id) {
		 makeUpRepository.deleteById(id);
	}
	@Override
	public MakeUp getMakeUp(Long id) {
	return makeUpRepository.findById(id).get();
	}
	@Override
	public List<MakeUp> getAllMakeUp() {
	return makeUpRepository.findAll();
	}
	@Override
	public Page<MakeUp> getAllMakeUpParPage(int page, int size) {
	return makeUpRepository.findAll(PageRequest.of(page, size));
	}
	
	
	@Override
	public List<MakeUp> findByNomMakeUp(String nom) {
	return makeUpRepository.findByNomMakeUp(nom);
	}
	@Override
	public List<MakeUp> findByNomMakeUpContains(String nom) {
	return makeUpRepository.findByNomMakeUpContains(nom);
	}
	@Override
	public List<MakeUp> findByNomPrix(String nom, Double prix) {
		return makeUpRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<MakeUp> findByMarque(Marque marque) {
	return makeUpRepository.findByMarque(marque);
	}
	@Override
	public List<MakeUp> findByMarqueIdMarq(Long id) {
	return makeUpRepository.findByMarqueIdMarq(id);
	}
	@Override
	public List<MakeUp> findByOrderByNomMakeUpAsc() {
	return makeUpRepository.findByOrderByNomMakeUpAsc();
	}
	@Override
	public List<MakeUp> trierMakeUpNomsPrix() {
	return makeUpRepository.trierMakeUpNomsPrix();
	}
	@Override
	public List<Marque> getAllMarques() {
	return marqueRepository.findAll();
	}
}
