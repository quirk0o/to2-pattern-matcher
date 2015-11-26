package pl.edu.agh.to2.frazeusz.pattern_matcher.views;

import pl.edu.agh.to2.frazeusz.models.SearchPattern;

import javax.swing.*;

public class PatternPartial extends JPanel {

    private SearchPattern model;

    private JTextField patternTextField;
    private JButton deleteButton;
    private JCheckBox caseSensitiveCheckBox;
    private JCheckBox synonymsCheckBox;
    private JCheckBox variantCheckBox;
    private JCheckBox diminutiveCheckBox;

    public PatternPartial() {
        createUIComponents();
    }


    private void bindModel(SearchPattern model) {
        patternTextField.addPropertyChangeListener(e -> model.setPattern(patternTextField.getText()));
        caseSensitiveCheckBox.addPropertyChangeListener(e -> model.setCaseSensitive(caseSensitiveCheckBox.isSelected()));
        synonymsCheckBox.addPropertyChangeListener(e -> model.setSynonyms(synonymsCheckBox.isSelected()));
        variantCheckBox.addPropertyChangeListener(e -> model.setVariants(variantCheckBox.isSelected()));
        diminutiveCheckBox.addPropertyChangeListener(e -> model.setDiminutives(diminutiveCheckBox.isSelected()));
    }

    private void createUIComponents() {
        patternTextField = new JTextField(20);
        deleteButton = new JButton("Usuń");
        caseSensitiveCheckBox = new JCheckBox("wielkie litery");
        synonymsCheckBox = new JCheckBox("synonimy");
        variantCheckBox = new JCheckBox("odmiany");
        diminutiveCheckBox = new JCheckBox("zdrobnienia");

        this.add(patternTextField);
        this.add(deleteButton);
        this.add(caseSensitiveCheckBox);
        this.add(synonymsCheckBox);
        this.add(variantCheckBox);
        this.add(diminutiveCheckBox);

        bindModel(model);
    }
}
