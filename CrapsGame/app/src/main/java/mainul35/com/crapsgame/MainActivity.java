package mainul35.com.crapsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int basePoint = 0, countClick = 0;
    private Button btnDice1, btnDice2, btnRoll;
    private TextView tvLastRollingPoint, tvBasePoint, tvContinueRolling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDice1 = findViewById(R.id.bnDice1Point);
        btnDice2 = findViewById(R.id.btnDice2Point);
        btnRoll = findViewById(R.id.btnRoll);

        tvLastRollingPoint = findViewById(R.id.tvLastRollingPoint);
        tvBasePoint = findViewById(R.id.tvBasePoint);
        tvContinueRolling = findViewById(R.id.tvContinueRolling);

        tvContinueRolling.setText("");

    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return (random.nextInt(5)+1);
    }

    public void rollDice(View view) {

        int dice1Score = generateRandomNumber();
        int dice2Score = generateRandomNumber();
        btnDice1.setText(Integer.toString(dice1Score));
        btnDice2.setText(Integer.toString(dice2Score));

        if (dice1Score + dice2Score == 7 || dice1Score + dice2Score == 11) {
            if(countClick > 0 && dice1Score + dice2Score == 7){
                btnRoll.setText("You lost!");
                tvContinueRolling.setText("");
                tvLastRollingPoint.setText(Integer.toString(dice1Score + dice2Score));
                Toast.makeText(MainActivity.this, "The rolled number is "+(dice1Score + dice2Score), Toast.LENGTH_SHORT);
                btnRoll.setEnabled(false);
            } else {
                tvLastRollingPoint.setText(Integer.toString(dice1Score + dice2Score));
                tvBasePoint.setText(Integer.toString(dice1Score + dice2Score));
                Toast.makeText(MainActivity.this, "The rolled number is " + (dice1Score + dice2Score), Toast.LENGTH_SHORT);
                btnRoll.setText("You won!");
                btnRoll.setEnabled(false);
            }
        } else if((dice1Score +
                dice2Score == 2 || dice1Score + dice2Score == 3 || dice1Score + dice2Score == 12) && countClick==0){
            Toast.makeText(MainActivity.this, "The rolled number is "+(dice1Score + dice2Score), Toast.LENGTH_SHORT);
            tvLastRollingPoint.setText(Integer.toString(dice1Score + dice2Score));
            tvBasePoint.setText(Integer.toString(dice1Score + dice2Score));
            btnRoll.setText("You have lost!");
            btnRoll.setEnabled(false);
        }else {
            if (countClick==0){
                basePoint = dice1Score + dice2Score;
                tvLastRollingPoint.setText(Integer.toString(dice1Score + dice2Score));
                tvBasePoint.setText(Integer.toString(dice1Score + dice2Score));
                tvContinueRolling.setText("Continue Rolling...");
            }else {
                tvLastRollingPoint.setText(Integer.toString(dice1Score + dice2Score));
                tvContinueRolling.setText("Continue Rolling...");
                if(dice1Score + dice2Score==basePoint){
                    tvContinueRolling.setText("");
                    Toast.makeText(MainActivity.this, "The rolled number is "+(dice1Score + dice2Score), Toast.LENGTH_SHORT);
                    btnRoll.setText("You won!");
                    btnRoll.setEnabled(false);
                }
            }

        }
        countClick++;
    }

    public void restart(View view) {
        Log.e("Restart", "restart: " );
        basePoint = 0; countClick = 0;
        btnDice1.setText(Integer.toString(0)); btnDice2.setText(Integer.toString(0)); btnRoll.setEnabled(true);
        btnRoll.setText("Roll");
        tvBasePoint.setText("0");
        tvContinueRolling.setText("");
        tvLastRollingPoint.setText("");
    }
}
