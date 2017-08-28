package se.jtiden.entities;

public interface Statement extends Editable<Statement> {
    Subject getSubject();

    /**
     * Format: {@link Subject} is/was x
     * @return
     */
    String getStatement();
    Quote getQuote();
    double getTotalInterest();
}
