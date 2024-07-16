package test.integration.swt_assignment_2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Item {
    private ItemType itemType;
    private double price;
}
