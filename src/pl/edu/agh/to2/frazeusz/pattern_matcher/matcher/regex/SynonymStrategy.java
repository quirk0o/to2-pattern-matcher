package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

import java.util.regex.Pattern;

public class SynonymStrategy implements IMatchingStrategy {
    @Override
    public String format(SearchPattern pattern) {
        return null;
    }

    @Override
    public Pattern compile(String pattern) {
        return Pattern.compile(pattern);
    }
}
