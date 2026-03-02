package tn.vermeg.gestionproduit.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InsuranceResponse {
        private Integer finalScore;
        private String eligibility;
        private List<String> recommendedProducts;
}