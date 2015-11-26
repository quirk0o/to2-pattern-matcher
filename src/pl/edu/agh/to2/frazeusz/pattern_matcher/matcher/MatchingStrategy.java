package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher;

import java.util.List;

public interface MatchingStrategy {
    List<String> match(List<String> sentences);
}
