package se.jtiden.entities;

import java.time.Instant;
import java.util.List;

public interface Editable<T> {
    List<T> getVersions();
    Instant getTimestamp();
    User getUser();
}
