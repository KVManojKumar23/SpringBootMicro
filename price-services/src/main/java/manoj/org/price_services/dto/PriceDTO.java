package manoj.org.price_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class PriceDTO {

    private int priceId;
    private int productId;
    private double price;
    private String currency;

}
