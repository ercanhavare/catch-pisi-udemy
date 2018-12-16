package net.havare.catchpisi;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LevelOne extends AppCompatActivity {

    private TextView textTimeActionBar, textScoreActionBar;
    private ImageView imageView1, imageView2, imageView3, imageView4;
    private ImageView[] imgArray;
    private Runnable runnable;
    private Handler handler;
    private int score = 0;

    public void setTextTimeActionBar(TextView textTimeActionBar) {
        this.textTimeActionBar = textTimeActionBar;
    }

    public void setTextScoreActionBar(TextView textScoreActionBar) {
        this.textScoreActionBar = textScoreActionBar;
    }

    public ImageView getImageView1() {
        return imageView1;
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }

    public ImageView getImageView3() {
        return imageView3;
    }

    public void setImageView3(ImageView imageView3) {
        this.imageView3 = imageView3;
    }

    public ImageView getImageView4() {
        return imageView4;
    }

    public void setImageView4(ImageView imageView4) {
        this.imageView4 = imageView4;
    }

    public ImageView[] getImgArray() {
        return imgArray;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        // definition of value
        setTextTimeActionBar((TextView) findViewById(R.id.textTimeActionBar));
        setTextScoreActionBar((TextView) findViewById(R.id.textScoreActionBar));

        // definition of images
        setImageView1((ImageView) findViewById(R.id.imageView1));
        setImageView2((ImageView) findViewById(R.id.imageView2));
        setImageView3((ImageView) findViewById(R.id.imageView3));
        setImageView4((ImageView) findViewById(R.id.imageView4));

        // definition imgArray
        imgArray = new ImageView[]{getImageView1(), getImageView2(), getImageView3(), getImageView4()};


        // calculate time
        new CountDownTimer(10000, 1000) {
            @SuppressLint("DefaultLocale")
            @Override
            public void onTick(long l) {
                // one second for hide and show
                textTimeActionBar.setText(String.format("Time : %d", l / 1000));

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                // game finished
                textTimeActionBar.setText("Time : 0");

                // stop the handler
                getHandler().removeCallbacks(getRunnable());

                // hide the images
                for (ImageView imageView : getImgArray()) {
                    imageView.setVisibility(View.INVISIBLE);
                }

                // if score bigger than 3 you can go next level
                if (getScore() >= 3) {
                    goLevelTwo();
                } else {
                    // function
                    askWhatYouWant();
                }

            }
        }.start();

        // call hidehowImage function
        hideShowImages();

    }

    // go next level
    public void goLevelTwo() {
        Intent intent = new Intent(getApplicationContext(), LevelFromOneToTwo.class);
        startActivity(intent);
    }

    // increase game score
    @SuppressLint("SetTextI18n")
    public void increaseGameScoreLevelOne(View view) {
        setScore(1);
        textScoreActionBar.setText("Score : " + getScore());
    }

    // hide - show images
    public void hideShowImages() {
        setHandler(new Handler());
        setRunnable(new Runnable() {
            @Override
            public void run() {
                // before start hide all image
                for (ImageView image : getImgArray()) {
                    image.setVisibility(View.INVISIBLE);
                }

                // show image random
                Random random = new Random();
                int selectImg = random.nextInt(3);
                imgArray[selectImg].setVisibility(View.VISIBLE);

                //time arrival
                getHandler().postDelayed(this, 400);
            }
        });
        getHandler().post(getRunnable());
    }

    // alertDialog - Would you like to contiune or not?
    public void askWhatYouWant() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Sorry,you failed!");
        alertDialog.setMessage("Would you like to continue ? ");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent restartLevel = new Intent(getApplicationContext(), LevelOne.class);
                startActivity(restartLevel);
            }
        });

        alertDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
            }
        });

        alertDialog.show();
    }


    // when user go back
    /*@Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really !")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getHandler().removeCallbacks(getRunnable());
                        LevelOne.super.onBackPressed();
                    }
                }).create().show();
    }*/
}