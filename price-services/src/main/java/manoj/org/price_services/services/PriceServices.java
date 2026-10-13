package manoj.org.price_services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import jakarta.annotation.PostConstruct;
import manoj.org.price_services.dto.PriceDTO;
import manoj.org.price_services.dto.ProductDTO;
import manoj.org.price_services.dto.ProductDetails;

@Service
public class PriceServices {

    private List<PriceDTO> priceList = new ArrayList<>();

    private RestClient restClient = RestClient.create();

    @PostConstruct
    public void init() {
        this.priceList.add(new PriceDTO(1, 1, 1200.00, "INR"));
        this.priceList.add(new PriceDTO(2, 2, 25.99, "INR"));
        this.priceList.add(new PriceDTO(3, 3, 79.99, "INR"));
        this.priceList.add(new PriceDTO(4, 4, 299.99, "INR"));
    }

    public List<PriceDTO> getAllPrices() {
        return this.priceList;
    }

    public ProductDetails getPriceByProductId(int productID) {
        ProductDTO product = this.restClient.get()
                .uri("http://product-service:8080/products/getById/" + productID)
                .retrieve()
                .toEntity(ProductDTO.class)
                .getBody();

        // Find the price for the given product ID
        PriceDTO price = this.priceList.stream()
                .filter(p -> p.getProductId() == productID)
                .findFirst()
                .orElse(null);

        if ( product != null && price != null) {
            return new ProductDetails(product, price);
        } else {
            return null;
        }
    }

}
