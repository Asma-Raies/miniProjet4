package com.asma.makeUp.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.entities.Marque;

public interface MakeUpService {
	MakeUp saveMakeUp(MakeUp p);
	MakeUp updateMakeUp(MakeUp p);
	void deleteMakeUp(MakeUp p);
	 void deleteMakeUpById(Long id);
	 MakeUp getMakeUp(Long id);
	List<MakeUp> getAllMakeUp();
	Page<MakeUp> getAllMakeUpParPage(int page, int size);
	List<MakeUp> findByNomMakeUp(String nom);
	List<MakeUp> findByNomMakeUpContains(String nom);
	List<MakeUp> findByNomPrix (String nom, Double prix);
	List<MakeUp> findByMarque (Marque marque);
	List<MakeUp> findByMarqueIdMarq(Long id);
	List<MakeUp> findByOrderByNomMakeUpAsc();
	List<MakeUp> trierMakeUpNomsPrix();
	 List<Marque> getAllMarques();
}
