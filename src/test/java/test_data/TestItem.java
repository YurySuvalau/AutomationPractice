package test_data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import object.Item;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestItem {
    Item itemBlouse = Item.builder()
            .itemQuantity("1")
            .itemName("Blouse")
            .itemUnitPrice("$27.00")
            .build();
    Item itemPrintedSummerDress = Item.builder()
            .itemDiscount("-5%")
            .itemTwoQuantity("$59.96")
            .itemTotalCost("$30.98")
            .build();
    Item itemProductCount = Item.builder()
            .productCountOneItem("Showing 1 - 1 of 1 item")
            .productCountFiveItem("Showing 1 - 5 of 5 items")
            .build();
}




