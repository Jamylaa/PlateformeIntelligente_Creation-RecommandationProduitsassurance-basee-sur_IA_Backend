package tn.vermeg.gestionproduit.entities;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produits")
public class Produit {

    @Id
    private String idProduit;
    private String nomProduit;
    private Category category;
    private String description;
    private StatutProduit statut; // ACTIF, SUSPENDU, EXPIRE

    // Infos techniques
    private float version;
    private Date dateCreation;
    private Date dateExpiration;
    private Date effectiveDate;

   // âge + secteur + historique sinistre → produit recommandé

    private Integer nombreSouscriptions;
    private Double tauxSinistralite;
     private Double profitabilite;          // Gain réel produit
    private Double franchise;  // en cas de sinistre
    private Double tauxRemboursement;

    //IA
    private Double scoreRecommandation;    // Score calculé par IA
    private Double riskScore; //Score de risque du produit
    private NiveauRisque niveauRisque; // FAIBLE, MOYEN, ELEVE

    // Couverture et garanties
    private List<String> garantiesIds;        //IDs des garanties
    private Double montantMaxRemboursement;

    // Conditions du contrat
    private Integer ageMinAssure;
    private Integer ageMaxAssure;

    private Integer dureeContrat;  // en années
    private Boolean renouvelable;
    private Integer periodeAttente; // en jours ou mois

    // Cotisations et paiement
    private Double prime;
    private String devise; // TND, EUR, USD
    private ModePaiement modePaiement;
    private Double bonusMalus;

    // Fournisseurs et partenaires
    private List<String> reseauMedical; // pour santé
    private Boolean tiersPayant; //payer uniquement la part de votre charge

    // Relations avec l’assuré
    private List<String> clientIds;       // stocke les idUser des assurés
    private String companyId;
    private List<String> historiqueSinistresIds;

    // Champs spécifiques Auto
    private String vehiculeMarque;
    private String vehiculeModele;
    private String immatriculation;
    private Double reductionBonus;

    // Champs spécifiques Habitation
    private Double surfaceHabitation;
    private String typeHabitation; //maison, appart,...
    private String adresseHabitation;
    private Boolean locataire;

    public StatutProduit getStatut() {return statut;}
    public void setStatut(StatutProduit statut) {this.statut = statut;}
    public Date getDateCreation() {return dateCreation;}
    public void setDateCreation(Date dateCreation) {this.dateCreation = dateCreation;}

    public Date getDateExpiration() {return dateExpiration;}
    public void setDateExpiration(Date dateExpiration) {this.dateExpiration = dateExpiration;}
    public String getDevise() {return devise;}
    public void setDevise(String devise) {this.devise = devise;}
    public Double getRiskScore() {return riskScore;}
    public void setRiskScore(Double riskScore) {this.riskScore = riskScore;}
    public NiveauRisque getNiveauRisque() {return niveauRisque;}
    public void setNiveauRisque(NiveauRisque niveauRisque) {this.niveauRisque = niveauRisque;}

