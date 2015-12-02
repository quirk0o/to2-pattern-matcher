package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.nlprocessor.IWordProvider;

import javax.swing.*;
import java.util.List;

public interface IPatternMatcher extends IMatchProvider, IPatternController {

    List<String> match(List<String> sentences, String url);
    void setWordProvider(IWordProvider wordProvider);

    JPanel getView();

}
