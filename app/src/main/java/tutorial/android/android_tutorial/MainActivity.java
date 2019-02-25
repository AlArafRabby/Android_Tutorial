package tutorial.android.android_tutorial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Context context;
    ArrayList prgmName;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    public static int[] prgmImages = {R.drawable.tutorials, R.drawable.interview, R.drawable.assignment, R.drawable.quizz, R.drawable.settings,R.drawable.share, R.drawable.aboutus};
    public static String[] prgmNameList = {"Android\nTutorials", "Interview\nQuestion", "Assignment", "Quiz","Settings","Share App","About Us"};
    //private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mp =MediaPlayer.create(this,R.raw.click);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#363636")));

        context = this;

        lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));


        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.and) {
                    mp.start();
                    Toast.makeText(MainActivity.this, "Hello Android Developer", Toast.LENGTH_SHORT).show();


                }
                else if(id == R.id.feedback)
                {
                    mp.start();
                    final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
                    _Intent.setType("text/html");
                    _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
                    _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
                    _Intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.mail_feedback_message));
                    startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));
                }
                else if(id == R.id.update)
                {
                    mp.start();

                }
                else if(id == R.id.install)
                {
                    mp.start();

                }
                else if(id == R.id.about)
                {

                    mp.start();
                    Intent intent = new Intent(getApplicationContext(),about_us.class);
                    startActivity(intent);
                }
                else if(id == R.id.share)
                {

                    mp.start();
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBodyText = "Check it out. Your message goes here";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));

                }
                else if(id == R.id.exit)
                {
                    mp.start();

                    finish();
                }

                return true;


            }

        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cities = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(context, cities + "is selected", Toast.LENGTH_SHORT).show();

                if(position==0)
                {
                    mp.start();
                    Intent tutorial = new Intent(getApplicationContext(),tutorial.class);
                    startActivity(tutorial);

                }
                if(position==1)
                {
                    mp.start();
                    Intent myintent = new Intent(getApplicationContext(),interview.class);
                    startActivity(myintent);

                }
                if(position==2)
                {
                    mp.start();
                    Intent assintent = new Intent(getApplicationContext(),assignment.class);
                    startActivity(assintent);

                }
                if(position==3)
                {
                    mp.start();
                    Intent tutorial = new Intent(getApplicationContext(),Quiz.class);
                    startActivity(tutorial);

                }
                if (position == 4) {
                    mp.start();
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent);

                }
                if (position == 5) {


                    mp.start();
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBodyText = "Check it out. Your message goes here";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));

                }
                if (position == 6) {
                    mp.start();
                    Intent intent = new Intent(getApplicationContext(), about_us.class);
                    startActivity(intent);

                }

            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        int id = item.getItemId();

        if (id == R.id.about) {
            Intent intent = new Intent(getApplicationContext(),about_us.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.feed) {
            Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();

            final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
            _Intent.setType("text/html");
            _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
            _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
            _Intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.mail_feedback_message));
            startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));


            return true;
        }

        if (id == R.id.share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBodyText = "Check it out. Your message goes here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));


            Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
