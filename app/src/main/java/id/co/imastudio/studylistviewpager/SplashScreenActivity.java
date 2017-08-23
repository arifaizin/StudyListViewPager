package id.co.imastudio.studylistviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashScreenActivity extends AppCompatActivity {

    AVLoadingIndicatorView aviloading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        aviloading = (AVLoadingIndicatorView) findViewById(R.id.avi) ;
        startAnim();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(pindah);
//                finish();
            }
        }, 5000);
    }

    void startAnim(){
        aviloading.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        aviloading.hide();
        // or avi.smoothToHide();
    }
}
