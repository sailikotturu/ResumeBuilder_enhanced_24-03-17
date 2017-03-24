package com.example.sailik.resumebuilder_24_feb.activities;


import android.preference.PreferenceActivity;

import android.os.Bundle;

import com.example.sailik.resumebuilder_24_feb.fragments.SettingsFragment;


public class AboutScreen extends PreferenceActivity {

    //public static SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();


    }



}