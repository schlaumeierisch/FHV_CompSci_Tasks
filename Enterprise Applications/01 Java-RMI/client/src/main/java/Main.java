import application.api.CustomerService;
import application.dto.CustomerDTO;

import java.rmi.Naming;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            CustomerService customerService = (CustomerService) Naming.lookup("rmi://10.0.40.163/getCustomersByName");

            List<CustomerDTO> customers = customerService.getCustomerByName("Jake");

            System.out.println(customers.get(0).getFirstName());

            // System.out.println(customerService.getCustomerByName("Jake").get(0).getFirstName());

        } catch (Exception e) {

            System.out.println("CalculatorClient exception: " + e.getMessage());
            e.printStackTrace();

        }

    }

}