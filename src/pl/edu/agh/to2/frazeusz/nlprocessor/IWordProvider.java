package pl.edu.agh.to2.frazeusz.nlprocessor;

import java.util.List;
import java.util.Set;

public interface IWordProvider {
    Set<String> getSynonyms(String word);
    Set<String> getVariants(String word);
    Set<String> getDiminutives(String word);
}
