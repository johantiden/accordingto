package se.jtiden.entities;

import java.util.Optional;

public interface Source extends Editable<Source> {
    QuoteType getSourceType();
    String getName();
    Optional<Subject> getSourceAsSubject();
    Source getParentSource();
}
