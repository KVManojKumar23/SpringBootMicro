package manoj.org.price_services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manoj.org.price_services.dto.PriceDTO;
import manoj.org.price_services.dto.ProductDetails;
import manoj.org.price_services.services.PriceServices;

@RestController 
@RequestMapping("/price")
public class PriceController {

    private final PriceServices priceServices;
    
    public PriceController(PriceServices priceServices) {
        this.priceServices = priceServices;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PriceDTO>> getAllPrices() {
        List<PriceDTO> priceList = priceServices.getAllPrices();
        return ResponseEntity.status(HttpStatus.OK).body(priceList);
    }

    @GetMapping ("/getByProductId/{id}")
    public ResponseEntity<ProductDetails> getPriceByProductId(@PathVariable(name = "id") int productId) {
        ProductDetails productDetails = this.priceServices.getPriceByProductId(productId);
        if (productDetails != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productDetails);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
