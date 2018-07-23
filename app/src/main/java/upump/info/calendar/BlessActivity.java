package upump.info.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import upump.info.calendar.model.Blessing;

import static upump.info.calendar.IConst.ID;

public class BlessActivity extends AppCompatActivity {
    private Blessing blessing;

    public Intent createIntent(Blessing blessing){
        Intent intent = new Intent();
        intent.putExtra(ID, blessing.getId());
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bless);
    }
}
