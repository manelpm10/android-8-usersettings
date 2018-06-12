package es.pue.android.usersettings.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.pue.android.usersettings.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsButtonFragment extends Fragment {

    private ISettingsAccess callback;
    private Button btnShowSettings;

    public SettingsButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ISettingsAccess) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_button_fragment, container, false);

        btnShowSettings = view.findViewById(R.id.btnShowSettings);
        btnShowSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.showSettings();
            }
        });

        return view;
    }

    public interface ISettingsAccess {
        void showSettings();
    }
}
