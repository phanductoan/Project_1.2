package android.prj.fpt.project1ht;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Play2Activity extends RootActivity {
    String[] arrData = {"apple", "bridge", "bread", "exhausted", "spoon", "refrigerator", "pillow",
            "oven", "chopsticks", "passport", "luggage", "bride", "groom", "teddy",
            "motorcycle", "boat", "plane", "sheep", "crocodile", "eggs", "yogurt", "banana",
            "coconut", "grape", "mango", "honey", "pepper", "chocolate", "continent", "skyscraper",
            "tongue", "massage", "pool", "thief", "wheel", "escalator", "stair", "fortune_teller",
            "zodiac", "vampire", "ghost", "nail_clipper", "razor", "toothpaste", "great_wall",
            "eiffel_tower", "pyramid", "shampoo", "skydive", "temple"};
    List<String> listData = new ArrayList<>();
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, check, ivVolume, ivStop;
    int ident_1, ident_2, ident_3, ident_4, ident_5, ident_6, ident_7, ident_8, ident_a;
    String answer1, answer2, answer3, answer4, answer5, answer6, answerd;
    int r_audio, r_rest1, r_rest2, r_rest3, r_rest4, r_rest5, r_rest6, r_rest7, r_rest8, r_rest0;
    int so = 0;
    int good = 0;
    int oncl = 0;
    Random r = new Random();
    String a, b, c, d, e, f, g, h, i ;
    MediaPlayer mp;
    LinearLayout line4, line5, line2;
    RelativeLayout checkOk;
    TextView screenplay, click;
    AudioManager audioManager;
    SeekBar seekBarVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        img5 = (ImageView)findViewById(R.id.img5);
        img6 = (ImageView)findViewById(R.id.img6);
        img7 = (ImageView)findViewById(R.id.img7);
        img8 = (ImageView)findViewById(R.id.img8);
        img9 = (ImageView)findViewById(R.id.img9);
        img10 = (ImageView)findViewById(R.id.img10);
        img11 = (ImageView)findViewById(R.id.img11);
        img12 = (ImageView)findViewById(R.id.img12);
        img13 = (ImageView)findViewById(R.id.img13);
        img14 = (ImageView)findViewById(R.id.img14);
        img15 = (ImageView)findViewById(R.id.img15);
        img16 = (ImageView)findViewById(R.id.img16);
        screenplay = (TextView)findViewById(R.id.textViewCountRight1);
        seekBarVolume = (SeekBar) findViewById(R.id.seekBarVolumeControl1);
        ivVolume = (ImageView) findViewById(R.id.imageViewVolumeControl1);
        ivStop = (ImageView) findViewById(R.id.imageViewStop1);
        click = (TextView)findViewById(R.id.textViewScore1);
        line4 = (LinearLayout)findViewById(R.id.Line4);
        line5 = (LinearLayout)findViewById(R.id.Line5);
        line2 = (LinearLayout)findViewById(R.id.Line2);
        checkOk = (RelativeLayout)findViewById(R.id.checkOk);
        check = (ImageView)findViewById(R.id.check);
        line4.setVisibility(View.GONE);
        line5.setVisibility(View.GONE);
        seekBarVolume.setVisibility(View.INVISIBLE);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        shuffleData();
        stopGame();
        toggleVolumeControl();
        controlVolume();
        playGames();
    }

    public void playGames(){
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                check.setVisibility(View.INVISIBLE);
                gOcl1();
            }
            public void onFinish() {
                sceenOne();
            }
        }.start();
    }

    public void sceenOne(){
        randomList1();
        oncl = 10;
        good = 0;
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                screenplay.setText("1");
                click.setText(Integer.toString(oncl));
                img1.setImageResource(ident_1);
                img2.setImageResource(ident_2);
                img3.setImageResource(ident_3);
                img4.setImageResource(ident_4);
                img5.setImageResource(ident_2);
                img6.setImageResource(ident_4);
                img7.setImageResource(ident_1);
                img8.setImageResource(ident_3);
                gOcl1();
            }
            public void onFinish() {
                checkOk.setVisibility(View.INVISIBLE);
                check.setVisibility(View.VISIBLE);
                bien();
            }
        }.start();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("7")){
                    img1.setImageResource(ident_1);
                    img7.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "1";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "2";
                    return;
                }
                if (a.equals("5")){
                    img2.setImageResource(ident_2);
                    img5.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "2";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "2";
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")){
                    a = "3";
                    return;
                }
                if (a.equals("8")){
                    img3.setImageResource(ident_3);
                    img8.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "3";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "3";
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "4";
                    return;
                }
                if (a.equals("6")){
                    img4.setImageResource(ident_4);
                    img6.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "4";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "5";
                    return;
                }
                if (a.equals("2")){
                    img5.setImageResource(ident_2);
                    img2.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "5";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "5";
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "6";
                    return;
                }
                if (a.equals("4")){
                    img6.setImageResource(ident_4);
                    img4.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "6";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("1")){
                    img1.setImageResource(ident_1);
                    img7.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "7";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")) {
                    a = "8";
                    return;
                }
                if (a.equals("3")) {
                    img8.setImageResource(ident_3);
                    img3.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "8";
                    if (good == 4){
                        sceenTwo();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "8";
            }
        });
    }

    public void sceenTwo(){
        randomList1();
        oncl = 10;
        good = 0;
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                gOcl1();
            }
            public void onFinish() {
                screenplay.setText("2");
                click.setText(Integer.toString(oncl));
                checkOk.setVisibility(View.INVISIBLE);
                bien();
                CountDownTimer countDownTimer = new CountDownTimer(1000, 10) {
                    public void onTick(long millisUntilFinished) {
                        checkOk.setVisibility(View.VISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        gOcl1();
                    }
                    public void onFinish() {
                        img1.setImageResource(ident_1);
                        img2.setImageResource(ident_2);
                        img3.setImageResource(ident_3);
                        img4.setImageResource(ident_2);
                        img5.setImageResource(ident_4);
                        img6.setImageResource(ident_3);
                        img7.setImageResource(ident_1);
                        img8.setImageResource(ident_4);
                        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
                            public void onTick(long millisUntilFinished) {
                                checkOk.setVisibility(View.VISIBLE);
                                check.setVisibility(View.INVISIBLE);
                                gOcl1();
                            }
                            public void onFinish() {
                                checkOk.setVisibility(View.INVISIBLE);
                                check.setVisibility(View.VISIBLE);
                                bien();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("7")){
                    img1.setImageResource(ident_1);
                    img7.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "1";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "2";
                    return;
                }
                if (a.equals("4")){
                    img2.setImageResource(ident_2);
                    img4.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "2";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "2";
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")){
                    a = "3";
                    return;
                }
                if (a.equals("6")){
                    img3.setImageResource(ident_3);
                    img6.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "3";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "3";
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "4";
                    return;
                }
                if (a.equals("2")){
                    img4.setImageResource(ident_2);
                    img2.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "4";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "5";
                    return;
                }
                if (a.equals("8")){
                    img5.setImageResource(ident_4);
                    img8.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "5";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "5";
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")) {
                    a = "6";
                    return;
                }
                if (a.equals("3")) {
                    img6.setImageResource(ident_3);
                    img3.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "6";
                    if (good == 4) {
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "7";
                    return;
                }
                if (a.equals("1")){
                    img1.setImageResource(ident_1);
                    img7.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "7";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "8";
                    return;
                }
                if (a.equals("5")){
                    img8.setImageResource(ident_4);
                    img5.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 4){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "8";
                    if (good == 4){
                        sceenThree();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "8";
            }
        });
    }

    public void sceenThree(){
        randomList2();
        oncl = 15;
        good = 0;
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                gOcl1();
            }
            public void onFinish() {
                line4.setVisibility(View.VISIBLE);
                click.setText(Integer.toString(oncl));
                screenplay.setText("3");
                checkOk.setVisibility(View.INVISIBLE);
                bien();
                CountDownTimer countDownTimer = new CountDownTimer(1000, 10) {
                    public void onTick(long millisUntilFinished) {
                        checkOk.setVisibility(View.VISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        gOcl1();
                    }
                    public void onFinish() {
                        img1.setImageResource(ident_1);
                        img2.setImageResource(ident_2);
                        img3.setImageResource(ident_3);
                        img4.setImageResource(ident_2);
                        img5.setImageResource(ident_4);
                        img6.setImageResource(ident_3);
                        img7.setImageResource(ident_1);
                        img8.setImageResource(ident_5);
                        img9.setImageResource(ident_6);
                        img10.setImageResource(ident_5);
                        img11.setImageResource(ident_4);
                        img12.setImageResource(ident_6);
                        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
                            public void onTick(long millisUntilFinished) {
                                checkOk.setVisibility(View.VISIBLE);
                                check.setVisibility(View.INVISIBLE);
                                gOcl1();
                            }
                            public void onFinish() {
                                checkOk.setVisibility(View.INVISIBLE);
                                check.setVisibility(View.VISIBLE);
                                bien();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("7")){
                    img1.setImageResource(ident_1);
                    img7.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "1";
                    if (good == 6){
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")) {
                    a = "2";
                    return;
                }
                if (a.equals("4")) {
                    img2.setImageResource(ident_2);
                    img4.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "2";
                    if (good == 6) {
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "2";
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")) {
                    a = "3";
                    return;
                }
                if (a.equals("6")) {
                    img3.setImageResource(ident_3);
                    img6.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "3";
                    if (good == 6) {
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "3";
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")) {
                    a = "4";
                    return;
                }
                if (a.equals("2")) {
                    img4.setImageResource(ident_2);
                    img2.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "4";
                    if (good == 6) {
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "5";
                    return;
                }
                if (a.equals("11")){
                    img11.setImageResource(ident_4);
                    img5.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "5";
                    if (good == 6){
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "5";
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")){
                    a = "6";
                    return;
                }
                if (a.equals("3")){
                    img6.setImageResource(ident_3);
                    img3.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "6";
                    if (good == 6){
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")) {
                    a = "7";
                    return;
                }
                if (a.equals("1")) {
                    img7.setImageResource(ident_1);
                    img1.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "7";
                    if (good == 6) {
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "8";
                    return;
                }
                if (a.equals("10")){
                    img8.setImageResource(ident_5);
                    img10.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "8";
                    if (good == 6){
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "8";
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "9";
                    return;
                }
                if (a.equals("12")){
                    img9.setImageResource(ident_6);
                    img12.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "9";
                    if (good == 6){
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "9";
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "10";
                    return;
                }
                if (a.equals("8")){
                    img8.setImageResource(ident_5);
                    img10.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "10";
                    if (good == 6){
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "10";
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "11";
                    return;
                }
                if (a.equals("5")){
                    img5.setImageResource(ident_4);
                    img11.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "11";
                    if (good == 6) {
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "11";
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "12";
                    return;
                }
                if (a.equals("9")){
                    img12.setImageResource(ident_6);
                    img9.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "12";
                    if (good == 6) {
                        sceenForw();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "12";
            }
        });
    }

    public void sceenForw(){
        randomList2();
        oncl = 15;
        good = 0;
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                gOcl1();
            }
            public void onFinish() {
                click.setText(Integer.toString(oncl));
                screenplay.setText("4");
                checkOk.setVisibility(View.INVISIBLE);
                bien();
                CountDownTimer countDownTimer = new CountDownTimer(1000, 10) {
                    public void onTick(long millisUntilFinished) {
                        checkOk.setVisibility(View.VISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        gOcl1();
                    }
                    public void onFinish() {
                        img1.setImageResource(ident_1);
                        img2.setImageResource(ident_2);
                        img3.setImageResource(ident_3);
                        img4.setImageResource(ident_5);
                        img5.setImageResource(ident_4);
                        img6.setImageResource(ident_6);
                        img7.setImageResource(ident_2);
                        img8.setImageResource(ident_1);
                        img9.setImageResource(ident_3);
                        img10.setImageResource(ident_4);
                        img11.setImageResource(ident_5);
                        img12.setImageResource(ident_6);
                        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
                            public void onTick(long millisUntilFinished) {
                                checkOk.setVisibility(View.VISIBLE);
                                check.setVisibility(View.INVISIBLE);
                                gOcl1();
                            }
                            public void onFinish() {
                                checkOk.setVisibility(View.INVISIBLE);
                                check.setVisibility(View.VISIBLE);
                                bien();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("8")){
                    img1.setImageResource(ident_1);
                    img8.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "1";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "2";
                    return;
                }
                if (a.equals("7")){
                    img2.setImageResource(ident_2);
                    img7.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "2";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "2";
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")) {
                    a = "3";
                    return;
                }
                if (a.equals("9")) {
                    img3.setImageResource(ident_3);
                    img9.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "3";
                    if (good == 6) {
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "3";
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "4";
                    return;
                }
                if (a.equals("11")){
                    img4.setImageResource(ident_5);
                    img11.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "4";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "5";
                    return;
                }
                if (a.equals("10")){
                    img5.setImageResource(ident_4);
                    img10.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "5";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "5";
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "6";
                    return;
                }
                if (a.equals("12")){
                    img6.setImageResource(ident_6);
                    img12.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "6";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "7";
                    return;
                }
                if (a.equals("2")){
                    img2.setImageResource(ident_2);
                    img7.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "7";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "8";
                    return;
                }
                if (a.equals("1")){
                    img8.setImageResource(ident_1);
                    img1.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "8";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "8";
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")){
                    a = "9";
                    return;
                }
                if (a.equals("3")){
                    img9.setImageResource(ident_3);
                    img3.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "9";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "9";
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "10";
                    return;
                }
                if (a.equals("5")){
                    img5.setImageResource(ident_4);
                    img10.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "10";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "10";
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "11";
                    return;
                }
                if (a.equals("4")){
                    img4.setImageResource(ident_5);
                    img11.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "11";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "11";
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "12";
                    return;
                }
                if (a.equals("6")){
                    img12.setImageResource(ident_6);
                    img6.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 6){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "12";
                    if (good == 6){
                        sceenFile();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "12";
            }
        });
    }

    public void sceenFile(){
        randomList();
        oncl = 20;
        good = 0;
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                gOcl1();
            }
            public void onFinish() {
                line5.setVisibility(View.VISIBLE);
                click.setText(Integer.toString(oncl));
                screenplay.setText("5");
                checkOk.setVisibility(View.INVISIBLE);
                bien();
                CountDownTimer countDownTimer = new CountDownTimer(1000, 10) {
                    public void onTick(long millisUntilFinished) {
                        checkOk.setVisibility(View.VISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        gOcl1();
                    }
                    public void onFinish() {
                        img1.setImageResource(ident_1);
                        img2.setImageResource(ident_2);
                        img3.setImageResource(ident_3);
                        img4.setImageResource(ident_5);
                        img5.setImageResource(ident_4);
                        img6.setImageResource(ident_6);
                        img7.setImageResource(ident_2);
                        img8.setImageResource(ident_1);
                        img9.setImageResource(ident_3);
                        img10.setImageResource(ident_4);
                        img11.setImageResource(ident_5);
                        img12.setImageResource(ident_6);
                        img13.setImageResource(ident_7);
                        img14.setImageResource(ident_8);
                        img15.setImageResource(ident_8);
                        img16.setImageResource(ident_7);
                        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
                            public void onTick(long millisUntilFinished) {
                                checkOk.setVisibility(View.VISIBLE);
                                check.setVisibility(View.INVISIBLE);
                                gOcl1();
                            }
                            public void onFinish() {
                                checkOk.setVisibility(View.INVISIBLE);
                                check.setVisibility(View.VISIBLE);
                                bien();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("8")){
                    img1.setImageResource(ident_1);
                    img8.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "1";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")) {
                    a = "2";
                    return;
                }
                if (a.equals("7")) {
                    img2.setImageResource(ident_2);
                    img7.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "2";
                    if (good == 8) {
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "2";
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")) {
                    a = "3";
                    return;
                }
                if (a.equals("9")) {
                    img3.setImageResource(ident_3);
                    img9.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "3";
                    if (good == 8) {
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "3";
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")) {
                    a = "4";
                    return;
                }
                if (a.equals("11")) {
                    img4.setImageResource(ident_5);
                    img11.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "4";
                    if (good == 8) {
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "5";
                    return;
                }
                if (a.equals("10")){
                    img5.setImageResource(ident_4);
                    img10.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "5";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "5";
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "6";
                    return;
                }
                if (a.equals("12")){
                    img6.setImageResource(ident_6);
                    img12.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "6";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "7";
                    return;
                }
                if (a.equals("2")){
                    img2.setImageResource(ident_2);
                    img7.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "7";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "8";
                    return;
                }
                if (a.equals("1")){
                    img8.setImageResource(ident_1);
                    img1.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "8";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "8";
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")){
                    a = "9";
                    return;
                }
                if (a.equals("3")){
                    img9.setImageResource(ident_3);
                    img3.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "9";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "9";
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "10";
                    return;
                }
                if (a.equals("5")){
                    img5.setImageResource(ident_4);
                    img10.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "10";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "10";
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "11";
                    return;
                }
                if (a.equals("4")){
                    img4.setImageResource(ident_5);
                    img11.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "11";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "11";
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "12";
                    return;
                }
                if (a.equals("6")){
                    img12.setImageResource(ident_6);
                    img6.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "12";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "12";
            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest7), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (h.equals("1")){
                    a = "13";
                    return;
                }
                if (a.equals("16")){
                    img13.setImageResource(ident_7);
                    img16.setImageResource(ident_7);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    h = "1";
                    a = "13";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "13";
            }
        });
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest8), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (i.equals("1")){
                    a = "14";
                    return;
                }
                if (a.equals("15")){
                    img14.setImageResource(ident_8);
                    img15.setImageResource(ident_8);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    i = "1";
                    a = "14";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "14";
            }
        });
        img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest8), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (i.equals("1")){
                    a = "15";
                    return;
                }
                if (a.equals("14")){
                    img15.setImageResource(ident_8);
                    img14.setImageResource(ident_8);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    i = "1";
                    a = "15";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "15";
            }
        });
        img16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest7), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (h.equals("1")){
                    a = "16";
                    return;
                }
                if (a.equals("13")){
                    img16.setImageResource(ident_7);
                    img13.setImageResource(ident_7);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    h = "1";
                    a = "16";
                    if (good == 8){
                        sceenSix();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "16";
            }
        });
    }

    public void sceenSix(){
        randomList();
        oncl = 20;
        good = 0;
        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                gOcl1();
            }
            public void onFinish() {
                click.setText(Integer.toString(oncl));
                screenplay.setText("6");
                checkOk.setVisibility(View.INVISIBLE);
                bien();
                CountDownTimer countDownTimer = new CountDownTimer(1000, 10) {
                    public void onTick(long millisUntilFinished) {
                        checkOk.setVisibility(View.VISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        gOcl1();
                    }
                    public void onFinish() {
                        img1.setImageResource(ident_1);
                        img2.setImageResource(ident_2);
                        img3.setImageResource(ident_3);
                        img4.setImageResource(ident_8);
                        img5.setImageResource(ident_7);
                        img6.setImageResource(ident_5);
                        img7.setImageResource(ident_4);
                        img8.setImageResource(ident_6);
                        img9.setImageResource(ident_7);
                        img10.setImageResource(ident_8);
                        img11.setImageResource(ident_5);
                        img12.setImageResource(ident_4);
                        img13.setImageResource(ident_6);
                        img14.setImageResource(ident_2);
                        img15.setImageResource(ident_1);
                        img16.setImageResource(ident_3);
                        CountDownTimer countDownTimer = new CountDownTimer(2000, 10) {
                            public void onTick(long millisUntilFinished) {
                                checkOk.setVisibility(View.VISIBLE);
                                check.setVisibility(View.INVISIBLE);
                                gOcl1();
                            }
                            public void onFinish() {
                                checkOk.setVisibility(View.INVISIBLE);
                                check.setVisibility(View.VISIBLE);
                                bien();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "1";
                    return;
                }
                if (a.equals("15")){
                    img1.setImageResource(ident_1);
                    img15.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "1";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "2";
                    return;
                }
                if (a.equals("14")){
                    img2.setImageResource(ident_2);
                    img14.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "2";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "2";
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")) {
                    a = "3";
                    return;
                }
                if (a.equals("16")) {
                    img3.setImageResource(ident_3);
                    img16.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8) {
                        gameOver();
                        return;
                    }
                    if (oncl == -1) {
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "3";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0) {
                    gameOver();
                    return;
                }
                a = "3";
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest8), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "4";
                    return;
                }
                if (a.equals("10")){
                    img4.setImageResource(ident_8);
                    img10.setImageResource(ident_8);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "4";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest7), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "5";
                    return;
                }
                if (a.equals("9")){
                    img5.setImageResource(ident_7);
                    img9.setImageResource(ident_7);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "5";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "5";
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "6";
                    return;
                }
                if (a.equals("11")){
                    img6.setImageResource(ident_5);
                    img11.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "6";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (h.equals("1")){
                    a = "7";
                    return;
                }
                if (a.equals("12")){
                    img12.setImageResource(ident_4);
                    img7.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    h = "1";
                    a = "7";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (i.equals("1")){
                    a = "8";
                    return;
                }
                if (a.equals("13")){
                    img8.setImageResource(ident_6);
                    img13.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    i = "1";
                    a = "8";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "8";
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest7), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (f.equals("1")){
                    a = "9";
                    return;
                }
                if (a.equals("5")){
                    img9.setImageResource(ident_7);
                    img5.setImageResource(ident_7);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    f = "1";
                    a = "9";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "9";
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest8), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (e.equals("1")){
                    a = "10";
                    return;
                }
                if (a.equals("4")){
                    img4.setImageResource(ident_8);
                    img10.setImageResource(ident_8);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    e = "1";
                    a = "10";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "10";
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest5), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (g.equals("1")){
                    a = "11";
                    return;
                }
                if (a.equals("6")){
                    img6.setImageResource(ident_5);
                    img11.setImageResource(ident_5);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    g = "1";
                    a = "11";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "11";
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest4), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (h.equals("1")){
                    a = "12";
                    return;
                }
                if (a.equals("7")){
                    img12.setImageResource(ident_4);
                    img7.setImageResource(ident_4);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    h = "1";
                    a = "12";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "12";
            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest6), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (i.equals("1")){
                    a = "13";
                    return;
                }
                if (a.equals("8")){
                    img13.setImageResource(ident_6);
                    img8.setImageResource(ident_6);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    i = "1";
                    a = "13";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "13";
            }
        });
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest2), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (c.equals("1")){
                    a = "14";
                    return;
                }
                if (a.equals("2")){
                    img14.setImageResource(ident_2);
                    img2.setImageResource(ident_2);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    c = "1";
                    a = "14";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "14";
            }
        });
        img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest1), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (b.equals("1")){
                    a = "15";
                    return;
                }
                if (a.equals("1")){
                    img15.setImageResource(ident_1);
                    img1.setImageResource(ident_1);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    b = "1";
                    a = "15";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "15";
            }
        });
        img16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_audio = getResources().getIdentifier(listData.get(r_rest3), "raw", getPackageName());
                mp = MediaPlayer.create(getApplicationContext(), r_audio);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                seekBar();
                if (d.equals("1")){
                    a = "16";
                    return;
                }
                if (a.equals("3")){
                    img16.setImageResource(ident_3);
                    img3.setImageResource(ident_3);
                    good++;
                    oncl--;
                    click.setText(Integer.toString(oncl));
                    if (oncl == 0 && good != 8){
                        gameOver();
                        return;
                    }
                    if (oncl == -1){
                        gameOver();
                        return;
                    }
                    d = "1";
                    a = "16";
                    if (good == 8){
                        alertCompleteGame1();
                    }
                    return;
                }
                oncl--;
                click.setText(Integer.toString(oncl));
                if (oncl == 0){
                    gameOver();
                    return;
                }
                a = "16";
            }
        });
    }

    public void randomList1(){
        r_rest1 = r.nextInt(listData.size());
        r_rest2 = r.nextInt(listData.size());
        r_rest3 = r.nextInt(listData.size());
        r_rest4 = r.nextInt(listData.size());
        while (r_rest2 == r_rest1) {
            r_rest2 = r.nextInt(listData.size());
        }
        while (r_rest3 == r_rest2 || r_rest3 == r_rest1) {
            r_rest3 = r.nextInt(listData.size());
        }
        while (r_rest4 == r_rest3 || r_rest4 == r_rest2 || r_rest4 == r_rest1) {
            r_rest4 = r.nextInt(listData.size());
        }
        ident_1 = getResources().getIdentifier(listData.get(r_rest1), "drawable", getPackageName());
        ident_2 = getResources().getIdentifier(listData.get(r_rest2), "drawable", getPackageName());
        ident_3 = getResources().getIdentifier(listData.get(r_rest3), "drawable", getPackageName());
        ident_4 = getResources().getIdentifier(listData.get(r_rest4), "drawable", getPackageName());
    }

    public void randomList2(){
        r_rest1 = r.nextInt(listData.size());
        r_rest2 = r.nextInt(listData.size());
        r_rest3 = r.nextInt(listData.size());
        r_rest4 = r.nextInt(listData.size());
        r_rest5 = r.nextInt(listData.size());
        r_rest6 = r.nextInt(listData.size());
        while (r_rest2 == r_rest1) {
            r_rest2 = r.nextInt(listData.size());
        }
        while (r_rest3 == r_rest2 || r_rest3 == r_rest1) {
            r_rest3 = r.nextInt(listData.size());
        }
        while (r_rest4 == r_rest3 || r_rest4 == r_rest2 || r_rest4 == r_rest1) {
            r_rest4 = r.nextInt(listData.size());
        }
        while (r_rest5 == r_rest4 || r_rest5 == r_rest3 || r_rest5 == r_rest2 || r_rest5 == r_rest1) {
            r_rest5 = r.nextInt(listData.size());
        }
        while (r_rest6 == r_rest5 || r_rest6 == r_rest4 || r_rest6 == r_rest3 || r_rest6 == r_rest2 || r_rest6 == r_rest1) {
            r_rest6 = r.nextInt(listData.size());
        }
        ident_1 = getResources().getIdentifier(listData.get(r_rest1), "drawable", getPackageName());
        ident_2 = getResources().getIdentifier(listData.get(r_rest2), "drawable", getPackageName());
        ident_3 = getResources().getIdentifier(listData.get(r_rest3), "drawable", getPackageName());
        ident_4 = getResources().getIdentifier(listData.get(r_rest4), "drawable", getPackageName());
        ident_5 = getResources().getIdentifier(listData.get(r_rest5), "drawable", getPackageName());
        ident_6 = getResources().getIdentifier(listData.get(r_rest6), "drawable", getPackageName());
    }

    public void randomList(){
        r_rest1 = r.nextInt(listData.size());
        r_rest2 = r.nextInt(listData.size());
        r_rest3 = r.nextInt(listData.size());
        r_rest4 = r.nextInt(listData.size());
        r_rest5 = r.nextInt(listData.size());
        r_rest6 = r.nextInt(listData.size());
        r_rest7 = r.nextInt(listData.size());
        r_rest8 = r.nextInt(listData.size());
        while (r_rest2 == r_rest1) {
            r_rest2 = r.nextInt(listData.size());
        }
        while (r_rest3 == r_rest2 || r_rest3 == r_rest1) {
            r_rest3 = r.nextInt(listData.size());
        }
        while (r_rest4 == r_rest3 || r_rest4 == r_rest2 || r_rest4 == r_rest1) {
            r_rest4 = r.nextInt(listData.size());
        }
        while (r_rest5 == r_rest4 || r_rest5 == r_rest3 || r_rest5 == r_rest2 || r_rest5 == r_rest1) {
            r_rest5 = r.nextInt(listData.size());
        }
        while (r_rest6 == r_rest5 || r_rest6 == r_rest4 || r_rest6 == r_rest3 || r_rest6 == r_rest2) {
            r_rest6 = r.nextInt(listData.size());
        }
        while (r_rest7 == r_rest6 || r_rest7 == r_rest5 || r_rest7 == r_rest4 || r_rest7 == r_rest3 || r_rest7 == r_rest2) {
            r_rest6 = r.nextInt(listData.size());
        }
        while (r_rest8 == r_rest7 || r_rest8 == r_rest6 || r_rest8 == r_rest5 || r_rest8 == r_rest4 || r_rest8 == r_rest3) {
            r_rest6 = r.nextInt(listData.size());
        }
        ident_1 = getResources().getIdentifier(listData.get(r_rest1), "drawable", getPackageName());
        ident_2 = getResources().getIdentifier(listData.get(r_rest2), "drawable", getPackageName());
        ident_3 = getResources().getIdentifier(listData.get(r_rest3), "drawable", getPackageName());
        ident_4 = getResources().getIdentifier(listData.get(r_rest4), "drawable", getPackageName());
        ident_5 = getResources().getIdentifier(listData.get(r_rest5), "drawable", getPackageName());
        ident_6 = getResources().getIdentifier(listData.get(r_rest6), "drawable", getPackageName());
        ident_7 = getResources().getIdentifier(listData.get(r_rest7), "drawable", getPackageName());
        ident_8 = getResources().getIdentifier(listData.get(r_rest8), "drawable", getPackageName());
    }

    public void overGame() {
        final Dialog dialog = new Dialog(Play2Activity.this, R.style.DialogSlideAnim);
        dialog.setTitle("GameOver !");
        dialog.setContentView(R.layout.custom_dialog_play2);
        ImageView btnHome = (ImageView)dialog.findViewById(R.id.Home);
        ImageView btnReplay = (ImageView)dialog.findViewById(R.id.Replay);
        TextView txtOver = (TextView)dialog.findViewById(R.id.gameover);
        Typeface face = Typeface.createFromAsset(getAssets(), "orange_juice.ttf");
        txtOver.setTypeface(face);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                dialog.dismiss();
            }
        });
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkOk.setVisibility(View.INVISIBLE);
                check.setImageResource(R.drawable.check);
                startActivity(new Intent(Play2Activity.this, Play2Activity.class));
                finish();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void alertCompleteGame1() {
        MediaPlayer mpAlert;
        mpAlert = MediaPlayer.create(Play2Activity.this, R.raw.sys_congratulation);
        mpAlert.setVolume(0.5f, 0.5f);
        mpAlert.start();
        mpAlert.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        final Dialog dialog = new Dialog(this, R.style.DialogSlideAnim);
        dialog.setTitle("Complete Lesson");
        dialog.setContentView(R.layout.custom_dialog_complete2);
        dialog.setCanceledOnTouchOutside(false); // not permit to touch outside
        Button btnGoHomeRef = (Button) dialog.findViewById(R.id.btn_cus_Home);

        btnGoHomeRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dialog.show();
    }

    public void gOcl(){
        line2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overGame();
            }
        });
    }

    public void gOcl1(){
        line2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bien();
            }
        });
    }

    public void gameOver(){
        CountDownTimer countDownTimer = new CountDownTimer(1000, 10) {
            public void onTick(long millisUntilFinished) {
                checkOk.setVisibility(View.VISIBLE);
                check.setImageResource(R.drawable.checkno);
                gOcl();
            }
            public void onFinish() {
                overGame();
            }
        }.start();
    }

    public void bien(){
        a = "a";
        b = "b";
        c = "c";
        d = "d";
        e = "e";
        f = "f";
        g = "g";
        h = "h";
        i = "i";
        img1.setImageResource(R.drawable.sys_ic_empty);
        img2.setImageResource(R.drawable.sys_ic_empty);
        img3.setImageResource(R.drawable.sys_ic_empty);
        img4.setImageResource(R.drawable.sys_ic_empty);
        img5.setImageResource(R.drawable.sys_ic_empty);
        img6.setImageResource(R.drawable.sys_ic_empty);
        img7.setImageResource(R.drawable.sys_ic_empty);
        img8.setImageResource(R.drawable.sys_ic_empty);
        img9.setImageResource(R.drawable.sys_ic_empty);
        img10.setImageResource(R.drawable.sys_ic_empty);
        img11.setImageResource(R.drawable.sys_ic_empty);
        img12.setImageResource(R.drawable.sys_ic_empty);
        img13.setImageResource(R.drawable.sys_ic_empty);
        img14.setImageResource(R.drawable.sys_ic_empty);
        img15.setImageResource(R.drawable.sys_ic_empty);
        img16.setImageResource(R.drawable.sys_ic_empty);
    }

    public void stopGame() {
        ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Play2Activity.this, R.style.DialogSlideAnim);
                builder.setTitle("Exit the lesson");
                builder.setMessage("Are you sure exit this lesson ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }

    public void controlVolume() {
        seekBarVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBarVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void toggleVolumeControl() {
        ivVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seekBarVolume.isShown()) {
                    seekBarVolume.setVisibility(View.INVISIBLE);
                } else {
                    seekBarVolume.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void seekBar(){
        if (seekBarVolume.isShown()) {
            seekBarVolume.setVisibility(View.INVISIBLE);
        }
    }

    public void shuffleData(){
        for(int i=0; i<arrData.length; i++){
            listData.add(arrData[i]);
        }
        Collections.shuffle(listData);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Play2Activity.this, R.style.DialogSlideAnim);
        builder.setTitle("Exit the lesson");
        builder.setMessage("Are you sure exit this lesson ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }
}
