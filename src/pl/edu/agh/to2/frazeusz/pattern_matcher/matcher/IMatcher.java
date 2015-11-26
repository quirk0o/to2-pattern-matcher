package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher;

import java.util.List;

public interface IMatcher {
    List<String> match(List<String> sentences);
}
