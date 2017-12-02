package com.qalex.companyprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment_Home fragment = new Fragment_Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.Fragment,fragment);
        ft.commit();
        
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action

            Fragment_Home fragment = new Fragment_Home();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Fragment,fragment);
            ft.commit();
        } else if (id == R.id.portfolio) {
            Fragment_Protfolio fragment = new Fragment_Protfolio();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Fragment,fragment);
            ft.commit();
        } else if (id == R.id.serv) {
            Fragment_Services fragment = new Fragment_Services();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Fragment,fragment);
            ft.commit();
        } else if (id == R.id.clients) {
            Clients fragment = new Clients();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Fragment, fragment);
            ft.commit();

        }else if (id == R.id.contactus) {
            ContactUs fragment = new ContactUs();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Fragment, fragment);
            ft.commit();

        }
        else if (id == R.id.maplocation) {
            Intent i = new Intent(MainScreen.this,MapsActivity.class);
            startActivity(i);

        }
        else if (id == R.id.about) {

            About fragment = new About();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Fragment, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
