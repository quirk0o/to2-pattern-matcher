package pl.edu.agh.to2.frazeusz.pattern_matcher.views;

import javax.swing.*;
import java.awt.*;

public class PatternView extends JPanel {

    private JPanel patternPanel;
    private JPanel buttonPanel;
    private JButton addButton;

    public PatternView() {
        createUIComponents();
    }

    public void addPattern() {
        patternPanel.add(new PatternPartial());
        patternPanel.revalidate();
        validate();

    }

    public void removePattern(PatternPartial pattern) {
        patternPanel.remove(pattern);
        patternPanel.revalidate();
        validate();
    }

    private void createUIComponents() {
        patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(new PatternPartial());

        addButton = new JButton("Dodaj");
        addButton.addActionListener(e -> addPattern());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(addButton);

        this.setLayout(new BorderLayout());
        this.add(patternPanel, BorderLayout.PAGE_START);
        this.add(buttonPanel, BorderLayout.PAGE_END);
    }
}
