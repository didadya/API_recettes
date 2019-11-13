package com.ApiRecherche.API_Recherche.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recette {
	
	@Id
	@GeneratedValue
	public int id_recette;
	public String libelle;
	public String niveau;
	public int duree_cuissant;
	public String ingredients;
	public String preparation;
	
	public Recette() {}

	public Recette(int id_recette, String libelle, String niveau, int duree_cuissant, String ingredients,
			String preparation) {
		//super();
		this.id_recette = id_recette;
		this.libelle = libelle;
		this.niveau = niveau;
		this.duree_cuissant = duree_cuissant;
		this.ingredients = ingredients;
		this.preparation = preparation;
	}

	public int getId_recette() {
		return id_recette;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getDuree_cuissant() {
		return duree_cuissant;
	}

	public void setDuree_cuissant(int duree_cuissant) {
		this.duree_cuissant = duree_cuissant;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	@Override
	public String toString() {
		return "Recette [id_recette=" + id_recette + ", libelle=" + libelle + ", niveau=" + niveau + ", duree_cuissant="
				+ duree_cuissant + ", ingredients=" + ingredients + ", preparation=" + preparation + "]";
	}
	
	
	
}


