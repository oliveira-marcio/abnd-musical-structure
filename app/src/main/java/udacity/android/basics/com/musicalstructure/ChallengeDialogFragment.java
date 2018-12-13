package udacity.android.basics.com.musicalstructure;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ChallengeDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootview = inflater.inflate(R.layout.fragment_challenge, null);

        TextView challengeTitle = (TextView) rootview.findViewById(R.id.challenge_title);
        TextView challengeDescription = (TextView) rootview.findViewById(R.id.challenge_description);

        // Write corresponding screen challenge according to arg received
        Bundle args = getArguments();
        String pageToOpen = args.getString("page");
        switch (pageToOpen) {
            case "main":
                challengeTitle.setText(R.string.label_main);
                challengeDescription.setText(R.string.description_main);
                break;
            case "store":
                challengeTitle.setText(R.string.label_store);
                challengeDescription.setText(R.string.description_store);
                break;
            case "library":
                challengeTitle.setText(R.string.label_library);
                challengeDescription.setText(R.string.description_library);
                break;
            case "player":
                challengeTitle.setText(R.string.label_player);
                challengeDescription.setText(R.string.description_player);
                break;
            case "settings":
                challengeTitle.setText(R.string.label_settings);
                challengeDescription.setText(R.string.description_settings);
                break;
            case "purchase":
                challengeTitle.setText(R.string.label_purchase);
                challengeDescription.setText(R.string.description_purchase);
                break;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.challenge_label);
        builder.setView(rootview);
        builder.setNegativeButton(R.string.challenge_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}
