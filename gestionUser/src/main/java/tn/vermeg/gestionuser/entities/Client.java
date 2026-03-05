package tn.vermeg.gestionuser.entities;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "clients")
public class Client extends User {

    private String idCompany;
    private String companyName;
    private String adresse;
    private String secteurActivite;
    private Double chiffreAffaires;
    private Integer nombreEmployes;
    //recommander des produits selon la taille de lentreprise, secteur , risque financier

    //clustering clients + scoring automatique +personnalisation prime
    private Double riskProfileScore;
    private Integer nombreSinistres;
    private Double montantTotalRembourse;
    private List<String> produitsSouscritsIds;

    public String getCompanyName() {return companyName;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}
    public String getIdCompany() {
        return idCompany;
    }
    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getSecteurActivite() {
        return secteurActivite;
    }
    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }
    public Double getChiffreAffaires() {
        return chiffreAffaires;
    }
    public void setChiffreAffaires(Double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
    }
    public Integer getNombreEmployes() {
        return nombreEmployes;
    }
    public void setNombreEmployes(Integer nombreEmployes) {
        this.nombreEmployes = nombreEmployes;
    }
    public Double getRiskProfileScore() {
        return riskProfileScore;
    }
    public void setRiskProfileScore(Double riskProfileScore) {
        this.riskProfileScore = riskProfileScore;
    }
    public Integer getNombreSinistres() {
        return nombreSinistres;
    }
    public void setNombreSinistres(Integer nombreSinistres) {
        this.nombreSinistres = nombreSinistres;
    }
    public Double getMontantTotalRembourse() {
        return montantTotalRembourse;
    }
    public void setMontantTotalRembourse(Double montantTotalRembourse) {this.montantTotalRembourse = montantTotalRembourse;}
    public List<String> getProduitsSouscritsIds() {
        return produitsSouscritsIds;
    }
    public void setProduitsSouscritsIds(List<String> produitsSouscritsIds) {this.produitsSouscritsIds = produitsSouscritsIds;}
    public Client() {}
    public Client(String idUser, String userName,
                  String password, String email,
                  int phone, Boolean active,
                  List<String> produitsSouscritsIds, Double montantTotalRembourse,
                  Integer nombreSinistres, Double riskProfileScore, Integer nombreEmployes, Double chiffreAffaires, String secteurActivite, String adresse,
                  String companyName, String idCompany) {
        super(idUser, userName, password, email, phone, active);
        this.produitsSouscritsIds = produitsSouscritsIds;
        this.montantTotalRembourse = montantTotalRembourse;
        this.nombreSinistres = nombreSinistres;
        this.riskProfileScore = riskProfileScore;
        this.nombreEmployes = nombreEmployes;
        this.chiffreAffaires = chiffreAffaires;
        this.secteurActivite = secteurActivite;
        this.adresse = adresse;
        this.companyName = companyName;
        this.idCompany = idCompany;
    }
}