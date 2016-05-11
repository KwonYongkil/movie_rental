import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void setPriceCode() throws Exception {
        Movie movie = new Movie("Hello", Movie.CHILDRENS);
        movie.setPriceCode(Movie.NEW_RELEASE);
        assertThat(movie.getPriceCode(), is(Movie.NEW_RELEASE));
    }

}