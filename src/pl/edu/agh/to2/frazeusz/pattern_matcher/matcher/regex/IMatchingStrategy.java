package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public interface IMatchingStrategy {
    String format(String pattern);
    Pattern compile(String pattern);
    Map<String, Set<String>> getWords(String pattern);
    int getFlags();
}
