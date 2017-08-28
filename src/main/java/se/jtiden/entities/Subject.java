package se.jtiden.entities;

import java.util.List;

public interface Subject extends Editable<Subject> {

    String getName();

    List<Statement> getStatements();
    List<Relation> getRelations();

    Double getTotalInterest();
}
