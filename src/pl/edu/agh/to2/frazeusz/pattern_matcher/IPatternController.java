package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

public interface IPatternController {
    SearchPattern addPattern();
    void removePattern(SearchPattern pattern);
}
