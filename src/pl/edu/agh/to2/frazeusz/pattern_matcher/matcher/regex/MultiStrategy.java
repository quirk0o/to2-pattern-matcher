package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.*;
import java.util.regex.Pattern;

public class MultiStrategy extends AbstractMatchingStrategy {

    private List<IMatchingStrategy> strategies = new LinkedList<>();

    public MultiStrategy(List<IMatchingStrategy> strategies, IWordProvider wordProvider) {
        super(wordProvider);
        this.strategies = strategies;
    }

    @Override
    public String format(String pattern) {
        Map<String, Set<String>> wordMap = getWords(pattern);

        for (String word : wordMap.keySet())
            pattern = pattern.replaceAll(word, join(wordMap.get(word)));

        return pattern;
    }

    @Override
    public Pattern compile(String pattern) {
        return Pattern.compile(pattern, getFlags());
    }

    @Override
    public Map<String, Set<String>> getWords(String pattern) {
        Map<String, Set<String>> wordMap = new HashMap<>();
        Map<String, Set<String>> tmpMap;
        Set<String> addWords;

        for (IMatchingStrategy strategy : strategies) {
            tmpMap = strategy.getWords(pattern);
            for (String word : tmpMap.keySet()) {
                addWords = tmpMap.get(word);

                if (wordMap.containsKey(word))
                    wordMap.get(word).addAll(addWords);
                else
                    wordMap.put(word, addWords);
            }
        }

        return wordMap;
    }

    @Override
    public int getFlags() {
        int flags = 0;

        for (IMatchingStrategy strategy : strategies)
            flags |= strategy.getFlags();

        return flags;
    }
}
