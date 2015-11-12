package android.prj.fpt.project1ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class HelpActivity extends RootActivity {
    ImageView ivPlay, ivAnswer1, ivAnswer2, ivAnswer3, ivStop, ivPause, ivVolume;
    TextView tvAnswer1, tvAnswer2, tvAnswer3, tvScore, tvCountRight, tvNext, tvGuide;
    SeekBar seekBarVolume;
    int count = 0;
    String lang = "en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ivPlay = (ImageView) findViewById(R.id.imageViewPlay2);
        ivAnswer1 = (ImageView) findViewById(R.id.imageViewAnswer12);
        ivAnswer2 = (ImageView) findViewById(R.id.imageViewAnswer22);
        ivAnswer3 = (ImageView) findViewById(R.id.imageViewAnswer32);
        ivStop = (ImageView) findViewById(R.id.imageViewStop2);
        ivPause = (ImageView) findViewById(R.id.imageViewPause2);
        ivVolume = (ImageView) findViewById(R.id.imageViewVolumeControl2);
        seekBarVolume = (SeekBar) findViewById(R.id.seekBarVolumeControl2);
        tvScore = (TextView) findViewById(R.id.textViewScore2);
        tvCountRight = (TextView) findViewById(R.id.textViewCountRight2);
        tvAnswer1 = (TextView) findViewById(R.id.textViewAnswer12);
        tvAnswer2 = (TextView) findViewById(R.id.textViewAnswer22);
        tvAnswer3 = (TextView) findViewById(R.id.textViewAnswer32);
        tvNext = (TextView) findViewById(R.id.tvNext_GuideBoard);
        tvGuide = (TextView) findViewById(R.id.tvGuide_GuideBoard);

        runGuide();
    }

    public void runGuide() {
        ivPlay.setVisibility(View.VISIBLE);
        tvGuide.setText(showGuide(-1, lang));
        ivAnswer2.setVisibility(View.INVISIBLE);
        tvAnswer2.setVisibility(View.INVISIBLE);
        tvScore.setVisibility(View.INVISIBLE);
        tvCountRight.setVisibility(View.INVISIBLE);
        ivStop.setVisibility(View.INVISIBLE);
        ivPause.setVisibility(View.INVISIBLE);
        ivVolume.setVisibility(View.INVISIBLE);

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (count) {
                    case 0:
                        ivAnswer2.setVisibility(View.VISIBLE);
                        tvGuide.setText(showGuide(0, lang));
                        tvAnswer2.setVisibility(View.VISIBLE);
                        tvAnswer2.setText("mango");
                        ivPlay.setVisibility(View.INVISIBLE);
                        tvScore.setVisibility(View.INVISIBLE);
                        tvCountRight.setVisibility(View.INVISIBLE);
                        ivStop.setVisibility(View.INVISIBLE);
                        ivPause.setVisibility(View.INVISIBLE);
                        ivVolume.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        tvScore.setVisibility(View.VISIBLE);
                        tvGuide.setText(showGuide(1, lang));
                        ivPlay.setVisibility(View.INVISIBLE);
                        ivAnswer2.setVisibility(View.INVISIBLE);
                        tvAnswer2.setVisibility(View.INVISIBLE);
                        tvCountRight.setVisibility(View.INVISIBLE);
                        ivStop.setVisibility(View.INVISIBLE);
                        ivPause.setVisibility(View.INVISIBLE);
                        ivVolume.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        tvCountRight.setVisibility(View.VISIBLE);
                        tvGuide.setText(showGuide(2, lang));
                        ivPlay.setVisibility(View.INVISIBLE);
                        ivAnswer2.setVisibility(View.INVISIBLE);
                        tvAnswer2.setVisibility(View.INVISIBLE);
                        tvScore.setVisibility(View.INVISIBLE);
                        ivStop.setVisibility(View.INVISIBLE);
                        ivPause.setVisibility(View.INVISIBLE);
                        ivVolume.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        ivStop.setVisibility(View.VISIBLE);
                        tvGuide.setText(showGuide(3, lang));
                        ivPlay.setVisibility(View.INVISIBLE);
                        ivAnswer2.setVisibility(View.INVISIBLE);
                        tvAnswer2.setVisibility(View.INVISIBLE);
                        tvScore.setVisibility(View.INVISIBLE);
                        tvCountRight.setVisibility(View.INVISIBLE);
                        ivPause.setVisibility(View.INVISIBLE);
                        ivVolume.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        ivPause.setVisibility(View.VISIBLE);
                        tvGuide.setText(showGuide(4, lang));
                        ivPlay.setVisibility(View.INVISIBLE);
                        ivAnswer2.setVisibility(View.INVISIBLE);
                        tvAnswer2.setVisibility(View.INVISIBLE);
                        tvScore.setVisibility(View.INVISIBLE);
                        tvCountRight.setVisibility(View.INVISIBLE);
                        ivStop.setVisibility(View.INVISIBLE);
                        ivVolume.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        ivVolume.setVisibility(View.VISIBLE);
                        tvGuide.setText(showGuide(5, lang));
                        if(lang.equals("en")){
                            tvNext.setText("Got it");
                        }else{
                            tvNext.setText("Đã hiểu");
                        }
                        ivPlay.setVisibility(View.INVISIBLE);
                        ivAnswer2.setVisibility(View.INVISIBLE);
                        tvAnswer2.setVisibility(View.INVISIBLE);
                        tvScore.setVisibility(View.INVISIBLE);
                        tvCountRight.setVisibility(View.INVISIBLE);
                        ivStop.setVisibility(View.INVISIBLE);
                        ivPause.setVisibility(View.INVISIBLE);
                        break;
                    case 6:
                        finish();
                        break;
                }
                count++;
            }
        });
    }

    public String showGuide(int num, String lang) {
        String value = "";
        if (lang.equals("en")) {
            switch (num) {
                case -1:
                    value =  "Tap the headphone icon to hear the audio";
                    break;
                case 0:
                    value =  "Choose the answer matches with the audio";
                    break;
                case 1:
                    value =  "Show the score";
                    break;
                case 2:
                    value =  "Count the right answers";
                    break;
                case 3:
                    value =  "Stop the lesson";
                    break;
                case 4:
                    value =  "Save the lesson";
                    break;
                case 5:
                    value =  "Control the volume";
                    break;
            }
        }
        if (lang.equals("vi")) {
            switch (num) {
                case -1:
                    value =  "Nhấn vào tai nghe để bắt đầu nghe";
                    break;
                case 0:
                    value =  "Chọn đáp án phù hợp";
                    break;
                case 1:
                    value =  "Hiển thị số điểm";
                    break;
                case 2:
                    value =  "Đếm số câu trả lời đúng";
                    break;
                case 3:
                    value =  "Thoát khỏi bài học";
                    break;
                case 4:
                    value =  "Lưu lại bài học";
                    break;
                case 5:
                    value =  "Điều chỉnh âm lượng";
                    break;
            }
        }
        return value;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itemEn:
                lang = "en";
                count = 0;
                tvNext.setText("Next");
                runGuide();
                break;
            case R.id.itemVi:
                lang = "vi";
                count = 0;
                tvNext.setText("Tiếp");
                runGuide();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
