package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

import java.util.List;

public interface IMatchListener {
    void addMatches(SearchPattern pattern, List<String> sentences, String url);
}