    public Integer getNombreSouscriptions() {return nombreSouscriptions;}
    public void setNombreSouscriptions(Integer nombreSouscriptions) {this.nombreSouscriptions = nombreSouscriptions;}
    public Double getTauxSinistralite() {return tauxSinistralite;}
    public void setTauxSinistralite(Double tauxSinistralite) {this.tauxSinistralite = tauxSinistralite;}
    public Double getProfitabilite() {return profitabilite;}
    public void setProfitabilite(Double profitabilite) {this.profitabilite = profitabilite;}
    public Double getScoreRecommandation() {return scoreRecommandation;}
    public void setScoreRecommandation(Double scoreRecommandation) {this.scoreRecommandation = scoreRecommandation;}
    public List<String> getClientIds() {return clientIds;}
    public void setClientIds(List<String> clientIds) {this.clientIds = clientIds;}
    public String getCompanyId() {return companyId;}
    public void setCompanyId(String companyId) {this.companyId = companyId;}
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}
    public String getIdProduit() {return idProduit;}
    public void setIdProduit(String idProduit) {this.idProduit = idProduit;}
    public String getNomProduit() {return nomProduit;}
    public void setNomProduit(String nomProduit) {this.nomProduit = nomProduit;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public List<String> getGarantiesIds() {return garantiesIds;}
    public void setGarantiesIds(List<String> garantiesIds) {this.garantiesIds = garantiesIds;}
    public Double getMontantMaxRemboursement() {return montantMaxRemboursement;}
    public void setMontantMaxRemboursement(Double montantMaxRemboursement) {this.montantMaxRemboursement = montantMaxRemboursement;}
    public Double getFranchise() {return franchise;}
    public void setFranchise(Double franchise) {this.franchise = franchise;}
    public Double getTauxRemboursement() {return tauxRemboursement;}
    public void setTauxRemboursement(Double tauxRemboursement) {this.tauxRemboursement = tauxRemboursement;}
    public Integer getAgeMinAssure() {return ageMinAssure;}
    public void setAgeMinAssure(Integer ageMinAssure) {this.ageMinAssure = ageMinAssure;}
    public Integer getAgeMaxAssure() {return ageMaxAssure;}
    public void setAgeMaxAssure(Integer ageMaxAssure) {this.ageMaxAssure = ageMaxAssure;}
    public Integer getDureeContrat() {return dureeContrat;}
    public void setDureeContrat(Integer dureeContrat) {this.dureeContrat = dureeContrat;}
    public Boolean getRenouvelable() {return renouvelable;}
    public void setRenouvelable(Boolean renouvelable) {this.renouvelable = renouvelable;}
    public Integer getPeriodeAttente() {return periodeAttente;}
    public void setPeriodeAttente(Integer periodeAttente) {this.periodeAttente = periodeAttente;}
    public Double getPrime() {
        return prime;
    }
    public void setPrime(Double prime) {
        this.prime = prime;
    }
    public Produit(String idProduit, String nomProduit,
                   Category category, String description, StatutProduit statut, Date dateCreation,
                   Date dateExpiration, String devise, Double riskScore, NiveauRisque niveauRisque,
                   Integer nombreSouscriptions, Double tauxSinistralite, Double profitabilite,
                   Double scoreRecommandation, List<String> garantiesIds, Double montantMaxRemboursement,
                   Double franchise, Double tauxRemboursement, Integer ageMinAssure,
                   Integer ageMaxAssure, Integer dureeContrat, Boolean renouvelable,
                   Integer periodeAttente, Double prime, ModePaiement modePaiement,
                   Double bonusMalus, List<String> reseauMedical, Boolean tiersPayant,
                   List<String> clientIds, String companyId, List<String> historiqueSinistresIds,
                   Date effectiveDate, float version, String vehiculeMarque, String vehiculeModele,
                   String immatriculation, Double reductionBonus, Double surfaceHabitation, String typeHabitation,
                   String adresseHabitation, Boolean locataire) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.category = category;
        this.description = description;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.devise = devise;
        this.riskScore = riskScore;
        this.niveauRisque = niveauRisque;
        this.nombreSouscriptions = nombreSouscriptions;
        this.tauxSinistralite = tauxSinistralite;
        this.profitabilite = profitabilite;
        this.scoreRecommandation = scoreRecommandation;
        this.garantiesIds = garantiesIds;
        this.montantMaxRemboursement = montantMaxRemboursement;
        this.franchise = franchise;
        this.tauxRemboursement = tauxRemboursement;
        this.ageMinAssure = ageMinAssure;
        this.ageMaxAssure = ageMaxAssure;
        this.dureeContrat = dureeContrat;
        this.renouvelable = renouvelable;
        this.periodeAttente = periodeAttente;
        this.prime = prime;
        this.modePaiement = modePaiement;
        this.bonusMalus = bonusMalus;
        this.reseauMedical = reseauMedical;
        this.tiersPayant = tiersPayant;
        this.clientIds = clientIds;
        this.companyId = companyId;
        this.historiqueSinistresIds = historiqueSinistresIds;
        this.effectiveDate = effectiveDate;
        this.version = version;
        this.vehiculeMarque = vehiculeMarque;
        this.vehiculeModele = vehiculeModele;
        this.immatriculation = immatriculation;
        this.reductionBonus = reductionBonus;
        this.surfaceHabitation = surfaceHabitation;
        this.typeHabitation = typeHabitation;
        this.adresseHabitation = adresseHabitation;
        this.locataire = locataire;
    }
    public ModePaiement getModePaiement() {
        return modePaiement;
    }
    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }
    public Double getBonusMalus() {
        return bonusMalus;
    }
    public void setBonusMalus(Double bonusMalus) {
        this.bonusMalus = bonusMalus;
    }
    public List<String> getReseauMedical() {
        return reseauMedical;
    }
    public void setReseauMedical(List<String> reseauMedical) {
        this.reseauMedical = reseauMedical;
    }
    public Boolean getTiersPayant() {return tiersPayant;}
    public void setTiersPayant(Boolean tiersPayant) {
        this.tiersPayant = tiersPayant;
    }
    public List<String> getHistoriqueSinistresIds() {
        return historiqueSinistresIds;
    }
    public void setHistoriqueSinistresIds(List<String> historiqueSinistresIds) {this.historiqueSinistresIds = historiqueSinistresIds;}
    public Date getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public float getVersion() {
        return version;
    }
    public void setVersion(float version) {
        this.version = version;
    }
    public String getVehiculeMarque() {
        return vehiculeMarque;
    }
    public void setVehiculeMarque(String vehiculeMarque) {
        this.vehiculeMarque = vehiculeMarque;
    }
    public String getVehiculeModele() {
        return vehiculeModele;
    }
    public void setVehiculeModele(String vehiculeModele) {
        this.vehiculeModele = vehiculeModele;
    }
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public Double getReductionBonus() {
        return reductionBonus;
    }
    public void setReductionBonus(Double reductionBonus) {
        this.reductionBonus = reductionBonus;
    }
    public Double getSurfaceHabitation() {
        return surfaceHabitation;
    }
    public void setSurfaceHabitation(Double surfaceHabitation) {
        this.surfaceHabitation = surfaceHabitation;
    }
    public String getTypeHabitation() {
        return typeHabitation;
    }
    public void setTypeHabitation(String typeHabitation) {
        this.typeHabitation = typeHabitation;
    }
    public String getAdresseHabitation() {
        return adresseHabitation;
    }
    public void setAdresseHabitation(String adresseHabitation) {
        this.adresseHabitation = adresseHabitation;
    }
    public Boolean getLocataire() {
        return locataire;
    }
    public void setLocataire(Boolean locataire) {
        this.locataire = locataire;
    }
}

