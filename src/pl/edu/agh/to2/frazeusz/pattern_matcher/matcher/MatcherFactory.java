package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;
import pl.edu.agh.to2.frazeusz.pattern_matcher.IPatternMatcher;
import pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MatcherFactory {

    public static IMatcher getMatcher(SearchPattern pattern, IWordProvider wordProvider) {

        IMatchingStrategy strategy;

        List<IMatchingStrategy> strategies = new ArrayList<>(4);
        if (pattern.getSynonyms())
            strategies.add(new SynonymStrategy(wordProvider));
        if (pattern.getVariants())
            strategies.add(new VariantStrategy(wordProvider));
        if (pattern.getDiminutives())
            strategies.add(new DiminutiveStrategy(wordProvider));
        if (!pattern.getCaseSensitive())
            strategies.add(new CaseInsensitiveStrategy(wordProvider));

        if (strategies.size() == 0)
            strategy = new EmptyStrategy(wordProvider);
        else if (strategies.size() == 1)
            strategy = strategies.get(0);
        else
            strategy = new MultiStrategy(strategies, wordProvider);

        return new RegexMatcher(pattern, strategy);
    }
}
