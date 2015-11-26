package pl.edu.agh.to2.frazeusz.pattern_matcher;

import pl.edu.agh.to2.frazeusz.pattern_matcher.views.PatternView;

import javax.swing.*;

public class Main {

    private static void createGUI() {
        JFrame frame = new JFrame("PatternUI");
        frame.setContentPane(new PatternView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        createGUI();

//        String[] patterns = {
//                "to",
//                "to **",
//                "to **** and",
//                "to **** and ** the",
//                "** to **** and **** the ",
//                "** to **** and **** the *** is *** a"
//        };
//
//        for (String pattern : patterns) {
//            Pattern p = PatternCompiler.compile(pattern);
//            System.out.println(pattern);
//
//            try {
//                FileInputStream input = new FileInputStream("pg4351.txt");
//                byte[] fileData = new byte[input.available()];
//
//                input.read(fileData);
//                input.close();
//
//                String text = new String(fileData, "UTF-8");
//
//                String[] sentences = text.split("[\\.?!]+");
//
//                double start = System.currentTimeMillis();
//
//                int count = 0;
//                for (String sentence : sentences) {
//                    Matcher m = p.matcher(sentence);
//
//                    while (m.find()) {
//                        count++;
//                    }
//                }
//
//                System.out.println("Total sentences: " + sentences.length);
//                System.out.println("Matched sentences: " + count);
//                System.out.println("Took " + (System.currentTimeMillis() - start));
//
//                System.out.println();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
