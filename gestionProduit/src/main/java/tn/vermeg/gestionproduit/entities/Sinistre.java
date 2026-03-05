package tn.vermeg.gestionproduit.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "sinistres")
public class Sinistre {
    @Id
    private String idSinistre;

    private String IdProduit;    // référence au produit
    private String IdClient;     // référence au client
    private String description;

    private Date dateSinistre;

    private Double montantDemande;
    private Double montantRembourse;

    private String typeSinistre; // accident, incendie, vol, etc.
    private StatutSinistre statut; // DECLARE, EN_COURS, VALIDE, REFUSE

    private NiveauRisque gravite;    // FAIBLE, MOYEN, ELEVE
    private Boolean fraudeSuspectee; //en cas de fraude
    private Integer delaiTraitement;    // en jours

    public NiveauRisque getGravite() {return gravite;}
    public void setGravite(NiveauRisque gravite) {this.gravite = gravite;}
    public Double getMontantDemande() {return montantDemande;}
    public void setMontantDemande(Double montantDemande) {this.montantDemande = montantDemande;}
    public String getTypeSinistre() {return typeSinistre;}
    public void setTypeSinistre(String typeSinistre) {this.typeSinistre = typeSinistre;}
    public StatutSinistre getStatut() {return statut;}
    public void setStatut(StatutSinistre statut) {this.statut = statut;}
    public Boolean getFraudeSuspectee() {return fraudeSuspectee;}
    public void setFraudeSuspectee(Boolean fraudeSuspectee) {this.fraudeSuspectee = fraudeSuspectee;}
    public Integer getDelaiTraitement() {return delaiTraitement;}
    public void setDelaiTraitement(Integer delaiTraitement) {this.delaiTraitement = delaiTraitement;}
    public String getIdSinistre() {return idSinistre;}
    public void setIdSinistre(String idSinistre) {this.idSinistre = idSinistre;}
    public String getIdProduit() {return IdProduit;}
    public void setIdProduit(String IdProduit) {this.IdProduit = IdProduit;}
    public String getIdClient() {return IdClient;}
    public void setIdClient(String IdClient) {this.IdClient = IdClient;}
    public Date getDateSinistre() {return dateSinistre;}
    public void setDateSinistre(Date dateSinistre) {this.dateSinistre = dateSinistre;}
    public Double getMontantRembourse() {return montantRembourse;}
    public void setMontantRembourse(Double montantRembourse) {this.montantRembourse = montantRembourse;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Sinistre(String idSinistre, String idProduit, String idClient,
                    String description, Date dateSinistre, Double montantDemande,
                    Double montantRembourse, String typeSinistre, StatutSinistre statut,
                    NiveauRisque gravite, Boolean fraudeSuspectee, Integer delaiTraitement) {
        this.idSinistre = idSinistre;
        IdProduit = idProduit;
        IdClient = idClient;
        this.description = description;
        this.dateSinistre = dateSinistre;
        this.montantDemande = montantDemande;
        this.montantRembourse = montantRembourse;
        this.typeSinistre = typeSinistre;
        this.statut = statut;
        this.gravite = gravite;
        this.fraudeSuspectee = fraudeSuspectee;
        this.delaiTraitement = delaiTraitement;
    }

    public Sinistre() {}
}