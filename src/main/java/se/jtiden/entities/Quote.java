package se.jtiden.entities;

public interface Quote extends Editable {
    QuoteType getSourceType();
    String getQuote();
    Source getSource();
}
