package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import java.util.regex.Pattern;

public class CaseInsensitiveStrategy implements IMatchingStrategy {
    @Override
    public String format(String pattern) {
        return pattern;
    }

    @Override
    public Pattern compile(String pattern) {
        return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    }
}
