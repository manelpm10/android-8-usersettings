package es.pue.android.usersettings;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.pue.android.usersettings.fragments.SettingsButtonFragment;
import es.pue.android.usersettings.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements SettingsButtonFragment.ISettingsAccess {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.settings_container, new SettingsButtonFragment()).commit();

    }

    @Override
    public void showSettings() {
        fragmentTransaction = fragmentManager.beginTransaction();
        // With this line, we return to activity on click in return button.
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.settings_container, new SettingsFragment()).commit();
    }
}
