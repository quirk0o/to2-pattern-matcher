package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

import javax.swing.*;
import java.util.List;

public interface IPatternController {
    List<SearchPattern> getPatterns();
    void setPatterns(List<SearchPattern> patterns);
    SearchPattern addPattern();
    void removePattern(SearchPattern pattern);

    void init();
    JPanel getView();
}
