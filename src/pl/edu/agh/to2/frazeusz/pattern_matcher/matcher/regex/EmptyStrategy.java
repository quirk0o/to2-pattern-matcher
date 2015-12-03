package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.regex.Pattern;

public class EmptyStrategy extends AbstractMatchingStrategy {

    public EmptyStrategy(IWordProvider wordProvider) {
        super(wordProvider);
    }
}
