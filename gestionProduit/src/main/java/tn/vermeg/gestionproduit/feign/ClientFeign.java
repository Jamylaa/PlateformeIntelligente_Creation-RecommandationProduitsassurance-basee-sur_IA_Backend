package tn.vermeg.gestionproduit.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gestionUser", url = "http://localhost:9090")
public interface ClientFeign {

    @GetMapping("/api/clients/{idClient}")
    Object getClientById(@PathVariable("idClient") String idClient);
}

