package se.jtiden.entities;

/**
 * Format:
 * {@link Subject} is/was x
 */
public interface Statement {
    Subject getSubject();
    String getStatement();
    double getTotalInterest();
}
