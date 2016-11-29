import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.RealSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankitmishra on 26/11/16.
 */
public class CustomerTest {
    private static final String RESULT_FOOTER_AMOUNT = "Amount owed is %s\n";
    private static final String RESULT_FOOTER_EARNED_POINTS = "You earned %s frequent renter points";
    private Customer customer;
    private List<Rental> rentals

    @Before
    public void setUp() throws Exception {
        customer = new Customer("test_customer");
        rentals = new ArrayList<Rental>();
    }

    @Test
    public void statementWithTotalAmountZeroAndFrequentRentalPointZero(){
        Assert.assertEquals(prepareFooterStatement(0.0,0),customer.statement());
    }
    @Test
    public void statmentWithRegularMovieRentedForLessThanTwoDays(){
        Rental rental = new Rental(new Movie("test_movie_regular",0),1);
        customer.addRental(rental);

    }

    private String prepareFooterStatement(Double amount,int points){
        String result = "Rental Record for " + customer.getName() + "\n" +
                            String.format(RESULT_FOOTER_AMOUNT,String.valueOf(amount))+
                            String.format(RESULT_FOOTER_EARNED_POINTS,String.valueOf(points));
        return result;
    }

    private String prepareStatementBodyForRegularMovies(){
        String result =null;
        for(Rental rental:rentals){
            result += "\t" + rental.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
        }

    }


}