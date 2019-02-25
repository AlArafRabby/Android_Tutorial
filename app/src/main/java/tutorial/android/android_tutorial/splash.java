package tutorial.android.android_tutorial;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#363636")));
        setContentView(R.layout.activity_splash);
        Thread mythread = new Thread()
        {
            public void run()
            {
                try{
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();
    }
}
