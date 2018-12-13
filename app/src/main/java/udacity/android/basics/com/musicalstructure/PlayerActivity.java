package udacity.android.basics.com.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.label_player);
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
                args.putString("page", "player");
                newFragment.setArguments(args);
                newFragment.show(getSupportFragmentManager(), "challenge");
                break;
            case R.id.action_settings:
                startActivity(new Intent(PlayerActivity.this, SettingsActivity.class));
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
