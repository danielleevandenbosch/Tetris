package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game extends JFrame implements ActionListener {
    private JFrame helpWindow;

    /** bar to show score/game message */
    private JLabel scorebar;

    /** tetris logo */
    private final ImageIcon logo = new ImageIcon("tetris.png");

    /** buttons for game navigation */
    private JButton start, help, back, settings, highscores;

    /**
     * Default constructor to create game
     */
    private Game() {
        frame();
    }

    /**
     * Label at bottom of screen for score
     * @return score bar
     */
    public JLabel getStatusBar() {
        return scorebar;
    }

    /**
     * Starts the game
     */
    private void startGame() {

        JFrame f = new JFrame();

        // create game window
        f.setVisible(true);
        f.setSize(500, 550);
        f.setTitle("Tetris");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // create score bar
        scorebar = new JLabel("Score: 0");

        f.add(scorebar, BorderLayout.NORTH);
        scorebar.setHorizontalAlignment(JLabel.CENTER);
        scorebar.setFont(new Font("Arial Black", Font.PLAIN, 20));

        Board board = new Board(this);
        f.add(board);
        board.start();
    }

    /**
     * Loads help menu window
     */
    private void helpMenu() {
        helpWindow = new JFrame();

        // create help window
        helpWindow.setVisible(true);
        helpWindow.setSize(500, 550);
        helpWindow.setTitle("Tetris Help");

        JLabel helpText = new JLabel("Tetris Gameplay");
        helpWindow.add(helpText, BorderLayout.NORTH);
        helpText.setHorizontalAlignment(JLabel.CENTER);
        helpText.setFont(new Font("Arial Black", Font.PLAIN, 20));

        /* text for controls */
        JTextArea helpTextArea = new JTextArea(
                "                            Right:              Up Arrow\n" +
                        "                            Rotate Left:    Down Arrow\n" +
                        "                            Move Right:   Right Arrow\n" +
                        "                            Move Left:      Left Arrow\n" +
                        "                            Fast Drop:      Shift\n" +
                        "                            Instant Drop:  Space\n" +
                        "                            Pause:            p"
        );
        Insets i = new Insets(50,50,50,50);
        helpTextArea.setMargin(i);

        helpTextArea.setEditable(false);

        helpTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        helpTextArea.setLineWrap(true);
        helpTextArea.setWrapStyleWord(true);
        helpWindow.add(helpTextArea, BorderLayout.CENTER);

        back = new JButton("Back");
        helpWindow.add(back, BorderLayout.SOUTH);
        back.addActionListener(this);
    }

    /**
     * Loads settings menu
     */
    private void settingsMenu() {
        JFrame settingsWindow;
        JLabel settingsText;

        settingsWindow = new JFrame();

        // create help window
        settingsWindow.setVisible(true);
        settingsWindow.setSize(500, 550);
        settingsWindow.setTitle("Tetris Settings");

    }

    /**
     * Loads high scores menu
     */
    private void highScoresMenu() {
        JFrame highScoresWindow;
        JLabel highScoresText;

        highScoresWindow = new JFrame();

        // create help window
        highScoresWindow.setVisible(true);
        highScoresWindow.setSize(500, 550);
        highScoresWindow.setTitle("Tetris High Scores");

    }

    /**
     * Frame for menu screen
     */
    private void frame() {

        JFrame f = new JFrame();

        // create game window
        f.setVisible(true);
        f.setSize(500, 550);
        f.setTitle("Tetris");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        /* game title */
        JLabel title = new JLabel(logo);
        start = new JButton("Start");
        start.setPreferredSize(new Dimension(100, 40));

        help = new JButton("Help");
        help.setPreferredSize(new Dimension(100, 40));

        settings = new JButton("Settings");
        settings.setPreferredSize(new Dimension(100, 40));

        highscores = new JButton("High Scores");
        highscores.setPreferredSize(new Dimension(100, 40));

        f.add(title, BorderLayout.NORTH);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial Black", Font.PLAIN, 80));
        p.add(start);
        p.add(help);
        p.add(settings);
        p.add(highscores);
        f.add(p);

        start.addActionListener(this);
        help.addActionListener(this);
        settings.addActionListener(this);
        highscores.addActionListener(this);
    }

    /**
     * Checks if button is clicked
     * @param e action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start) {
            startGame();
        }
        if (e.getSource() == help) {
            helpMenu();
        }
        if (e.getSource() == settings) {
            settingsMenu();
        }
        if (e.getSource() == highscores) {
            highScoresMenu();
        }
        if (e.getSource() == back) {
            helpWindow.dispose();
        }
    }

    /**
     * Main method to run game
     * @param args args
     */
    public static void main(String[] args) {
        new Game();
    }
}
