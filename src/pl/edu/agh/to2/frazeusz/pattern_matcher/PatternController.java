package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.pattern_matcher.views.PatternView;

import javax.swing.*;
import java.util.List;

public class PatternController {

    private List<SearchPattern> patterns;
    private PatternView view;

    public PatternController(List<SearchPattern> patterns) {
        this.patterns = patterns;
    }

    public void init() {
        view = new PatternView(patterns, this);
    }

    public List<SearchPattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<SearchPattern> patterns) {
        this.patterns = patterns;
    }

    public SearchPattern addPattern() {
        SearchPattern pattern = new SearchPattern();
        patterns.add(pattern);
        return pattern;
    }

    public void removePattern(SearchPattern pattern) {
        patterns.remove(pattern);
    }

    public JPanel getView() {
        return view;
    }
}
