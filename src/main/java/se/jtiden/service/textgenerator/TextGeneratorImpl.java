package se.jtiden.service.textgenerator;

import se.jtiden.entities.Statement;
import se.jtiden.entities.Subject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextGeneratorImpl implements TextGenerator {
    @Override
    public String describe(Subject subject) {


        List<Statement> statements = subject.getStatements();

        Collections.sort(statements, Comparator.comparing(Statement::getTotalInterest).reversed());

        List<String> sentences = statements.stream().map(Statement::getStatement).collect(Collectors.toList());
        String joined = String.join(" ", sentences);
        return joined;

    }
}
