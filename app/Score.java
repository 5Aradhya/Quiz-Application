package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Score extends JFrame {

    JButton exit;

    public Score(String name, int score) {

        setSize(750, 550);
        setLocation(400, 150);
        setLayout(null);

        // 🔹 Load Background Image FIRST
        JLabel background = new JLabel();
        background.setBounds(0, 0, 750, 550);

        URL backUrl = getClass().getResource("/icons/back.png");
        if (backUrl != null) {
            ImageIcon bgIcon = new ImageIcon(backUrl);
            Image bgImg = bgIcon.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
            background.setIcon(new ImageIcon(bgImg));
        } else {
            System.out.println("Back image not found");
        }

        setContentPane(background);

        // 🔹 Score Image
        URL scoreUrl = getClass().getResource("/icons/score.png");
        if (scoreUrl != null) {
            ImageIcon i1 = new ImageIcon(scoreUrl);
            Image i = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
            JLabel image = new JLabel(new ImageIcon(i));
            image.setBounds(60, 200, 200, 150);
            add(image);
        } else {
            System.out.println("Score image not found");
        }

        // 🔹 Heading
        JLabel heading = new JLabel("Thank You " + name + " for Playing QUIZ Test");
        heading.setBounds(100, 80, 600, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        // 🔹 Score Label
        JLabel scoreLabel = new JLabel("Your score is " + score);
        scoreLabel.setBounds(350, 200, 300, 30);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        scoreLabel.setForeground(new Color(22, 99, 54));
        add(scoreLabel);

        // 🔹 Button
        exit = new JButton("Next");
        exit.setBounds(100, 400, 120, 30);
        exit.setBackground(new Color(22, 99, 54));
        exit.setForeground(Color.WHITE);
        add(exit);

        exit.addActionListener(e -> {
            setVisible(false);
            new Login();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}