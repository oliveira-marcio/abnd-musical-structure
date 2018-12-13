package udacity.android.basics.com.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.label_purchase);

        Button purchaseButton = (Button) findViewById(R.id.button_purchase);
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PurchaseActivity.this, R.string.purchase_message, Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
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
                args.putString("page", "purchase");
                newFragment.setArguments(args);
                newFragment.show(getSupportFragmentManager(), "challenge");
                break;
            case R.id.action_settings:
                startActivity(new Intent(PurchaseActivity.this, SettingsActivity.class));
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