// private Boolean active = true;
//    @DBRef
//    private Client companyName;  // référence vers un client qui est la compagnie
//  private List<Garantie> garanties;
//    private Date effectiveDate;
//    private float version;
//    private Integer minScore;        // score minimum requis
//    private Double basePrice;
//    private Integer coverageDuration; // années
//    private Double capital;           // pour assurance vie
//    private Category category;
//    private Integer nombreBeneficiaries;
//    private Boolean active = true;
//
//    public Integer getNombreBeneficiaries() {return nombreBeneficiaries;}
//    public void setNombreBeneficiaries(Integer nombreBeneficiaries) {this.nombreBeneficiaries = nombreBeneficiaries;}
//    public Integer getMinScore() {return minScore;}
//    public void setMinScore(Integer minScore) {this.minScore = minScore;}
//    public Double getBasePrice() {return basePrice;}
//    public void setBasePrice(Double basePrice) {this.basePrice = basePrice;}
//    public Integer getCoverageDuration() {return coverageDuration;}
//    public void setCoverageDuration(Integer coverageDuration) {this.coverageDuration = coverageDuration;}
//    public Double getCapital() {return capital;}
//    public void setCapital(Double capital) {this.capital = capital;}
//    public Boolean getActive() {return active;}
//    public void setActive(Boolean active) {this.active = active;}
//

//private Double riskScore;              // Score de risque calculé
//private Double tauxSinistralite;       // Nb sinistres / nb contrats
//private Integer nombreSouscriptions;   // Popularité produit
