package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.regex.Pattern;

public class DiminutiveStrategy extends AbstractMatchingStrategy {

    public DiminutiveStrategy(IWordProvider wordProvider) {
        super(wordProvider);
    }

    @Override
    public String format(String pattern) {
        return null;
    }
}
