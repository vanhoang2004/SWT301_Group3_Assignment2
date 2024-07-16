package test.integration.swt_assignment_2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private Employee employee;
    private Item item;
    private Customer customer;
}
