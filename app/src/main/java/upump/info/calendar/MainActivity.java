package upump.info.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.Date;

import upump.info.calendar.model.Celebration;
import upump.info.calendar.model.Day;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private FloatingActionButton fabBlessEvening, fabBlessMorning, fabHolly, fabFood;
    private ImageView imageView;
    private TextView titleTextView, oldTextView, newTextView;
    private Day day;
    private Celebration celebration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabBlessEvening = findViewById(R.id.main_activity_fab_evening_bless);
        fabBlessMorning = findViewById(R.id.main_activity_fab_morning_bless);
        fabHolly = findViewById(R.id.main_activity_fab_holy);
        fabFood = findViewById(R.id.main_activity_fab_food);

        titleTextView = findViewById(R.id.main_activity_name_celebration);
        newTextView = findViewById(R.id.main_activity_new_style);
        oldTextView = findViewById(R.id.main_activity_old_style);

        imageView = findViewById(R.id.main_activity_img);

        fabBlessEvening.setOnClickListener(this);
        fabBlessMorning.setOnClickListener(this);
        fabHolly.setOnClickListener(this);
        fabFood.setOnClickListener(this);
        imageView.setOnClickListener(this);


        getDay();
        getCelebraion();
        setView();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void getCelebraion() {
        celebration = new Celebration();
        celebration.setId(1);
        celebration.setDescription("");
        celebration.setTitle("Новый праздник");
        celebration.setImg("birthday");
    }

    private void setView() {
        oldTextView.setText("Старый стиль");
        newTextView.setText("Новый стиль");
        titleTextView.setText(celebration.getTitle());
        setImg();
    }

    private void setImg() {
        RequestOptions options = new RequestOptions()
                .transforms(new RoundedCorners(50))
                .fitCenter()
                .error(getResources().getDrawable(R.drawable.ic_launcher_background))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        if(celebration.getImg() != null){
            imageView.setVisibility(View.VISIBLE);
            int ident = getResources().getIdentifier(celebration.getImg(), "drawable", getPackageName());
            Glide.with(this).load(ident).apply(options).into(imageView);
        } else imageView.setVisibility(View.GONE);
    }

    private void getDay() {
        long sec = System.currentTimeMillis();

        // магия

        day = new Day();
        day.setId(1);
        day.setDate( new Date());
        day.setIdCelebration(1);
        day.setOldDate(new Date());
        // магия енд

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int idView = v.getId();
        System.out.println(idView);
        switch (idView) {
            case R.id.main_activity_fab_evening_bless:
                break;
            case R.id.main_activity_fab_morning_bless:
                break;
            case R.id.main_activity_fab_holy:
                break;
            case R.id.main_activity_fab_food:
                break;
            case R.id.main_activity_img:
                Intent intent = CelebretionActivity.createIntent(celebration, this);
                startActivity(intent);
                break;
        }
    }
}
