package tn.vermeg.gestionproduit.service;

import tn.vermeg.gestionproduit.dto.InsuranceRequest;
import tn.vermeg.gestionproduit.dto.InsuranceResponse;
import tn.vermeg.gestionproduit.entities.*;
import tn.vermeg.gestionproduit.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final ProduitRepository produitRepository;
    public InsuranceResponse calculate(InsuranceRequest request) {

        int score = 0;

            // Score client de base
            if (request.getClientScore() != null)
                score += request.getClientScore();

            // Logique assurance santé
        if (request.getCategory() == Category.sante) {

                if ("aucun".equalsIgnoreCase(request.getHealthRiskLevel()))
                    score += 50;
                else if ("faible".equalsIgnoreCase(request.getHealthRiskLevel()))
                    score += 30;
                else if ("moyen".equalsIgnoreCase(request.getHealthRiskLevel()))
                    score += 10;
                else if ("eleve".equalsIgnoreCase(request.getHealthRiskLevel()))
                    score -= 20;
            }

            // Logique durée
            if (request.getCoverageDuration() != null)
                score += Math.min(request.getCoverageDuration() * 5, 50);

            // Logique capital
            if (request.getCoverageCapital() != null)
                score += Math.min(request.getCoverageCapital().intValue() / 1000, 100);

            String eligibility = score >= 50 ? "ELIGIBLE" : "NON_ELIGIBLE";

            // 🔥Recommandation produits Mongo
             Category cat = request.getCategory();
            List<Produit> produits =
                    produitRepository.findByCategoryAndActiveTrue(cat);

            List<String> recommended = new ArrayList<>();

            for (Produit p : produits) {
                if (p.getMinScore() != null && score >= p.getMinScore()) {
                    recommended.add(p.getNomProduit());
                }
            }

            return InsuranceResponse.builder()
                    .finalScore(score)
                    .eligibility(eligibility)
                    .recommendedProducts(recommended)
                    .build();
        }
    }


