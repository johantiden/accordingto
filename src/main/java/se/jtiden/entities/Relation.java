package se.jtiden.entities;

/**
 * Format:
 * {@link Subject} subject is/was {@link Subject} objects's {@link Relation}
 */
public interface Relation extends Editable<Relation> {
    RelationType getRelationType();
    Subject getSubject();
    Subject getObject();
    double getTotalInterest();

    Quote getQuote();
}
