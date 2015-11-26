package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.monitor.MonitorPubSub;
import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;
import pl.edu.agh.to2.frazeusz.pattern_matcher.views.PatternView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatternMatcher implements IPatternMatcher, IMatchProvider {

    private MonitorPubSub monitor;

    private String url;
    private List<SearchPattern> patterns = new ArrayList<>();
    private IWordProvider wordProvider;

    private List<IMatchListener> listeners = new LinkedList<>();

    private PatternView view;

    public PatternMatcher(MonitorPubSub monitor, String url, IWordProvider wordProvider) {
        this.monitor = monitor;
        this.url = url;
        this.wordProvider = wordProvider;
    }

    @Override
    public List<SearchPattern> getPatterns() {
        return patterns;
    }

    @Override
    public void setWordProvider(IWordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    @Override
    public List<String> match(List<String> sentences, String url) {
        return null;
    }

    @Override
    public void addPattern(SearchPattern pattern) {

    }

    @Override
    public void removePattern(SearchPattern pattern) {

    }

    @Override
    public void onMatchCompleted(SearchPattern pattern, List<String> sentences) {
        for (IMatchListener listener : listeners)
            listener.addMatches(pattern, sentences, url);
    }

    @Override
    public void addListener(IMatchListener listener) {
        listeners.add(listener);
    }
}
