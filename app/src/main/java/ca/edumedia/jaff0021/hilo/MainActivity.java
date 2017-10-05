/**
 *  This is a guessing game that allows the user to guss an number between 1 and 1000
 *  Zaheed Jaffer jaff0021@algonquinlive.com
 */


package ca.edumedia.jaff0021.hilo;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Game game;
    EditText userGuessText;
    String userGuess;
    private static final String ABOUT_DIALOG_TAG = "About Dialog";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reset();

        Button guessBtn = (Button) findViewById(R.id.guessButton);
        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //HERE BE CODE FOR WHEN THE BUTTON IS CLICKED

                userGuessText = findViewById(R.id.userGuessText);
                userGuess = userGuessText.getText().toString();

                createToast(game.setUser(userGuess));
                userGuessText.setText("0");
                userGuessText.requestFocus();
            }
        });

        Button resetBtn = (Button) findViewById(R.id.resetButton);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();
                createToast("Game has been reset");
            }
        });

        resetBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Reset();
                createToast("The number is: " + game.getTheNumber() + " also the game has been reset");
                return true;
            }
        });

    }

    private boolean Reset(){
        game = new Game();
        return false;
    }

    private void createToast(String message){
        Context c = getApplicationContext();
        CharSequence s = message;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(c, s, duration).show();

    }
}
