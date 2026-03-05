package tn.vermeg.gestionuser.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import tn.vermeg.gestionproduit.entities.Produit;

@FeignClient(name = "gestionProduit")
public interface ProduitFeignClient {
    @GetMapping("/produits")
    List<Produit> getAllProduits();

    @GetMapping("/produits/{idProduit}")
    Produit getProduitById(@PathVariable String idProduit);
}