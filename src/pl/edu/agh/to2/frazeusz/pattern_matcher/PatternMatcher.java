package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.monitor.MonitorPubSub;
import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;
import pl.edu.agh.to2.frazeusz.pattern_matcher.views.PatternView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatternMatcher implements IPatternMatcher {

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
    public void setWordProvider(IWordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    public PatternView getView() {
        return view;
    }

    @Override
    public List<String> match(List<String> sentences, String url) {
        throw new NotImplementedException();
    }

    @Override
    public SearchPattern addPattern() {
        SearchPattern pattern = new SearchPattern();
        patterns.add(pattern);
        return pattern;
    }

    @Override
    public void removePattern(SearchPattern pattern) {
        patterns.remove(pattern);
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
