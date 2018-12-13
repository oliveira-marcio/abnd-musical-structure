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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout releaseAlbum1 = (LinearLayout) findViewById(R.id.release_album1);
        releaseAlbum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        LinearLayout releaseAlbum2 = (LinearLayout) findViewById(R.id.release_album1);
        releaseAlbum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        LinearLayout mostPlayedAlbum1 = (LinearLayout) findViewById(R.id.most_played_album1);
        mostPlayedAlbum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLibrary();
            }
        });

        LinearLayout mostPlayedAlbum2 = (LinearLayout) findViewById(R.id.most_played_album2);
        mostPlayedAlbum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLibrary();
            }
        });

        FrameLayout mainPlayer = (FrameLayout) findViewById(R.id.main_player);
        mainPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer();
            }
        });
    }

    private void purchaseItem() {
        startActivity(new Intent(MainActivity.this, PurchaseActivity.class));
    }

    private void openLibrary() {
        startActivity(new Intent(MainActivity.this, LibraryActivity.class));
    }

    private void openPlayer() {
        startActivity(new Intent(MainActivity.this, PlayerActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle action bar buttons: open screen challenges, open settings or open app store
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_challenge:
                DialogFragment newFragment = new ChallengeDialogFragment();
                Bundle args = new Bundle();
                args.putString("page", "main");
                newFragment.setArguments(args);
                newFragment.show(getSupportFragmentManager(), "challenge");
                break;
            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;
            case R.id.action_store:
                startActivity(new Intent(MainActivity.this, StoreActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
