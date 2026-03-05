package tn.vermeg.gestionproduit.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "garanties")
public class Garantie {
    @Id
    private String idGarantie;
    private String libelle;

    private String description;

    private Double plafond;
    private Double franchiseSpecifique;
    private Boolean obligatoire;

    public Garantie(String idGarantie, String libelle, String description,
                    Double plafond, Double franchiseSpecifique, Boolean obligatoire) {
        this.idGarantie = idGarantie;
        this.libelle = libelle;
        this.description = description;
        this.plafond = plafond;
        this.franchiseSpecifique = franchiseSpecifique;
        this.obligatoire = obligatoire;
    }

    public Garantie() {}
    public Double getPlafond() {return plafond;}
    public void setPlafond(Double plafond) {this.plafond = plafond;}
    public Double getFranchiseSpecifique() {return franchiseSpecifique;}
    public void setFranchiseSpecifique(Double franchiseSpecifique) {this.franchiseSpecifique = franchiseSpecifique;}
    public Boolean getObligatoire() {return obligatoire;}
    public void setObligatoire(Boolean obligatoire) {this.obligatoire = obligatoire;}
    public String getIdGarantie() {return idGarantie;}
    public void setIdGarantie(String idGarantie) {this.idGarantie = idGarantie;}
    public String getLibelle() {return libelle;}
    public void setLibelle(String libelle) {this.libelle = libelle;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}