package manoj.org.product_services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import manoj.org.product_services.dto.ProductDTO;

@Service
public class ProductServices {

    private List<ProductDTO> productList = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.productList.add(new ProductDTO(1, "Laptop",
                "12th Generation Intel Core i7-12700H Processor, 16GB RAM, 512GB SSD, NVIDIA GeForce RTX 3060 Laptop GPU, 15.6-inch FHD Display, Windows 11 Home"));
        this.productList.add(new ProductDTO(2, "Mouse", "Wireless Optical Mouse with USB Receiver"));
        this.productList.add(new ProductDTO(3, "Keyboard", "Mechanical Gaming Keyboard with RGB Backlight"));
        this.productList.add(new ProductDTO(4, "Monitor", "27-inch 1440p IPS Monitor with HDR Support"));
    }

    public List<ProductDTO> getAllProducts() {
        return this.productList;
    }

    public ProductDTO getProductById(int productId) {
        return this.productList.stream().filter(product -> product.getProductId() == productId).findFirst()
                .orElse(null);
    }

}
