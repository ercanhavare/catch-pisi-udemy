package net.havare.catchpisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelFromThreeToFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_from_three_to_four);
    }

    public void levelThreeToFour(View view){
        Intent intent = new Intent(getApplicationContext(),LevelFour.class);
        startActivity(intent);
    }
}
