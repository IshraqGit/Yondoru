package com.example.demo6;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import java.net.URL;


public class HelloController {
    public Button modebutton;
    @FXML private Button editButton;
    @FXML private TextField timerField1;
    @FXML private Label modeLabel11;
    @FXML private Button workButton;
    @FXML private Button shortBreakButton;
    @FXML private Button longBreakButton;
    @FXML
    protected void handleShortBreak() {
        if (timeline != null) timeline.stop();
        isRunning = false;
        mode = "shortBreak";
        timeLeft = shortBreak;
        timerLabel.setText(formatTime(timeLeft));
        workButton.setStyle("-fx-background-color: Transparent;");
        shortBreakButton.setStyle("-fx-background-color: #179dfc;");
        longBreakButton.setStyle("-fx-background-color: Transparent;");
        modeLabel11.setText("Let's take a quick breather!");
        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
        AnchorPane.setRightAnchor(modeLabel11, 0.0);
        modeLabel11.setAlignment(Pos.CENTER);
        startPauseButton.setText("|>");
    }

    @FXML
    protected void handleLongBreak() {
        if (timeline != null) timeline.stop();
        isRunning = false;
        mode = "longBreak";
        timeLeft = longBreak;
        timerLabel.setText(formatTime(timeLeft));
        workButton.setStyle("-fx-background-color: Transparent;");
        shortBreakButton.setStyle("-fx-background-color: Transparent;");
        longBreakButton.setStyle("-fx-background-color: #179dfc;");
        modeLabel11.setText("Time to relax and recharge but don't forget to be back!");
        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
        AnchorPane.setRightAnchor(modeLabel11, 0.0);
        modeLabel11.setAlignment(Pos.CENTER);
        startPauseButton.setText("|>");
    }
    @FXML private Label timerLabel;
    // ProgressBar removed
    @FXML private Button startPauseButton;
    @FXML private AnchorPane root;

private int workDuration = 25 * 60;
private int shortBreak = 1 * 10; // 10 seconds
private int longBreak = 15 * 60; // 15 minutes
    private int timeLeft = workDuration;
    private int cycleCount = 0;
    private boolean isRunning = false;
    private boolean isDarkMode = true;
    @FXML
    private String mode = "work";
    private Timeline timeline;
    private int inputStep = -1;  // -1 = not editing, 0 = work, 1 = short break, 2 = long break
    private final int[] durations = new int[3];  // in minutes
    private final String[] prompts = {
            "Enter work duration (minutes):",
            "Enter short break duration (minutes):",
            "Enter long break duration (minutes):"
    };
    private final AudioClip alertSound = new AudioClip(
            getClass().getResource("/com/example/demo6/notification.wav").toExternalForm()
    );


    @FXML
    public void initialize() {
        timerLabel.setText(formatTime(timeLeft));
        // ProgressBar removed
        workButton.setStyle("");
        shortBreakButton.setStyle("");
        longBreakButton.setStyle("");
    }

    @FXML
    protected void handleWork() {
        if (timeline != null) timeline.stop();
        isRunning = false;
        mode = "work";
        timeLeft = workDuration;
        timerLabel.setText(formatTime(timeLeft));
        workButton.setStyle("-fx-background-color: #179dfc;");
        shortBreakButton.setStyle("-fx-background-color: Transparent;");
        longBreakButton.setStyle("-fx-background-color: Transparent;");
        modeLabel11.setText("Let's get working!!");
        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
        AnchorPane.setRightAnchor(modeLabel11, 0.0);
        modeLabel11.setAlignment(Pos.CENTER);
        startPauseButton.setText("|>");
    }

    // ProgressBar animation method removed



    @FXML
    public void toggleTheme() {
        if(isDarkMode){
            modebutton.setText("Light Mode");
        }
        else {
            modebutton.setText("Dark Mode");
        }
        String cssFile = isDarkMode ? "/com/example/demo6/dark.css" : "/com/example/demo6/light.css";
        URL cssURL = getClass().getResource(cssFile);

        if (cssURL == null) {
            System.err.println(" CSS file not found: " + cssFile);
            return;
        }

        Scene scene = root.getScene();
        if (scene != null) {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(cssURL.toExternalForm());
            isDarkMode = !isDarkMode;
        }
    }
    @FXML
    protected void handleStartPause() {
        if (isRunning) {
            timeline.pause();
            startPauseButton.setText("|>");
        } else {
            startTimer();
            startPauseButton.setText("||");
        }
        isRunning = !isRunning;
    }

