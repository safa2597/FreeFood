package com.example.freefood;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.biometric.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;
import java.util.concurrent.Executor;

public class tabs extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

        private Executor executor;
        private BiometricPrompt biometricPrompt;
        private BiometricPrompt.PromptInfo promptInfo;

        private SharedPreferences mPreferences;
        public static final String sharedPrefFile = "com.example.freefood";

        SharedPreferences.OnSharedPreferenceChangeListener mListener;

        @RequiresApi(api = Build.VERSION_CODES.P)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tabs);

            executor = ContextCompat.getMainExecutor(this);
            biometricPrompt = new BiometricPrompt(tabs.this,
                    executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode,
                                                  @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    finish();
                    System.exit(0);
                }

                @Override
                public void onAuthenticationSucceeded(
                        @NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    Toast.makeText(getApplicationContext(),
                            "Authentication succeeded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    finish();
                    System.exit(0);
                }
            });

            promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("finger title")
                    .setSubtitle("finger subtitle")
                    .setNegativeButtonText("finger_negative")
                    .build();

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            NavController navController = Navigation.findNavController(this,  R.id.fragment);
            NavigationUI.setupWithNavController(bottomNavigationView, navController);

            mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            mPreferences.registerOnSharedPreferenceChangeListener(this);

            String theme;
            String language;
            String fingerprint;

            theme = mPreferences.getString("theme", "light_mode");
            language = mPreferences.getString("language", "en");
            fingerprint = mPreferences.getString("fingerprint", "off");

            if(fingerprint.equals("on")) {
                biometricPrompt.authenticate(promptInfo);
            }

            switch (theme) {
                case "light_mode":
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    break;
                case "dark_mode":
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    break;
            }

            Locale locale = new Locale(language);
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }

        @Override
        protected void onPause() {
            super.onPause();
            PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);

        }

        @Override
        protected void onResume() {
            super.onResume();
            PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);

        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(key.equals("theme")) {
                String theme = sharedPreferences.getString("theme", "light_mode");
                switch (theme) {
                    case "light_mode":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    case "dark_mode":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                }
            }
            else if (key.equals("language")) {
                String language = sharedPreferences.getString("language", "en");
                Locale locale = new Locale(language);
                Resources resources = getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        }
  }
