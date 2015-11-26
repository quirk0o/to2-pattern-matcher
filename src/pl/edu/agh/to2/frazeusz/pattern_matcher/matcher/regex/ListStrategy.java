package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ListStrategy implements IMatchingStrategy {

    private List<IMatchingStrategy> strategies = new LinkedList<>();

    @Override
    public String format(SearchPattern pattern) {
        return null;
    }

    @Override
    public Pattern compile(String pattern) {
        return null;
    }
}
