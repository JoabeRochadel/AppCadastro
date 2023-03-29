package devandroid.joabe.appcadastro.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.joabe.applistacurso.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        screenSpash();
    }

    private void screenSpash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainScreen = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(mainScreen);

                finish();
            }
        }, TIME_OUT_SPLASH);

    }
}