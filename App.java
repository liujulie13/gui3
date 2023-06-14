package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel mainMenu;
    private JPanel instructionsPanel;
    private JPanel gamePanel;

    public App() {
        // Set up the main frame
        setTitle("Game Introduction");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main menu panel
        mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(3, 1));

        JButton instructionsButton = new JButton("Instructions");
        JButton playButton = new JButton("Play");
        JButton quitButton = new JButton("Quit");

        // Add event listeners for main menu buttons
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showInstructions();
            }
        });

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showGame();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        mainMenu.add(instructionsButton);
        mainMenu.add(playButton);
        mainMenu.add(quitButton);

        // Set the main menu as the initial panel
        setContentPane(mainMenu);

        // Show the frame
        setVisible(true);
    }

    private void showInstructions() {
        // Create the instructions panel
        instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BorderLayout());

        JTextArea instructionsText = new JTextArea();
        instructionsText.setText("These are the game instructions.\n\nPress the Back button to return to the main menu.");

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(mainMenu);
                revalidate();
            }
        });

        instructionsPanel.add(instructionsText, BorderLayout.CENTER);
        instructionsPanel.add(backButton, BorderLayout.SOUTH);

        // Set the instructions panel as the current panel
        setContentPane(instructionsPanel);
        revalidate();
    }

    private void showGame() {
        // Create the game panel
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        JLabel gameLabel = new JLabel("This is the game screen.");
        ImageIcon gameImage = new ImageIcon("game_image.jpg");
        JLabel gameImageLabel = new JLabel(gameImage);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(mainMenu);
                revalidate();
            }
        });

        gamePanel.add(gameLabel, BorderLayout.NORTH);
        gamePanel.add(gameImageLabel, BorderLayout.CENTER);
        gamePanel.add(backButton, BorderLayout.SOUTH);

        // Set the game panel as the current panel
        setContentPane(gamePanel);
        revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
