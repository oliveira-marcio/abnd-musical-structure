package udacity.android.basics.com.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.label_library);

        FrameLayout file1 = (FrameLayout) findViewById(R.id.file1);
        file1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer();
            }
        });

        FrameLayout file2 = (FrameLayout) findViewById(R.id.file2);
        file2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer();
            }
        });

        FrameLayout file3 = (FrameLayout) findViewById(R.id.file3);
        file3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer();
            }
        });

        FrameLayout file4 = (FrameLayout) findViewById(R.id.file4);
        file4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer();
            }
        });
    }

    private void openPlayer() {
        startActivity(new Intent(LibraryActivity.this, PlayerActivity.class));
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
                args.putString("page", "library");
                newFragment.setArguments(args);
                newFragment.show(getSupportFragmentManager(), "challenge");
                break;
            case R.id.action_settings:
                startActivity(new Intent(LibraryActivity.this, SettingsActivity.class));
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
