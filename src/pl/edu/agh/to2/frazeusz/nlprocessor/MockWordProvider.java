package pl.edu.agh.to2.frazeusz.nlprocessor;

import java.util.ArrayList;
import java.util.List;

public class MockWordProvider implements IWordProvider {

    @Override
    public List<String> getSynonyms(String word) {
        List<String> synonyms = new ArrayList<>();
        synonyms.add("synonym1");
        synonyms.add("synonym2");
        synonyms.add("synonym3");

        return synonyms;
    }

    @Override
    public List<String> getVariants(String word) {
        List<String> variants = new ArrayList<>();
        variants.add("variant1");
        variants.add("variant2");
        variants.add("variant3");

        return variants;
    }

    @Override
    public List<String> getDiminutives(String word) {
        List<String> diminutives = new ArrayList<>();
        diminutives.add("d.");

        return diminutives;
    }
}
