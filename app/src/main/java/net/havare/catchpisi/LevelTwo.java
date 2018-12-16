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

public class LevelTwo extends AppCompatActivity {

    private TextView textTimeActionBar, textScoreActionBar;
    private ImageView imageView1,imageView2,imageView3;
    private ImageView imageView4,imageView5,imageView6;
    private ImageView imageView7,imageView8,imageView9;
    private ImageView[] imgArray;
    private Runnable runnable;
    private Handler handler;
    private int score=0;

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
        setContentView(R.layout.activity_level_two);

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

        // definition imgArray
        imgArray = new ImageView[]{getImageView1(),getImageView2(),getImageView3(),getImageView4(),
                getImageView5(),getImageView6(),getImageView7(),getImageView8(),getImageView9()};

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
                    goLevelThree();
                }else{
                    // function
                    askWhatYouWant();
                }

            }
        }.start();

        hideShowImages();
    }

    // go next level
    public void goLevelThree(){
        Intent intent = new Intent(getApplicationContext(),LevelFromTwoToThree.class);
        startActivity(intent);
    }

    // increase game score
    public void increaseGameScoreLevelTwo(View view){
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
                int selecImg = random.nextInt(8);
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
                Intent restartLevel = new Intent(getApplicationContext(), LevelTwo.class);
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
