package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

import java.util.regex.Pattern;

public interface IMatchingStrategy {
    String format(SearchPattern pattern);
    Pattern compile(String pattern);
}
