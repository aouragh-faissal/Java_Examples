package com.demo.validation;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class PersonneBean {
  
  @NotNull
  @Size(max=50, min=3)
  private String nom;
  @NotNull
  @Size(max=50 , min=3)
  private String prenom;
  @Past
  private Date dateNaissance;

  public PersonneBean(String nom, String prenom, Date dateNaissance) {
    super();
    this.nom = nom;
    this.prenom = prenom;
    this.dateNaissance = dateNaissance;
  }


  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }


  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }


  public Date getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }
}