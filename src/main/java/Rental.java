public class Rental {
    public static final int BONUS_POINT = 2;
    public static final int NORMAL_POINT = 1;
    private Movie _movie;
    private int _daysRented;
    private double amount;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
        amount = 0;
    }


    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getAmount() {
        return amount;
    }

    void calcAmount() {
        double thisAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        this.amount = thisAmount;
    }

    double getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            return BONUS_POINT; 
        else
            return NORMAL_POINT;
    }
}