    @FXML
    protected void handleReset() {
        if (timeline != null) timeline.stop();
        isRunning = false;
        mode = "work";
        timeLeft = workDuration;
        cycleCount = 0;
        timerLabel.setText(formatTime(timeLeft));
        workButton.setStyle("-fx-background-color: #179dfc;");
        shortBreakButton.setStyle("-fx-background-color: Transparent;");
        longBreakButton.setStyle("-fx-background-color: Transparent;");
        modeLabel11.setText("Let's get working!!");
        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
        AnchorPane.setRightAnchor(modeLabel11, 0.0);
        modeLabel11.setAlignment(Pos.CENTER);
        // ProgressBar removed
        startPauseButton.setText("|>");
    }
    @FXML
    protected void handleEditDurations() {
        if (timeline != null) timeline.pause();
        isRunning = false;

        timerLabel.setVisible(false);  // Hide the timer label

        inputStep = 0;
        durations[0] = workDuration / 60;
        durations[1] = shortBreak / 60;
        durations[2] = longBreak / 60;

        timerField1.setEditable(true);
        timerField1.setFocusTraversable(true);
        timerField1.clear();
        timerField1.setPromptText(prompts[0]);
        timerField1.requestFocus();
    }

    private void applyDurations() {
        workDuration = durations[0] * 60;
        shortBreak = durations[1] * 60;
        longBreak = durations[2] * 60;
        timeLeft = workDuration;
        mode = "work";
        cycleCount = 0;

        timerLabel.setText(formatTime(timeLeft));
        workButton.setStyle("-fx-background-color: #179dfc;");
        shortBreakButton.setStyle("-fx-background-color: Transparent;");
        longBreakButton.setStyle("-fx-background-color: Transparent;");
        modeLabel11.setText("Let's get working!!");
        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
        AnchorPane.setRightAnchor(modeLabel11, 0.0);
        modeLabel11.setAlignment(Pos.CENTER);
        // ProgressBar removed
        startPauseButton.setText("|>");
    }

    @FXML
    protected void handleNextInput() {
        if (inputStep < 0 || inputStep > 2) return;

        String input = timerField1.getText().trim();
        if (input.isEmpty()) {
            durations[inputStep] = 15; // Default to 15 minutes if no input
        } else {
            try {
                durations[inputStep] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                durations[inputStep] = 15; // Default to 15 minutes if invalid input
            }
        }
        inputStep++;
        if (inputStep < 3) {
            timerField1.clear();
            timerField1.setPromptText(prompts[inputStep]);
        } else {
            applyDurations();
            inputStep = -1;
            timerField1.setText(" ");
            timerField1.setEditable(false); // disables typing
            timerField1.setFocusTraversable(false);
            timerLabel.setVisible(true);
        }
    }

    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            timerLabel.setText(formatTime(timeLeft));
            double progress;
            if (mode.equals("work")) {
                progress = 1 - (double) timeLeft / workDuration;
            } else if (mode.equals("shortBreak")) {
                progress = 1 - (double) timeLeft / shortBreak;
            } else {
                progress = 1 - (double) timeLeft / longBreak;
            }
            // ProgressBar removed

            if (timeLeft <= 0) {
                alertSound.play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText(mode.equals("work") ? "Work session ended!" : "Break session ended!");
                alert.show();

                if (mode.equals("work")) {
                    cycleCount++;
                    if (cycleCount % 2 == 0) {
                        mode = "longBreak";
                        timeLeft = longBreak;
                        workButton.setStyle("-fx-background-color: Transparent;");
                        shortBreakButton.setStyle("-fx-background-color: Transparent;");
                        longBreakButton.setStyle("-fx-background-color: #179dfc;");
                        modeLabel11.setText("Time to relax and recharge but don't forget to be back!");
                        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
                        AnchorPane.setRightAnchor(modeLabel11, 0.0);
                        modeLabel11.setAlignment(Pos.CENTER);

                    } else {
                        mode = "shortBreak";
                        timeLeft = shortBreak;
                        workButton.setStyle("-fx-background-color: Transparent;");
                        shortBreakButton.setStyle("-fx-background-color: #179dfc;");
                        longBreakButton.setStyle("-fx-background-color: Transparent;");
                        modeLabel11.setText("Let's take a quick breather!");
                        AnchorPane.setLeftAnchor(modeLabel11, 0.0);
                        AnchorPane.setRightAnchor(modeLabel11, 0.0);
                        modeLabel11.setAlignment(Pos.CENTER);

                    }
                } else {
                    mode = "work";
                    timeLeft = workDuration;
                    workButton.setStyle("-fx-background-color: #179dfc;");
                    shortBreakButton.setStyle("-fx-background-color: Transparent;");
                    longBreakButton.setStyle("-fx-background-color: Transparent;");
                    modeLabel11.setText("Let's get working!!");
                    AnchorPane.setLeftAnchor(modeLabel11, 0.0);
                    AnchorPane.setRightAnchor(modeLabel11, 0.0);
                    modeLabel11.setAlignment(Pos.CENTER);
                }
                // ProgressBar removed
                timerLabel.setText(formatTime(timeLeft));
              /*  timeline.pause();
                isRunning = false;
                startPauseButton.setText("Start");*/
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
