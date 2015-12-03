package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.regex.Pattern;

public class CaseInsensitiveStrategy extends AbstractMatchingStrategy {

    public CaseInsensitiveStrategy(IWordProvider wordProvider) {
        super(wordProvider);
    }

    @Override
    public Pattern compile(String pattern) {
        return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    }
}
