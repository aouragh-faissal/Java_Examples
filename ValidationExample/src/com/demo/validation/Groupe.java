package com.demo.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Groupe {

  @NotNull
  private String nom;
  @NotNull
  @Valid
  private List<PersonneBean> membres = new ArrayList<PersonneBean>();

  public Groupe(String nom) {
    super();
    this.nom = nom;
    membres = new ArrayList<PersonneBean>();
  }

  public String getNom() {
    return nom;
  }


  public List<PersonneBean> getMembres() {
    return membres;
  }
  
  public void ajouter(PersonneBean personne) {
    membres.add(personne);
  }

  public void supprimer(PersonneBean personne) {
    membres.remove(personne);
  }
}
