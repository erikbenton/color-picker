package com.example.android.colorpicker;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] winningColor = new int[3];
    String winningColorString;
    int red;
    int green;
    int blue;
    int max = 255;
    int min = 0;

    TextView title;

    LinearLayout background;

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

    Button resetButton;

    String button6Color;
    Button button6;

    String[] buttonColors = new String[6];
    Button[] buttons = new Button[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();
        initGameScreen();

    }
    public void initViews()
    {
        title = findViewById(R.id.title);

        background = findViewById(R.id.background);

        button1      = findViewById(R.id.button_1);
        button2      = findViewById(R.id.button_2);
        button3      = findViewById(R.id.button_3);
        button4      = findViewById(R.id.button_4);
        button5      = findViewById(R.id.button_5);
        button6      = findViewById(R.id.button_6);
        resetButton  = findViewById(R.id.reset_button);

        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
    }

    public void initGameScreen()
    {
        background.setBackgroundColor(Color.rgb(0, 0, 0));
        resetButton.setText("Reset");
        setWinningColor();
        setTitle();
        setButtonColors();
    }

    public void setWinningColor()
    {
        red = getRandomInt();
        green = getRandomInt();
        blue = getRandomInt();

        winningColor[0] = red;
        winningColor[1] = green;
        winningColor[2] = blue;
        winningColorString = "" + winningColor[0] + winningColor[1] + winningColor[2];
    }

    public void setTitle()
    {
        String titleText = "RGB(";
        titleText += red + ", " + green + ", " + blue + ")";
        title.setText(titleText);
    }

    public void setButtonColors()
    {
        int redTemp;
        int greenTemp;
        int blueTemp;

        for(int i = 0; i < buttons.length; i++)
        {
            redTemp = getRandomInt();
            greenTemp = getRandomInt();
            blueTemp = getRandomInt();
            buttons[i].setVisibility(View.VISIBLE);
            buttons[i].setBackgroundColor(Color.rgb(getRandomInt(), getRandomInt(), getRandomInt()));
            buttonColors[i] = "" + redTemp + greenTemp + blueTemp;
        }

        assignWinningSquare();

    }

    public void assignWinningSquare()
    {
        int randomSquare = (int)(Math.random() * 6);
        buttons[randomSquare].setBackgroundColor(Color.rgb(winningColor[0], winningColor[1], winningColor[2]));
        buttonColors[randomSquare] = "" + winningColor[0] + winningColor[1] + winningColor[2];
    }

    public String convertRGBToHex(int red, int green, int blue)
    {
        return "#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
    }

    public int getRandomInt()
    {
        return (int)(Math.random() * max + min);
    }

    public void winGame()
    {
        title.setText("That was it!");
        background.setBackgroundColor(Color.rgb(winningColor[0], winningColor[1], winningColor[2]));
        resetButton.setText("Play Again?");
    }

    public void resetGame(View view)
    {
        initGameScreen();
    }

    public void button1Press(View view)
    {
        if(buttonColors[0].equals(winningColorString))
        {
            winGame();
        }
        else
        {
            button1.setVisibility(View.INVISIBLE);
        }
    }

    public void button2Press(View view)
    {
        if(buttonColors[1].equals(winningColorString))
        {
            winGame();
        }
        else
        {
            button2.setVisibility(View.INVISIBLE);
        }
    }

    public void button3Press(View view)
    {
        if(buttonColors[2].equals(winningColorString))
        {
            winGame();
        }
        else
        {
            button3.setVisibility(View.INVISIBLE);
        }
    }

    public void button4Press(View view)
    {
        if(buttonColors[3].equals(winningColorString))
        {
            winGame();
        }
        else
        {
            button4.setVisibility(View.INVISIBLE);
        }
    }

    public void button5Press(View view)
    {
        if(buttonColors[4].equals(winningColorString))
        {
            winGame();
        }
        else
        {
            button5.setVisibility(View.INVISIBLE);
        }
    }

    public void button6Press(View view)
    {
        if(buttonColors[5].equals(winningColorString))
        {
            winGame();
        }
        else
        {
            button6.setVisibility(View.INVISIBLE);
        }
    }
}
