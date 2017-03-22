package se.jtiden.service.textgenerator;

import jersey.repackaged.com.google.common.collect.Lists;
import org.junit.Test;
import se.jtiden.entities.Statement;
import se.jtiden.entities.Subject;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static se.jtiden.TestUtil.strictMock;

public class TextGeneratorImplTest {

    private TextGeneratorImpl textGenerator = new TextGeneratorImpl();


    @Test
    public void testName() throws Exception {


        Subject michaelJacksson = michaelJacksson();
        String text = textGenerator.describe(michaelJacksson);

        assertThat(text, is("Is a singer. Is from USA. Was born on August 29, 1958. Is a songwriter. Is a record producer. Called the \"King of Pop\"."));
    }

    private Subject michaelJacksson() {
        Subject mock = strictMock(Subject.class);
        List<Statement> statements = Lists.newArrayList();

        statements.add(statement("Is from USA.", 5));
        statements.add(statement("Was born on August 29, 1958.", 4.5));
        statements.add(statement("Is a singer.", 6));
        statements.add(statement("Is a songwriter.", 4));
        statements.add(statement("Is a record producer.", 3));
        statements.add(statement("Called the \"King of Pop\".", 2));

        when(mock.getStatements()).thenReturn(statements);
        return mock;

    }

    private Statement statement(String statement, double totalInterest) {
        Statement mock = strictMock(Statement.class);
        when(mock.getStatement()).thenReturn(statement);
        when(mock.getTotalInterest()).thenReturn(totalInterest);
        return mock;
    }
}