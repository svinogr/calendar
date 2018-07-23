package upump.info.calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import upump.info.calendar.model.Celebration;

import static upump.info.calendar.IConst.ID;


public class CelebretionActivity extends AppCompatActivity {
    private TextView titleTextView, descriptionTextView;
    private ImageView imageView;
    private Celebration celebration;

    public static Intent createIntent(Celebration celebration, Context context){
        Intent intent = new Intent(context, CelebretionActivity.class);
        intent.putExtra(ID, celebration.getId());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebretion);

         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleTextView = findViewById(R.id.celeb_activity_title_text);
        descriptionTextView = findViewById(R.id.celeb_activity_text);

        imageView = findViewById(R.id.celeb_activity_title_img);

        Intent intent = getIntent();
        int idCeleb = intent.getIntExtra(ID, 1);
        getCeleb(idCeleb);

        setView();
    }

    private void getCeleb(int idCeleb) {

        // получаем пра из базы
        celebration = new Celebration();
        celebration.setImg("birthday");
        celebration.setTitle("Новый Праздник");
        celebration.setDescription("Lorem ipsum rutrum tempus sapien duis gravida in vulputate tellus arcu lectus amet — pharetra eros ultricies donec lorem duis sodales eros leo enim magna porttitor. Sed cursus morbi ut ornare metus ornare non maecenas eget duis, massa, vitae nulla — nam amet cursus sodales tempus lorem commodo justo. Porta vulputate duis a magna, quam rutrum, magna elementum ligula sapien leo vivamus integer quisque ut. Donec sodales commodo enim vitae, nec morbi quisque: ut eu. Sem, mauris donec sit eros lorem justo pellentesque nibh eget morbi. Urna sodales in nulla curabitur enim mauris orci integer adipiscing sem nam ligula, adipiscing proin.\n" +
                "\n" +
                "Pellentesque elementum mauris justo ultricies urna, magna risus maecenas urna, tellus justo mattis ornare maecenas metus. Nec congue malesuada sit porta sagittis nam sagittis sem tempus sed pellentesque fusce duis quam — lorem malesuada mauris. Vitae vulputate sagittis, ipsum vivamus non: fusce porttitor ornare bibendum tellus. Nec duis molestie, mauris morbi sed, lorem malesuada lectus risus eu, enim tempus vulputate commodo. Mauris odio pharetra vitae ligula in, quam sem mattis sapien nibh diam pellentesque sagittis porttitor, nibh in a eu nulla vivamus. Nam morbi eros sagittis mauris non eu vulputate morbi ligula: nec sit in.\n" +
                "\n" +
                "Odio ut justo odio porttitor leo non integer nibh sagittis proin. A porta sodales rutrum mauris vivamus — amet sit fusce curabitur ut diam vivamus magna rutrum arcu adipiscing magna. Mauris bibendum pharetra sapien duis massa ultricies adipiscing nec metus ornare massa sit nulla diam bibendum ligula proin odio auctor. Eros ultricies non pharetra cursus ornare eget eu ut porta at sem cursus non — tellus auctor orci sapien a vitae fusce eros. Ipsum pellentesque maecenas duis et curabitur ligula ultricies gravida nam risus a malesuada, quisque — morbi eros at fusce rutrum ut.");
        ///

    }

    private void setView() {
    titleTextView.setText(celebration.getTitle());
    descriptionTextView.setText(celebration.getDescription());
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

    private void exit() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            exit();
        }
        return super.onOptionsItemSelected(item);
    }
}
