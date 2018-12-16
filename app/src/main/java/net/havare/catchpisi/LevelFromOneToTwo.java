package net.havare.catchpisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelFromOneToTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_from_one_to_two);
    }

    public void levelOneToTwo(View view){
        Intent intent = new Intent(getApplicationContext(),LevelTwo.class);
        startActivity(intent);
    }
}
