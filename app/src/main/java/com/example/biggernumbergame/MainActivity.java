package com.example.biggernumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Fields -- Live throughout the lifetime of the the activity
    private Button leftButton, rightButton;
    private TextView txtPoints;
    private int left_number, right_number, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // When the app loads up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize points
        points = 0;

        // Pick the random numbers initially
        pickRandomNumbers();

    }

    private void pickRandomNumbers() {
        // pick random numbers
        Random random = new Random();
        left_number = random.nextInt(10);
        right_number = random.nextInt(10);

        // Links the widgets
        leftButton = findViewById(R.id.btn_left);
        rightButton = findViewById(R.id.btn_right);
        txtPoints = findViewById(R.id.result);

        // Setting text of the widgets
        leftButton.setText(Integer.toString(left_number));
        rightButton.setText(Integer.toString(right_number));
    }
    public void leftButtonClick(View view) {
        if (left_number >= right_number) {
            // correct
            points++;
        } else {
            // incorrect
            points--;
        }
        // Update the display of points
        txtPoints.setText("Points : " + Integer.toString(points));
        // Pick the random numbers again
        pickRandomNumbers();

    }

    public void rightButtonClick(View view) {
        if (right_number >= left_number) {
            // correct
            points++;
        } else {
            // incorrect
            points--;
        }
        // Update the display of points
        txtPoints.setText("Points :" + Integer.toString(points));
        // Pick the random numbers again
        pickRandomNumbers();
    }
}
