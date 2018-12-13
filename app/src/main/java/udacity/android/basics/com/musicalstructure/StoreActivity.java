package udacity.android.basics.com.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.label_store);

        LinearLayout album1 = (LinearLayout) findViewById(R.id.album1);
        album1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        LinearLayout album2 = (LinearLayout) findViewById(R.id.album2);
        album2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        LinearLayout album3 = (LinearLayout) findViewById(R.id.album3);
        album3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        LinearLayout album4 = (LinearLayout) findViewById(R.id.album4);
        album4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        FrameLayout storeMusic1 = (FrameLayout) findViewById(R.id.store_music1);
        storeMusic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        FrameLayout storeMusic2 = (FrameLayout) findViewById(R.id.store_music2);
        storeMusic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        FrameLayout storeMusic3 = (FrameLayout) findViewById(R.id.store_music3);
        storeMusic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        FrameLayout storeMusic4 = (FrameLayout) findViewById(R.id.store_music4);
        storeMusic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });
    }

    private void purchaseItem() {
        startActivity(new Intent(StoreActivity.this, PurchaseActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_default, menu);
        return true;
    }

    // Handle action bar buttons: open screen challenges, open settings or back to previous screen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_challenge:
                DialogFragment newFragment = new ChallengeDialogFragment();
                Bundle args = new Bundle();
                args.putString("page", "store");
                newFragment.setArguments(args);
                newFragment.show(getSupportFragmentManager(), "challenge");
                break;
            case R.id.action_settings:
                startActivity(new Intent(StoreActivity.this, SettingsActivity.class));
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
