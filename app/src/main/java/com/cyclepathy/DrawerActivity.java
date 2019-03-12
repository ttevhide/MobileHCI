package com.cyclepathy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

public abstract class DrawerActivity extends AppCompatActivity {

    protected DrawerLayout fullLayout;
    protected FrameLayout actContent;

    @Override
    public void setContentView(final int layoutResID) {
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        actContent = fullLayout.findViewById(R.id.content_frame);

        getLayoutInflater().inflate(layoutResID, actContent, true);
        super.setContentView(fullLayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionBar.setTitle("CyclePathy");
        actionBar.setIcon(android.R.color.transparent);

        final Context context = this;

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        fullLayout.closeDrawers();

                        int id = menuItem.getItemId();

                        Intent intent = null;
                        switch (id) {
                            case R.id.start:
                                intent = new Intent(context, StartPage.class);
                                break;
                            case R.id.events:
                                intent = new Intent(context, Events.class);
                                break;
                            case R.id.profile:
                                intent = new Intent(context, MyProfile.class);
                                break;
                            case R.id.members:
                                intent = new Intent(context, Members.class);
                                break;
                        }

                        menuItem.setChecked(true);
                        fullLayout.closeDrawers();

                        startActivity(intent);

                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                fullLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
