package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiminutiveStrategy extends AbstractMatchingStrategy {

    public DiminutiveStrategy(IWordProvider wordProvider) {
        super(wordProvider);
    }

    @Override
    public String format(String pattern) {
        Set<String> words = split(pattern);
        Set<String> addWords;

        for (String word : words) {
            addWords = wordProvider.getDiminutives(word);
            addWords.add(word);
            pattern = pattern.replaceAll(word, join(addWords));
        }

        return pattern;
    }

    @Override
    public Map<String, Set<String>> getWords(String pattern) {
        Set<String> words = split(pattern);
        Set<String> addWords;
        Map<String, Set<String>> wordMap = new HashMap<>();

        for (String word : words) {
            addWords = wordProvider.getDiminutives(word);
            addWords.add(word);
            wordMap.put(word, addWords);
        }

        return wordMap;
    }
}
