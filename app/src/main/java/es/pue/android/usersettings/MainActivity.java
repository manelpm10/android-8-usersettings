package es.pue.android.usersettings;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import es.pue.android.usersettings.fragments.SettingsButtonFragment;
import es.pue.android.usersettings.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements SettingsButtonFragment.ISettingsAccess {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.settings_container, new SettingsButtonFragment()).commit();

    }

    @Override
    public void showSettings() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // With this line, we return to activity on click in return button.
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.settings_container, new SettingsFragment()).commit();
    }

    public void showVarsInSettings(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String urlNews = prefs.getString("etUrlNews", "default_value_here");
        boolean loadNews = prefs.getBoolean("shouldLoadNews", true);

        Log.d("DEBUG", "showVarsInSettings: "+urlNews);
    }
}
