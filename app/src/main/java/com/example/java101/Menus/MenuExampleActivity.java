package com.example.java101.Menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java101.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MenuExampleActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_example);


        setupNavigationView();

        setupActionBarDrawerToggel();

        setupBottomNavView();

    }


    private void setupNavigationView() {

        navigationView = findViewById(R.id.navigation_view);

        //here to define the header views.
        View headerView = navigationView.getHeaderView(0);
        final TextView textView = headerView.findViewById(R.id.navigation_header_text_view);
        final ImageView imageView = headerView.findViewById(R.id.navigation_header_image_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.home_navigation_view){

                    Toast.makeText(MenuExampleActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    textView.setText("Home");
                    imageView.setImageResource(R.drawable.ic_home);

                }else if(id == R.id.favorite_navigation_view){
                    Toast.makeText(MenuExampleActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
                    textView.setText("Favorite");
                    imageView.setImageResource(R.drawable.ic_favorite);


                }else if (id == R.id.search_navigation_view){
                    Toast.makeText(MenuExampleActivity.this, "Search", Toast.LENGTH_SHORT).show();
                    textView.setText("Search");
                    imageView.setImageResource(R.drawable.ic_search);

                }

                return true;
            }
        });



    }

    private void setupBottomNavView() {

        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.home_bottom_nav){
                    Toast.makeText(MenuExampleActivity.this, "Home", Toast.LENGTH_SHORT).show();

                }else if(id == R.id.favorite_bottom_nav){
                    Toast.makeText(MenuExampleActivity.this, "Favorite", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.search_bottom_nav){
                    Toast.makeText(MenuExampleActivity.this, "Search", Toast.LENGTH_SHORT).show();

                }

                return true;
            }
        });
    }


    private void setupActionBarDrawerToggel() {
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //we need to override onOptionsItemSelected to enable it.
        //the return for the actionBarDrawerToggle is :
        //return actionBarDrawerToggle.onOptionsItemSelected(item)

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "Sub Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
        }
    }


    //To inflate the option menu items ... define them in override method >> onOptionsItemSelected.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sub_menu_exmaple,menu);
        return true;
    }
}
