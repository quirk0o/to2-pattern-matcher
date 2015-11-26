package pl.edu.agh.to2.frazeusz.pattern_matcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PatternUI extends JPanel {

    private JPanel patternPanel;
    private JPanel buttonPanel;
    private JButton addButton;

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("PatternUI");
//        frame.setContentPane(new PatternUI());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

    public PatternUI() {
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
