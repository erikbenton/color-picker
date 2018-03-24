package com.example.android.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] winningColor = new int[3];
    int red;
    int green;
    int blue;
    int max = 255;
    int min = 0;

    TextView title;

    String button1Color;
    Button button1;

    String button2Color;
    Button button2;

    String button3Color;
    Button button3;

    String button4Color;
    Button button4;

    String button5Color;
    Button button5;

    String button6Color;
    Button button6;

    Button[] buttons = new Button[6]; //{button1, button2, button3, button4, button5, button6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();
        setTitle();
        setButtonColors();

    }
    public void initViews()
    {
        title = findViewById(R.id.title);

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);

        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
    }

    public void setTitle()
    {
        String titleText = "RGB(";

        red = getRandomInt();
        green = getRandomInt();
        blue = getRandomInt();

        winningColor[0] = red;
        winningColor[1] = green;
        winningColor[2] = blue;

        titleText += red + ", " + green + ", " + blue + ")";

        title.setText(titleText);
    }

    public void setButtonColors()
    {
        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i].setBackgroundColor(Color.rgb(getRandomInt(), getRandomInt(), getRandomInt()));
        }

        buttons[(int)(Math.random() * 6)].setBackgroundColor(Color.rgb(winningColor[0], winningColor[1], winningColor[2]));
    }

    public String convertRGBToHex(int red, int green, int blue)
    {
        return "#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
    }

    public int getRandomInt()
    {
        return (int)(Math.random() * max + min);
    }

    public void resetGame(View view)
    {
        initViews();
        setTitle();
        setButtonColors();
    }
}
