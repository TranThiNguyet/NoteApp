package com.aszqsc.dontforgeteverything;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.aszqsc.dontforgeteverything.fragment.FavFragment;
import com.aszqsc.dontforgeteverything.fragment.HomeFragment;
import com.aszqsc.dontforgeteverything.model.MyDatabaseHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class MainActivity extends AppCompatActivity {

    public static View deleteZone;
    ViewPager viewPager;
    BottomNavigationView bottomNav;

    HomeFragment homeFragment;
    FavFragment workFragment;
    FavFragment familyFragment;
    FavFragment friendsFragment;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //dangki
//        sqLiteDatabase = new MyDatabaseHelper(this);
//        edttk = (EditText)findViewById(R.id.edttk);
//        edtmk = (EditText)findViewById(R.id.edtmk);
//        edtcfmk = (EditText)findViewById(R.id.edtcfmk);
//        btndangki = (Button)findViewById(R.id.buttondk);
//        btndangnhap = (Button)findViewById(R.id.buttondn);
//        btndangnhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(MainActivity.this, Login.class);
//            }
//        });
//        btndangki.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                String s1 = edttk.getText().toString();
//                String s2 = edtmk.getText().toString();
//                String s3 = edtcfmk.getText().toString();
//                if(s1.equals("") || s2.equals("") || s3.equals("")){
//                    Toast.makeText(getApplicationContext(), "Vui lòng Không được để trống các trường", Toast.LENGTH_SHORT).show();
//                }else{
//                    if(s2.equals(s3)){
//                        Boolean chkemail = sqLiteDatabase.chkemail(s1);
//                        if(chkemail == true){
//                            Boolean insert = sqLiteDatabase.insert(s1, s2);
//                            if(insert == true){
//                                Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else{
//                            Toast.makeText(getApplicationContext(), "Email đã tồn tại. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    Toast.makeText(getApplicationContext(), "Password không trùng khớp. vui lòng nhập lại.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        initDB_Fragment();
        initViewPagerFragment();
        initBottomNav();
        initDeleteZone();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                bottomNav.getMenu().getItem(position).setChecked(true);
                loadFragment(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    private void initDeleteZone() {
        deleteZone = findViewById(R.id.deleteZoneLayout);
        deleteZone.setOnDragListener(new UIutil());

        deleteZone.animate()
                .translationY(deleteZone.getHeight());

        deleteZone.setVisibility(View.GONE);
    }

    private void initBottomNav() {
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //  Fragment selectedFragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.nav_work:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_family:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_friend:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_about:
                        viewPager.setCurrentItem(3);
                        break;


                    //      selectedFragment = new FavFragment();


                }

                //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                //        selectedFragment).commit();

                return true;
            }

        });
    }

    private void initViewPagerFragment() {
        viewPager = findViewById(R.id.viewpager);
        ViewpagerAdapter viewPagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(workFragment);
        viewPagerAdapter.addFragment(familyFragment);
        viewPagerAdapter.addFragment(friendsFragment);
        viewPagerAdapter.addFragment(homeFragment);
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void initDB_Fragment() {
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        homeFragment = new HomeFragment(db);
        workFragment = new FavFragment(db, 0);
        familyFragment = new FavFragment(db, 1);
        friendsFragment = new FavFragment(db, 2);

    }

    public static void hideDeleteZone() {
        deleteZone.animate()
                .translationY(deleteZone.getHeight())
                .alpha(1.0f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        deleteZone.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });


    }

    public static void showDeleteZone() {
        deleteZone.setVisibility(View.VISIBLE);
        deleteZone.animate()
                .translationY(0)
                .alpha(1.0f)
                .setListener(null);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void loadFragment(int position) {
        switch (position) {
            case 0:
                bottomNav.setBackground(getDrawable(R.color.note_c4));
                // workFragment.loadList();
                break;

            case 1:
                bottomNav.setBackground(getDrawable(R.color.note_c2));
                //familyFragment.loadList();
                break;
            case 2:
                bottomNav.setBackground(getDrawable(R.color.note_c5));
                //friendsFragment.loadList();
                break;
            case 3:
                bottomNav.setBackground(getDrawable(R.color.note_c1));
                break;

        }
    }


}
