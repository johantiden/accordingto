package se.jtiden.service.textgenerator;

import jersey.repackaged.com.google.common.collect.Lists;
import org.junit.Test;
import se.jtiden.entities.Relation;
import se.jtiden.entities.RelationType;
import se.jtiden.entities.Statement;
import se.jtiden.entities.Subject;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static se.jtiden.TestUtil.strictMock;

public class TextGeneratorImplTest {

    private final TextGeneratorImpl textGenerator = new TextGeneratorImpl();


    @Test
    public void testName() throws Exception {


        Subject michaelJacksson = michaelJacksson();
        String text = textGenerator.describe(michaelJacksson);

        assertThat(text, is("Is a singer. Is from USA. Was born on August 29, 1958. Is a songwriter. Is a record producer. Michael Jackson is Joseph Jackson's son. Called the \"King of Pop\"."));
    }

    private static Subject michaelJacksson() {
        Subject mock = strictMock(Subject.class);
        List<Statement> statements = Lists.newArrayList();

        doReturn("Michael Jackson").when(mock).getName();
        doReturn(8D).when(mock).getTotalInterest();

        statements.add(statement("Is from USA.", 5));
        statements.add(statement("Was born on August 29, 1958.", 4.5));
        statements.add(statement("Is a singer.", 6));
        statements.add(statement("Is a songwriter.", 4));
        statements.add(statement("Is a record producer.", 3));
        statements.add(statement("Called the \"King of Pop\".", 2));

        List<Relation> relations = Lists.newArrayList();

        relations.add(relation(mock, relationType("Son", 1), subject("Joseph Jackson", 1), 5)); // Is Joseph Jackson's son.

        doReturn(statements).when(mock).getStatements();
        doReturn(relations).when(mock).getRelations();
        return mock;

    }

    private static Subject subject(String name, double totalInterest) {
        Subject mock = strictMock(Subject.class);
        doReturn(name).when(mock).getName();
        doReturn(totalInterest).when(mock).getTotalInterest();
        return mock;
    }

    private static RelationType relationType(String name, double totalInterest) {
        RelationType mock = strictMock(RelationType.class);
        doReturn(name).when(mock).getName();
        doReturn(totalInterest).when(mock).getTotalInterest();
        return mock;
    }

    private static Statement statement(String statement, double totalInterest) {
        Statement mock = strictMock(Statement.class);
        doReturn(statement).when(mock).getStatement();
        doReturn(totalInterest).when(mock).getTotalInterest();
        return mock;
    }
    private static Relation relation(Subject me, RelationType relationType, Subject that, double totalInterest) {
        Relation mock = strictMock(Relation.class);
        doReturn(me).when(mock).getSubject();
        doReturn(that).when(mock).getObject();
        doReturn(relationType).when(mock).getRelationType();
        doReturn(totalInterest).when(mock).getTotalInterest();
        return mock;
    }
}