package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ListMatchingStrategy extends AbstractMatchingStrategy {

    private List<IMatchingStrategy> strategies = new LinkedList<>();

    public ListMatchingStrategy(IWordProvider wordProvider) {
        super(wordProvider);
    }

    @Override
    public String format(String pattern) {
        return null;
    }

    @Override
    public Pattern compile(String pattern) {
        return null;
    }
}
