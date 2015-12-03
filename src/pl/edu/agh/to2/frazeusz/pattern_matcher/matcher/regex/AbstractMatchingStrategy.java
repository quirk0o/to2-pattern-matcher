package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractMatchingStrategy implements IMatchingStrategy {

    protected Pattern wordPattern = Pattern.compile("(?<=\\s|^)[^\\s*]+(?=\\s|$)");

    protected IWordProvider wordProvider;

    public AbstractMatchingStrategy(IWordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    protected Set<String> split(String pattern) {
        Set<String> matches = new HashSet<>();
        Matcher matcher = wordPattern.matcher(pattern);
        while (matcher.find())
            matches.add(matcher.group());

        return matches;
    }

    protected String join(Iterable<String> words) {
        return String.format("(%s)", String.join("|", words));
    }

    @Override
    public String format(String pattern) {
        return pattern;
    }

    @Override
    public Pattern compile(String pattern) {
        return Pattern.compile(pattern);
    }

    @Override
    public Map<String, Set<String>> getWords(String pattern) {
        return new HashMap<>();
    }

    @Override
    public int getFlags(String pattern) {
        return 0;
    }
}
