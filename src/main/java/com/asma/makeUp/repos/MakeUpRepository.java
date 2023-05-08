package com.asma.makeUp.repos;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.entities.Marque;
@RepositoryRestResource(path = "rest")

public interface MakeUpRepository  extends JpaRepository<MakeUp, Long> {
	List<MakeUp> findByNomMakeUp(String nomMakeUp);
	 List<MakeUp> findByNomMakeUpContains(String nomMakeUp); 
	 
	 @Query("select m from MakeUp m where m.nomMakeUp like %?1 and m.prixMakeUp > ?2")
	 List<MakeUp> findByNomPrix (String nom, Double prix);

	 @Query("select p from MakeUp p where p.marque = ?1")
	 List<MakeUp> findByMarque (Marque marque);
	 
	 List<MakeUp> findByMarqueIdMarq(Long id);
	 List<MakeUp> findByOrderByNomMakeUpAsc();
	 
	 @Query("select p from MakeUp p order by p.nomMakeUp ASC, p.prixMakeUp DESC")
	 List<MakeUp> trierMakeUpNomsPrix ();
}
