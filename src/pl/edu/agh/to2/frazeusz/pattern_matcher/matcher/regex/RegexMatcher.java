package pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.regex;

import pl.edu.agh.to2.frazeusz.pattern_matcher.ui.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.pattern_matcher.IMatchListener;
import pl.edu.agh.to2.frazeusz.pattern_matcher.IMatchProvider;
import pl.edu.agh.to2.frazeusz.pattern_matcher.matcher.IMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher implements IMatcher, IMatchProvider {

    private static final Pattern starGroupPattern = Pattern.compile("(?<=\\s|^)([*\\s])+(?=\\s|$)");
    private static final Pattern starPattern = Pattern.compile("\\*");
    private static final Pattern whitespacePattern = Pattern.compile("\\s+");

    private static final String starReplace = "(\\b[^\\s]+\\b\\W*){0,%d}";
    private static final String whitespaceReplace = "[\\s,;:\\-'\"\\(\\)]+";
    private static final String lookbehind = "(?<=[\\s\\-'\"\\(])";
    private static final String lookahead = "(?=[\\s.?!,;:\\-'\"\\)])";

    private SearchPattern pattern;
    private IMatchingStrategy matchingStrategy;

    public RegexMatcher(SearchPattern pattern, IMatchingStrategy matchingStrategy) {
        this.pattern = pattern;
        this.matchingStrategy = matchingStrategy;
    }

    private String escape(String pattern) {
        return pattern.replace("\\", "\\\\");
    }

    private Pattern compile() {

        String pattern = matchingStrategy.format(this.pattern.getPattern());

        // Remove additional whitespace
        pattern = pattern.trim();

        Matcher starGroupMatcher = starGroupPattern.matcher(pattern);
        Matcher starMatcher;

        // Initialize buffer
        StringBuffer patternBuffer = new StringBuffer(lookbehind);
        int count;

        // Find groups of *
        while (starGroupMatcher.find()) {
            starMatcher = starPattern.matcher(starGroupMatcher.group());

            // Count number of stars within group
            count = 0;
            while (starMatcher.find())
                count++;

            // Replace star group with word regex
            starGroupMatcher.appendReplacement(patternBuffer, String.format(escape(starReplace), count));
        }

        // Copy remaining input to buffer
        starGroupMatcher.appendTail(patternBuffer);
        patternBuffer.append(lookahead);

        // Replace all whitespace with legal separator regex
        Matcher whitespaceMatcher = whitespacePattern.matcher(patternBuffer);
        String newPattern = whitespaceMatcher.replaceAll(escape(whitespaceReplace));

        return matchingStrategy.compile(newPattern);
    }

    @Override
    public List<String> match(List<String> sentences) {
        Pattern pattern = compile();

        List<String> result = new ArrayList<>(sentences.size());
        for (String sentence : sentences) {
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.find())
                result.add(sentence);
        }

        return result;
    }

    @Override
    public void onMatchCompleted(SearchPattern pattern, List<String> sentences) {

    }

    @Override
    public void addListener(IMatchListener listener) {

    }
}
