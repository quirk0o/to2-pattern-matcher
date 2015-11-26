package pl.edu.agh.to2.frazeusz.pattern_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCompiler {

    private static final Pattern starGroupPattern = Pattern.compile("(?<=\\s|^)([*\\s])+(?=\\s|$)");
    private static final Pattern starPattern = Pattern.compile("\\*");
    private static final Pattern whitespacePattern = Pattern.compile("\\s+");

    private static final String starReplace = "(\\b[^\\s]+\\b\\W*){0,%d}";
    private static final String whitespaceReplace = "[\\s,;:\\-'\"\\(\\)]+";
    private static final String lookbehind = "(?<=[\\s\\-'\"\\(])";
    private static final String lookahead = "(?=[\\s.?!,;:\\-'\"\\)])";

    private static String escape(String pattern) {
        return pattern.replace("\\", "\\\\");
    }

    public static Pattern compile(String pattern) {

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

        return Pattern.compile(newPattern);
    }
}