package pl.edu.agh.to2.frazeusz.models;

interface ISearchPattern {
    String getPattern();
    void setPattern(String pattern);

    Boolean getCaseSensitive();
    void setCaseSensitive(Boolean caseSensitive);

    Boolean getSynonyms();
    void setSynonyms(Boolean synonyms);

    Boolean getVariants();
    void setVariants(Boolean variants);

    Boolean getDiminutives();
    void setDiminutives(Boolean diminutives);

    String getDescription();
}
