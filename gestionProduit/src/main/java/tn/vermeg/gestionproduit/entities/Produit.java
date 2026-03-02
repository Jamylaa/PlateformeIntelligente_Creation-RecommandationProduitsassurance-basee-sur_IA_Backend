package tn.vermeg.gestionproduit.entities;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "produits")
public class Produit {

    @Id
    private String idProduit;
    private String nomProduit;
    private Date effectiveDate;
    private float version;
    private Integer minScore;        // score minimum requis
    private Double basePrice;
    private Integer coverageDuration; // années
    private Double capital;           // pour assurance vie
    private Category category;
    private Integer nombreBeneficiaries;
    private Boolean active = true;

    public Integer getNombreBeneficiaries() {return nombreBeneficiaries;}
    public void setNombreBeneficiaries(Integer nombreBeneficiaries) {this.nombreBeneficiaries = nombreBeneficiaries;}
    public Integer getMinScore() {return minScore;}
    public void setMinScore(Integer minScore) {this.minScore = minScore;}
    public Double getBasePrice() {return basePrice;}
    public void setBasePrice(Double basePrice) {this.basePrice = basePrice;}
    public Integer getCoverageDuration() {return coverageDuration;}
    public void setCoverageDuration(Integer coverageDuration) {this.coverageDuration = coverageDuration;}
    public Double getCapital() {return capital;}
    public void setCapital(Double capital) {this.capital = capital;}
    public Boolean getActive() {return active;}
    public void setActive(Boolean active) {this.active = active;}

    public Produit(String idProduit, String nomProduit,
                   Date effectiveDate, float version,
                   Integer minScore, Double basePrice,
                   Integer coverageDuration, Double capital, Category category,
                   Integer nombreBeneficiaries, Boolean active) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.effectiveDate = effectiveDate;
        this.version = version;
        this.minScore = minScore;
        this.basePrice = basePrice;
        this.coverageDuration = coverageDuration;
        this.capital = capital;
        this.category = category;
        this.nombreBeneficiaries = nombreBeneficiaries;
        this.active = active;
    }

    public Produit() {}
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}
    public float getVersion() {return version;}
    public void setVersion(float version) {this.version = version;}
    public Date getEffectiveDate() {return effectiveDate;}
    public void setEffectiveDate(Date effectiveDate) {this.effectiveDate = effectiveDate;}
    public String getNomProduit() {return nomProduit;}
    public void setNomProduit(String nomProduit) {this.nomProduit = nomProduit;}
    public String getIdProduit() {return idProduit;}
    public void setIdProduit(String idProduit) {this.idProduit = idProduit;}
}