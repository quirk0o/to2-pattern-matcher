package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.List;

public interface IPatternMatcher extends IMatchProvider {
    List<String> match(List<String> sentences, String url);

    void addPattern(SearchPattern pattern);
    void removePattern(SearchPattern pattern);
    List<SearchPattern> getPatterns();

    void setWordProvider(IWordProvider wordProvider);
}
