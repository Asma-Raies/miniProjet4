package com.asma.makeUp;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.asma.makeUp.entities.MakeUp;
import com.asma.makeUp.entities.Marque;
import com.asma.makeUp.repos.MakeUpRepository;
import com.asma.makeUp.service.MakeUpService;

@SpringBootTest
class MakeUppApplicationTests {
	@Autowired
	private MakeUpService makeUpService ; 
	@Autowired
	private MakeUpRepository makeUpRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreateMakeUp() {
	MakeUp make = new MakeUp("eyeliner",55.500,new Date(),7);
	makeUpRepository.save(make);
	}
	@Test
	public void testFindMakeUp()
	{
		MakeUp p = makeUpRepository.findById(1L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdateMakeUp()
	{
		MakeUp p = makeUpRepository.findById(1L).get();
	p.setPrixMakeUp(35.0);
	makeUpRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
		makeUpRepository.deleteById(1L);;
	}
	 
	@Test
	public void testListerTousProduits()
	{
	List<MakeUp> prods = makeUpRepository.findAll();
	for (MakeUp p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomProduitContains()
	{
	Page<MakeUp> prods = makeUpService.getAllMakeUpParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	 @Test
	 public void testFindByNomMakeUp()
	 {
	 List<MakeUp> prods = makeUpRepository.findByNomMakeUp("rouge");
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByNomMakeUpContains ()
	 {
	 List<MakeUp> prods=makeUpRepository.findByNomMakeUpContains("rouge");
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 } }
	 @Test
	 public void testfindByNomPrix()
	 {
	 List<MakeUp> prods = makeUpRepository.findByNomPrix("rouge", 25.0);
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testfindByMarque()
	 {
	 Marque cat = new Marque();
	 cat.setIdMarq(1L);
	 List<MakeUp> prods = makeUpRepository.findByMarque(cat);
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByMarqueIdMarq()
	 {
	 List<MakeUp> prods = makeUpRepository.findByMarqueIdMarq(1L);
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 }
	  }
	 
	 @Test
	 public void testfindByOrderByNomMakeUpAsc()
	 {
	 List<MakeUp> prods = 
			 makeUpRepository.findByOrderByNomMakeUpAsc();
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testTrierMakeUpNomsPrix()
	 {
	 List<MakeUp> prods = makeUpRepository.trierMakeUpNomsPrix();
	 for (MakeUp p : prods)
	 {
	 System.out.println(p);
	 }
	 }


}
