package com.demo.validationgroup;


import java.util.Date;

import javax.validation.constraints.NotNull;

public class Operation implements Tracabilite {
  private Date dateCreation;
  private Date dateModification;
  private Long utilisateur;
  private String designation;
  
  public Operation(Date dateCreation, Date dateModification, Long utilisateur,
      String designation) {
    super();
    this.dateCreation = dateCreation;
    this.dateModification = dateModification;
    this.utilisateur = utilisateur;
    this.designation = designation;
  }

  @NotNull
  public String getDesignation() {
    return this.designation;
  }

  @Override
  public Date getDateCreation() {
    return this.dateCreation;
  }

  @Override
  public Date getDateModif() {
    return this.dateModification;
  }

  @Override
  public Long getUtilisateur() {
    return utilisateur;
  }
}