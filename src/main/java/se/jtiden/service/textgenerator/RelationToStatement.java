package se.jtiden.service.textgenerator;

import jersey.repackaged.com.google.common.collect.Lists;
import se.jtiden.entities.Quote;
import se.jtiden.entities.Relation;
import se.jtiden.entities.Statement;
import se.jtiden.entities.Subject;
import se.jtiden.entities.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RelationToStatement {
    public static Statement from(Relation relation) {

        return new Statement() {
            @Override
            public Subject getSubject() {
                return relation.getSubject();
            }

            @Override
            public String getStatement() {
                return getSubject().getName() + " is " + relation.getObject().getName() + "'s " + relation.getRelationType().getName().toLowerCase() + ".";
            }

            @Override
            public Quote getQuote() {
                return relation.getQuote();
            }

            @Override
            public double getTotalInterest() {
                return (relation.getTotalInterest() +
                        relation.getObject().getTotalInterest())
                        / 2.0;
            }

            @Override
            public List<Statement> getVersions() {
                return null;
            }

            @Override
            public Instant getTimestamp() {
                return relation.getTimestamp();
            }

            @Override
            public User getUser() {
                return relation.getUser();
            }
        };

    }

}
