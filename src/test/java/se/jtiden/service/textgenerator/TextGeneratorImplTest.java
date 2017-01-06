package se.jtiden.service.textgenerator;

import org.junit.Test;
import se.jtiden.entities.Subject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TextGeneratorImplTest {

    private TextGeneratorImpl textGenerator = new TextGeneratorImpl();


    @Test
    public void testName() throws Exception {


        Subject michaelJacksson = michaelJacksson();
        String text = textGenerator.describe(michaelJacksson);

        assertThat(text, is("hej"));
    }

    private Subject michaelJacksson() {
        Subject mock = mock(Subject.class);
        return mock;

    }
}