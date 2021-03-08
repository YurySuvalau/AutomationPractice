package object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String itemName;
    private String itemUnitPrice;
    private String itemQuantity;
    private String itemDiscount;
    private String itemShippingCost;
    private String itemTwoQuantity;
    private String itemTotalCost;
    private String productCountOneItem;
    private String productCountFiveItem;
}
