import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void SetUp() {
        customer = new Customer("Kwon");
    }

    @Test
    public void doRentOneChildrenMovieWithZeroDayStatment() throws Exception {
        customer.addRental(new Rental(new Movie("", Movie.CHILDRENS), 0));
        assertThat(customer.statment(),
                is("Rental Record for Kwon\n\t\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"));
    }

    @Test
    public void doRentOneChildrenMovieOn4DaysStatment() throws Exception {
        customer.addRental(new Rental(new Movie("", Movie.CHILDRENS), 4));
        assertThat(customer.statment(),
                is("Rental Record for Kwon\n\t\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"));
    }

    @Test
    public void doRentTwoMovie() throws Exception {
        customer.addRental(new Rental(new Movie("", Movie.CHILDRENS), 4));
        customer.addRental(new Rental(new Movie("", Movie.REGULAR), 5));
        assertThat(customer.statment(),
                is("Rental Record for Kwon\n\t\t3.0\n\t\t6.5\nAmount owed is 9.5\nYou earned 2 frequent renter points"));
    }

    @Test
    public void doRentThreeMovie() throws Exception {
        customer.addRental(new Rental(new Movie("", Movie.CHILDRENS), 1));
        customer.addRental(new Rental(new Movie("", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("", Movie.NEW_RELEASE), 8));
        assertThat(customer.statment(),
                is("Rental Record for Kwon\n\t\t1.5\n\t\t2.0\n\t\t24.0\nAmount owed is 27.5\nYou earned 4 frequent renter points"));
    }

    @Test
    public void testGetName() throws Exception {
        assertThat(customer.getName(), is("Kwon"));
    }

}