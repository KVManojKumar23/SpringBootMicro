package manoj.org.product_services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manoj.org.product_services.dto.ProductDTO;
import manoj.org.product_services.services.ProductServices;

@RestController 
@RequestMapping("/products")
public class ProductController {


    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOs = this.productServices.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }

    @GetMapping ("/getById/{id}")
    public ResponseEntity<ProductDTO> getProductsById(@PathVariable (name = "id") int productId) {
        ProductDTO productDTO = this.productServices.getProductById(productId);
        if (productDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
