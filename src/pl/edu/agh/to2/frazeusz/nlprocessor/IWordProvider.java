package pl.edu.agh.to2.frazeusz.nlprocessor;

import java.util.List;

public interface IWordProvider {
    List<String> getSynonyms(String word);
    List<String> getVariants(String word);
    List<String> getDiminutives(String word);
}
