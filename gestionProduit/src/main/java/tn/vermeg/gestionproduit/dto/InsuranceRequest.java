package tn.vermeg.gestionproduit.dto;

import lombok.Data;
import tn.vermeg.gestionproduit.entities.Category;

@Data
public class InsuranceRequest {
    private Category category; // sante, habitation, auto
    private Integer clientScore;
    private Integer coverageDuration;
    private Double coverageCapital;
    private String healthRiskLevel; // aucun, faible, moyen, eleve
}