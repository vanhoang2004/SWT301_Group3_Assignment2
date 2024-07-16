package test.integration.swt_assignment_2.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculationForm {
    // Getters and Setters
    private CustomerType customerType;
    private ItemType itemType;
    private Double itemPrice;
    private EmployeeType employeeType;

    public double calculateCommission() {
        double price = itemPrice;

            if (itemType == ItemType.STANDARD){
            return 0 ;
        }
            if (customerType == CustomerType.REGULAR){
            return 0 ;
        }
            if (employeeType == EmployeeType.NON_SALARIED) {
            if (itemType == ItemType.BONUS) {
                if(price <= 1000){
                    return price * 0.1;
                }
                else
                    return 75;
            }
            else { // (itemType == ItemType.OTHER)
                if(price <= 10000){
                    return price * 0.1;
                }else {
                    return price * 0.05;
                }
            }
        } else {  //(employeeType == EmployeeType.SALARIED)
            if (itemType == ItemType.OTHER) {
                if(price <= 10000){
                    return price * 0.1;
                }else {
                    return price * 0.05;
                }
            } else { //(itemType == ItemType.BONUS)
                if(price <= 1000){
                    return price * 0.05;
                }else {
                    return 25;
                }
            }
        }
    }


}
