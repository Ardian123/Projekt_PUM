package com.example.kuznargroup.welowanie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends Activity {

    Button buttonNewGame;
    Button buttonResult;
    Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonNewGame = (Button) findViewById(R.id.buttonNewGame);
        buttonNewGame.setBackgroundResource(R.drawable.button_menu);
        buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setBackgroundResource(R.drawable.button_menu);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        buttonExit.setBackgroundResource(R.drawable.button_menu);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("user_login");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("user_login");
        }

        TextView callActTV = (TextView) findViewById(R.id.powitanie_tv);

        callActTV.append(" " + newString);

    }

    public void onNewGame(View view) {
        buttonNewGame.setBackgroundResource(R.drawable.button_menu_click);
        Intent intentNext = new Intent(this, SelectStageActivity.class);
        startActivity(intentNext);
    }

    @Override
    protected void onStart() {
        super.onStart();
        buttonNewGame.setBackgroundResource(R.drawable.button_menu);
        buttonResult.setBackgroundResource(R.drawable.button_menu);
        buttonExit.setBackgroundResource(R.drawable.button_menu);
    }

    public void onResult(View view) {
        buttonResult.setBackgroundResource(R.drawable.button_menu_click);
        Intent intentNext = new Intent(this, ResultActivity.class);
        startActivity(intentNext);
    }

    public void onExit(View view) {
        buttonExit.setBackgroundResource(R.drawable.button_menu_click);
        finish();
    }
}

