import java.time.LocalDate;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;

public class Test {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("asdasd");
		customer.setPassword("asdsdvcxvxc");
		customer.setPassword_forgot_token("asdasdadg");
		customer.setCity("asdxcvxc");
		customer.setCountry("asdxvbxvbxc");
		customer.setCustomerOrders(null);
		customer.setCustomerReviews(null);
		customer.setEmail("vbxnjbvnorht243");
		customer.setRegisterationDate(LocalDate.now());
		
		CustomerRepo repo = new CustomerRepo();
		repo.create(customer);
	}

}
