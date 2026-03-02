package tn.vermeg.gestionproduit.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vermeg.gestionproduit.dto.InsuranceRequest;
import tn.vermeg.gestionproduit.dto.InsuranceResponse;
import tn.vermeg.gestionproduit.service.InsuranceService;

@RestController
@RequestMapping("/api/insurance")
@RequiredArgsConstructor
@CrossOrigin
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/calculate")
    public ResponseEntity<InsuranceResponse> calculate(
            @RequestBody InsuranceRequest request) {
        return ResponseEntity.ok(insuranceService.calculate(request));
    }
}