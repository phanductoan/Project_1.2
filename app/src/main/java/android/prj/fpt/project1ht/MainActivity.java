package android.prj.fpt.project1ht;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends RootActivity {
    Button btnPlay, btnLoad, btnHelp, btnQuit;
    TextView tvTitle;
    Animation animClick;
    MediaPlayer mpClick, mpBg;;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    boolean toogleMusic = true;
    Menu mOptionMenu;
    int t = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFB();
        setContentView(R.layout.activity_main);
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        btnLoad = (Button) findViewById(R.id.buttonLoad);
        btnHelp = (Button) findViewById(R.id.buttonHelp);
        btnQuit = (Button) findViewById(R.id.buttonQuit);
        tvTitle = (TextView) findViewById(R.id.textViewTitle);

        animClick = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.click);

        playGame();
        loadGame();
        showHelp();
        quitGame();
        customFont();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (toogleMusic == false){
            return;
        }
        playBackgroundMusic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mpBg.stop();
        if (toogleMusic == false){
            toogleMusic = false;
        }
    }

    public void playGame() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.startAnimation(animClick);
                playSoundClick();
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
            }
        });
    }

    public void playSoundClick() {
        mpClick = MediaPlayer.create(this, R.raw.sys_click);
        mpClick.start();
        mpClick.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mpClick.release();
            }
        });
    }

    public void loadGame() {
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLoad.startAnimation(animClick);
                playSoundClick();
                if (getInfoSaveGame("checkShare").equals("no")) {
                    PlayActivity.showToast(MainActivity.this, "You're not save any game yet !");
                } else {
                    final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogSlideAnim);
                    dialog.setTitle("Load Game");
                    dialog.setContentView(R.layout.custom_dialog_load);
                    TextView time = (TextView) dialog.findViewById(R.id.tv_cus_InfoSavedGame_Time);
                    TextView position = (TextView) dialog.findViewById(R.id.tv_cus_InfoSavedGame_Position);
                    time.setText(getInfoSaveGame("time"));
                    position.setText(getInfoSaveGame("position"));

                    Button btnCancel = (Button) dialog.findViewById(R.id.btn_cus_CancelLoadGame);
                    Button btnOK = (Button) dialog.findViewById(R.id.btn_cus_OKLoadGame);
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            PlayActivity.saveGame = true;
                            startActivity(new Intent(MainActivity.this, PlayActivity.class));
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        });
    }

    public String getInfoSaveGame(String type) {
        SharedPreferences share = getSharedPreferences("save_game", MODE_PRIVATE);
        if (type.equals("time")) {
            String time = share.getString("time", "");
            return time;
        } else if (type.equals("position")) {
            int count = share.getInt("count", 0);
            int size = share.getInt("size", 0);
            if (count == 50){
                count = 49;
            }
            return Integer.toString(count + 1) + "/" + Integer.toString(size);

        } else if(type.equals("checkShare")){
            if(!share.contains("list")){
                return "no";
            }
        }
        return "";
    }

    public void showHelp(){
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHelp.startAnimation(animClick);
                playSoundClick();
                startActivity(new Intent(MainActivity.this,HelpActivity.class));
            }
        });
    }

    public void quitGame(){
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnQuit.startAnimation(animClick);
                finish();
            }
        });
    }

    public void initFB(){
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                PlayActivity.showToast(MainActivity.this, "Please check network connection !");
            }
        });
    }

    public void shareFB(){
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Smart Listening®")
                    .setContentDescription("Phần mềm luyện nghe tiếng Anh bằng hình ảnh trên Android")
                    .setContentUrl(Uri.parse("https://www.dropbox.com/s/z12nih6yapjln0r/smart%20listening.apk?dl=0"))
                    .setImageUrl(Uri.parse("https://lh3.googleusercontent.com/-GTItp-6tnJQ/VkCCnO70DsI/AAAAAAAAAhg/laOGLv6awCI/s64-Ic42/sys_logo.png"))
                    .build();

            shareDialog.show(linkContent);
        }
    }

    public static void showInfo(Activity context){
        Dialog dialog = new Dialog(context, R.style.DialogSlideAnim);
        dialog.setTitle("Information");
        dialog.setContentView(R.layout.custom_dialog_info);
        dialog.show();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void customFont(){
        // Customs Font
        Typeface face = Typeface.createFromAsset(getAssets(), "orange_juice.ttf");
        tvTitle.setTypeface(face);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.DialogSlideAnim);
        builder.setTitle("Exit the application");
        builder.setMessage("Do you really want to exit ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    public void playBackgroundMusic(){
        mpBg = MediaPlayer.create(this,R.raw.sys_bgmusic);
        mpBg.setLooping(true);
        mpBg.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mOptionMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.itemFacebook:
                shareFB();
                break;
            case R.id.itemSpeaker:
                if(toogleMusic){
                    mOptionMenu.findItem(R.id.itemSpeaker).setIcon(R.drawable.sys_actionbar_mute);
                    mpBg.stop();
                    toogleMusic = false;
                }else{
                    mOptionMenu.findItem(R.id.itemSpeaker).setIcon(R.drawable.sys_actionbar_speaker);
                    playBackgroundMusic();
                    toogleMusic = true;
                }
                break;
            case R.id.itemInfo:
                showInfo(MainActivity.this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
