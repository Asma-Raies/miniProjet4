package com.asma.makeUp.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity
public class MakeUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refMakeUp;
	@NotNull
	@Size (min = 5,max = 20)
	private String nomMakeUp;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixMakeUp;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent

	private Date dateCreation;
	@Min(value = 1)
	private int  quantite ;
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	@ManyToOne
    private Marque marque ;
	public MakeUp() {
	super();
	}
	public MakeUp(String nomMakeUp, Double prixMakeUp, Date dateCreation,int qte ) {
	super();
	this.nomMakeUp = nomMakeUp;
	this.prixMakeUp = prixMakeUp;
	this.dateCreation = dateCreation;
	this.quantite = qte;
	}
	public Long getRefMakeUp() {
		return refMakeUp;
		}
	public void setRefMakeUp(Long refMakeUp) {
		this.refMakeUp = refMakeUp;
		}
		public String getNomMakeUp() {
		return nomMakeUp;
		}
		public void setNomMakeUp(String nomMakeUp) {
		this.nomMakeUp= nomMakeUp;
		}
		public Double getPrixMakeUp() {
		return prixMakeUp;
		}
		public void setPrixMakeUp(Double prixMakeUp) {
		this.prixMakeUp = prixMakeUp;
		}
		public Date getDateCreation() {
		return dateCreation;
		}
		public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
		}
		public int getQuantite() {
			return quantite;
			}
			public void setQuantite(int quantite) {
			this.quantite = quantite;
			}
		@Override
		public String toString() {
		return "MakeUp [referenceMakeUp=" + refMakeUp + ", nomMakeUp=" + 
				nomMakeUp + ", prixMakeUp=" + prixMakeUp
		+ ", dateCreation=" + dateCreation +",quantite="+quantite+ "]";
		}
}


