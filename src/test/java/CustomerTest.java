import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void statment() throws Exception {
        Customer customer = new Customer("Kwon");
        customer.addRental(new Rental(new Movie("",Movie.CHILDRENS),0));

        assertThat(customer.getName(), is("Kwon"));
//        assertThat(customer.statment(),
//                is("Rental Record for Kwon\\n\\t\\t1.5\\nAmount owed is 1.5\\nYou earned 1 frequent renter points"));
    }

    @Test
    public void getName() throws Exception {
        Customer customer = new Customer("");
        assertThat(customer.getName(), is(""));
    }

}