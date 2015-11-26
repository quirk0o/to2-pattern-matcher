package pl.edu.agh.to2.frazeusz.models;

public class SearchPattern {
    private String pattern;
    private Boolean caseSensitive;
    private Boolean synonyms;
    private Boolean variants;
    private Boolean diminutives;

    public SearchPattern(String pattern) {
        this.pattern = pattern;
    }

    public SearchPattern(String pattern, Boolean caseSensitive, Boolean synonyms, Boolean variants, Boolean diminutives) {
        this.pattern = pattern;
        this.caseSensitive = caseSensitive;
        this.synonyms = synonyms;
        this.variants = variants;
        this.diminutives = diminutives;
    }

    public String getPattern() {
        return pattern;
    }
    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }
    public void setCaseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public Boolean getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(Boolean synonyms) {
        this.synonyms = synonyms;
    }

    public Boolean getVariants() {
        return variants;
    }
    public void setVariants(Boolean variants) {
        this.variants = variants;
    }

    public Boolean getDiminutives() {
        return diminutives;
    }
    public void setDiminutives(Boolean diminutives) {
        this.diminutives = diminutives;
    }

}