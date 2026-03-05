package tn.vermeg.gestionproduit.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "souscriptions")
public class Souscription {
    @Id
    private String idSouscription;

    private String idProduit;
    private String idClient;

    private Date dateSouscription;
    private Date dateFin;

    private StatutProduit statut;

    public StatutProduit getStatut() {return statut;}
    public void setStatut(StatutProduit statut) {this.statut = statut;}
    public Date getDateFin() {return dateFin;}
    public void setDateFin(Date dateFin) {this.dateFin = dateFin;}
    public Date getDateSouscription() {return dateSouscription;}
    public void setDateSouscription(Date dateSouscription) {this.dateSouscription = dateSouscription;}
    public String getIdClient() {return idClient;}
    public void setIdClient(String idClient) {this.idClient = idClient;}
    public String getIdProduit() {return idProduit;}
    public void setIdProduit(String idProduit) {this.idProduit = idProduit;}
    public String getIdSouscription() {return idSouscription;}
    public void setIdSouscription(String idSouscription) {this.idSouscription = idSouscription;}

    public Souscription() {}
    public Souscription(String idSouscription, String idProduit,
                        String idClient, Date dateSouscription,
                        Date dateFin, StatutProduit statut) {
        this.idSouscription = idSouscription;
        this.idProduit = idProduit;
        this.idClient = idClient;
        this.dateSouscription = dateSouscription;
        this.dateFin = dateFin;
        this.statut = statut;
    }
}
