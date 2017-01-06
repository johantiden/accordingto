package se.jtiden.entities;

/**
 * Format:
 * {@link Subject} is/was x
 */
public class Statement {
    private final Subject subject;
    private final String statement;

    public Statement(Subject subject, String statement) {
        this.subject = subject;
        this.statement = statement;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getStatement() {
        return statement;
    }
}
