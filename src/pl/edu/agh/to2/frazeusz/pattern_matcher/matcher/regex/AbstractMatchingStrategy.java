package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractMatchingStrategy implements IMatchingStrategy {

    protected IWordProvider wordProvider;

    public AbstractMatchingStrategy(IWordProvider wordProvider) {
        this.wordProvider = wordProvider;
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
    public List<String> getWords(String pattern) {
        return new ArrayList<>();
    }

    @Override
    public int getFlags(String pattern) {
        return 0;
    }
}
