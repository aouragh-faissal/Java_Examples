package com.demo.validation;

import java.util.Date;

import javax.validation.constraints.Min;

public class DeveloppeurSeniorBean extends PersonneBean {

  private int experience;
  
  public DeveloppeurSeniorBean(String nom, String prenom, Date dateNaissance, int experience) {
    super(nom, prenom, dateNaissance);
    this.experience = experience;
  }

  @Min(value=5)
  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }
}
