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

public class LevelThree extends AppCompatActivity {

    private TextView textTimeActionBar, textScoreActionBar;
    private ImageView imageView1, imageView2, imageView3, imageView4;
    private ImageView imageView5, imageView6, imageView7, imageView8;
    private ImageView imageView9, imageView10, imageView11, imageView12;
    private ImageView imageView13, imageView14, imageView15, imageView16;
    private ImageView[] imgArray;
    private Runnable runnable;
    private Handler handler;
    private int score = 0;

    public TextView getTextTimeActionBar() {
        return textTimeActionBar;
    }

    public void setTextTimeActionBar(TextView textTimeActionBar) {
        this.textTimeActionBar = textTimeActionBar;
    }

    public TextView getTextScoreActionBar() {
        return textScoreActionBar;
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

    public ImageView getImageView5() {
        return imageView5;
    }

    public void setImageView5(ImageView imageView5) {
        this.imageView5 = imageView5;
    }

    public ImageView getImageView6() {
        return imageView6;
    }

    public void setImageView6(ImageView imageView6) {
        this.imageView6 = imageView6;
    }

    public ImageView getImageView7() {
        return imageView7;
    }

    public void setImageView7(ImageView imageView7) {
        this.imageView7 = imageView7;
    }

    public ImageView getImageView8() {
        return imageView8;
    }

    public void setImageView8(ImageView imageView8) {
        this.imageView8 = imageView8;
    }

    public ImageView getImageView9() {
        return imageView9;
    }

    public void setImageView9(ImageView imageView9) {
        this.imageView9 = imageView9;
    }

    public ImageView getImageView10() {
        return imageView10;
    }

    public void setImageView10(ImageView imageView10) {
        this.imageView10 = imageView10;
    }

    public ImageView getImageView11() {
        return imageView11;
    }

    public void setImageView11(ImageView imageView11) {
        this.imageView11 = imageView11;
    }

    public ImageView getImageView12() {
        return imageView12;
    }

    public void setImageView12(ImageView imageView12) {
        this.imageView12 = imageView12;
    }

    public ImageView getImageView13() {
        return imageView13;
    }

    public void setImageView13(ImageView imageView13) {
        this.imageView13 = imageView13;
    }

    public ImageView getImageView14() {
        return imageView14;
    }

    public void setImageView14(ImageView imageView14) {
        this.imageView14 = imageView14;
    }

    public ImageView getImageView15() {
        return imageView15;
    }

    public void setImageView15(ImageView imageView15) {
        this.imageView15 = imageView15;
    }

    public ImageView getImageView16() {
        return imageView16;
    }

    public void setImageView16(ImageView imageView16) {
        this.imageView16 = imageView16;
    }

    public ImageView[] getImgArray() {
        return imgArray;
    }

    public void setImgArray(ImageView[] imgArray) {
        this.imgArray = imgArray;
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
        setContentView(R.layout.activity_level_three);

        // definition of value
        setTextTimeActionBar((TextView) findViewById(R.id.textTimeActionBar));
        setTextScoreActionBar((TextView) findViewById(R.id.textScoreActionBar));

        // definition of images
        setImageView1((ImageView) findViewById(R.id.imageView1));
        setImageView2((ImageView) findViewById(R.id.imageView2));
        setImageView3((ImageView) findViewById(R.id.imageView3));
        setImageView4((ImageView) findViewById(R.id.imageView4));
        setImageView5((ImageView) findViewById(R.id.imageView5));
        setImageView6((ImageView) findViewById(R.id.imageView6));
        setImageView7((ImageView) findViewById(R.id.imageView7));
        setImageView8((ImageView) findViewById(R.id.imageView8));
        setImageView9((ImageView) findViewById(R.id.imageView9));
        setImageView10((ImageView) findViewById(R.id.imageView10));
        setImageView11((ImageView) findViewById(R.id.imageView11));
        setImageView12((ImageView) findViewById(R.id.imageView12));
        setImageView13((ImageView) findViewById(R.id.imageView13));
        setImageView14((ImageView) findViewById(R.id.imageView14));
        setImageView15((ImageView) findViewById(R.id.imageView15));
        setImageView16((ImageView) findViewById(R.id.imageView16));

        // definition imgArray
        imgArray = new ImageView[]{getImageView1(), getImageView2(), getImageView3(), getImageView4(),
                getImageView5(), getImageView6(), getImageView7(), getImageView8(),
                getImageView9(), getImageView10(), getImageView11(), getImageView12(),
                getImageView13(), getImageView14(), getImageView15(), getImageView16()};

        new CountDownTimer(10000,1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                textTimeActionBar.setText(String.format("Time : %d", l / 1000));
            }

            @Override
            public void onFinish() {
                // game finished
                textTimeActionBar.setText("Time :0");

                // stop the handler
                getHandler().removeCallbacks(getRunnable());

                // hide the images
                for (ImageView img:getImgArray()){
                    img.setVisibility(View.INVISIBLE);
                }

                // if score bigger than 3 you can go next level
                if (getScore()>=3){
                    goLevelFour();
                }else{
                    // function
                    askWhatYouWant();
                }

            }
        }.start();

        hideShowImages();
    }

    public void goLevelFour() {
        Intent intent = new Intent(getApplicationContext(), LevelFromThreeToFour.class);
        startActivity(intent);
    }

    public void increaseGameScoreLevelThree(View view) {
        setScore(1);
        textScoreActionBar.setText("Score : "+getScore());
    }

    // hide - show images
    public void hideShowImages(){
        setHandler(new Handler());
        setRunnable(new Runnable() {
            @Override
            public void run() {
                // before start game hide all images
                for (ImageView image:getImgArray()){
                    image.setVisibility(View.INVISIBLE);
                }

                // show image random
                Random random = new Random();
                int selecImg = random.nextInt(15);
                imgArray[selecImg].setVisibility(View.VISIBLE);

                // time arrival
                getHandler().postDelayed(this,400);
            }
        });
        getHandler().post(getRunnable());

    }


    public void askWhatYouWant(){
        AlertDialog.Builder  alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Sorry,you failed!");
        alertDialog.setMessage("Would you like to continue ? ");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent restartLevel = new Intent(getApplicationContext(), LevelThree.class);
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

}
