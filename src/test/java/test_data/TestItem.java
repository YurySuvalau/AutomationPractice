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
            .itemName("Blouse")
            .build();
    Item itemPrintedSummerDress = Item.builder()
            .itemName("Printed Summer Dress")
            .build();
    Item itemProductCount = Item.builder()
            .build();
}




