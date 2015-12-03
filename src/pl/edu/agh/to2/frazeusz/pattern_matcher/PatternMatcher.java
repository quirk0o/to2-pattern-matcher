package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.monitor.MonitorPubSub;
import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatternMatcher implements IPatternMatcher {

    private MonitorPubSub monitor;

    private String url;
    private List<SearchPattern> patterns = new ArrayList<>();
    private IWordProvider wordProvider;

    private List<IMatchListener> listeners = new LinkedList<>();

    public PatternMatcher(String url, IWordProvider wordProvider, MonitorPubSub monitor) {
        this.monitor = monitor;
        this.url = url;
        this.wordProvider = wordProvider;
    }

    @Override
    public void setWordProvider(IWordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    @Override
    public List<String> match(List<String> sentences, String url) {
        throw new NotImplementedException();
    }

    @Override
    public JPanel getView() {
        PatternController controller = new PatternController(patterns);
        controller.init();
        return controller.getView();
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
