package fr.afpa.pompey.cda17.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class Prospect extends Societe{

    @NotNull
    @Past
    private LocalDate dateProspection;

    @NotNull
    @NotBlank
    private String prospectInteresse;

    public Prospect(int identifiant, String raisonSociale, Adresse adresse,
                    String telephone, String mail, String commentaires, LocalDate dateProspection,
                    String prospectInteresse) {
        super(identifiant, raisonSociale, adresse, telephone, mail, commentaires);
        this.dateProspection = dateProspection;
        this.prospectInteresse = prospectInteresse;
    }

    public Prospect(String raisonSociale, Adresse adresse, String telephone,
                    String mail, String commentaires, LocalDate dateProspection,
                    String prospectInteresse) {
        super(raisonSociale, adresse, telephone, mail, commentaires);
        setDateProspection(dateProspection);
        setProspectInteresse(prospectInteresse);
    }

    public Prospect() {
        super();
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) {
        this.dateProspection = dateProspection;
    }

    public String getProspectInteresse() {
        return prospectInteresse;
    }

    public void setProspectInteresse(String prospectInteresse) {
        this.prospectInteresse = prospectInteresse;
    }

    @Override
    public String toString() {
        return super.toString() +
                " dateProspection=" + getDateProspection() +
                ", prospectInteresse='" + getProspectInteresse() + '\'';
    }
}
