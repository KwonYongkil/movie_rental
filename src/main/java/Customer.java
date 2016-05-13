import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    private double totalAmount = 0;
    private int frequentRenterPoints = 0;

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        calcAmounts();
        return buildReport();
    }

    private String buildReport() {
        String result = addHeaderToReport();
        result = addRentalsToReport(result);
        result = addFooterToReport(result);
        return result;
    }

    private void calcAmounts() {
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements())
            calcAmount(rentals);
    }

    private void calcAmount(Enumeration rentals) {
        Rental each = (Rental) rentals.nextElement();
        each.calcAmount();
        frequentRenterPoints += each.getFrequentRenterPoints();
        totalAmount += each.getAmount();
    }

    private String addRentalsToReport(String result) {
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result = addRentalToRepoter(result, each);
        }
        return result;
    }

    private String addRentalToRepoter(String result, Rental each) {
        result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
        return result;
    }

    private String addFooterToReport(String result) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }

    private String addHeaderToReport() {
        return "Rental Record for " + getName() + "\n";
    }
}
