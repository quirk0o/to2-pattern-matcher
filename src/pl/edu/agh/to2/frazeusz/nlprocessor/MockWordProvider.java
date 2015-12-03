package pl.edu.agh.to2.frazeusz.nlprocessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockWordProvider implements IWordProvider {

    @Override
    public Set<String> getSynonyms(String word) {
        Set<String> synonyms = new HashSet<>();
        synonyms.add("synonym1");
        synonyms.add("synonym2");
        synonyms.add("synonym3");

        return synonyms;
    }

    @Override
    public Set<String> getVariants(String word) {
        Set<String> variants = new HashSet<>();
        variants.add("variant1");
        variants.add("variant2");
        variants.add("variant3");

        return variants;
    }

    @Override
    public Set<String> getDiminutives(String word) {
        Set<String> diminutives = new HashSet<>();
        diminutives.add("d.");

        return diminutives;
    }
}
