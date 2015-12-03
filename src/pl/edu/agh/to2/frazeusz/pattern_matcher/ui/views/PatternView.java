package pl.edu.agh.to2.frazeusz.pattern_matcher.ui.views;

import pl.edu.agh.to2.frazeusz.pattern_matcher.ui.models.SearchPattern;
import pl.edu.agh.to2.frazeusz.pattern_matcher.ui.controllers.PatternController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatternView extends JPanel implements ActionListener {

    private List<SearchPattern> model;
    private PatternController controller;

    private JPanel patternPanel;
    private JPanel buttonPanel;
    private JButton addButton;

    public PatternView(List<SearchPattern> patterns, PatternController controller) {
        model = patterns;
        this.controller = controller;
        createUIComponents();
    }

    private void addPatternInput() {
        PatternPartial partial = new PatternPartial(controller.addPattern());
        partial.addDeleteListener(this);
        patternPanel.add(partial);
        patternPanel.revalidate();
        validate();
        JFrame frame = (JFrame) SwingUtilities.windowForComponent(this);
        if (frame != null)
            frame.pack();

    }

    private void removePatternInput(PatternPartial pattern) {
        patternPanel.remove(pattern);
        patternPanel.revalidate();
        validate();
        JFrame frame = (JFrame) SwingUtilities.windowForComponent(this);
        if (frame != null)
            frame.pack();
    }

    private void createUIComponents() {
        patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));

        if (model.isEmpty())
            addPatternInput();
        else
            for (SearchPattern pattern : model)
                patternPanel.add(new PatternPartial(pattern));

        addButton = new JButton("Dodaj");
        addButton.addActionListener(e -> addPatternInput());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(addButton);

        this.setLayout(new BorderLayout());
        this.add(patternPanel, BorderLayout.PAGE_START);
        this.add(buttonPanel, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().equals(PatternPartial.class)) {
            PatternPartial partial = (PatternPartial) e.getSource();
            controller.removePattern(partial.getModel());
            removePatternInput(partial);
        }
    }
}
