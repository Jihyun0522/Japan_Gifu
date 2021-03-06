package kr.hs.mirim.japan_gifu;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat;
    TextView Today;
    TextView season;

    Button category;
    Context context;
    Button home;
    ImageButton search;

    DrawerLayout drawerLayout;
    View drawerView;

    ImageButton buttonOpenDrawer;
    ImageButton buttonCloseDrawer;

    LinearLayout s_festival;
    TextView s_festival_spring;
    TextView s_festival_summer;
    TextView s_festival_fall;
    TextView s_festival_winter;
    LinearLayout s_sightseeing;
    LinearLayout s_stay;
    LinearLayout s_food;

    Intent intent;

    //날짜 표시
    private String getTime() {
        mFormat = new SimpleDateFormat("yyyy.MM.dd");

        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    //오늘의 달
    private int getMonth() {
        int m = 0;
        mFormat = new SimpleDateFormat("MM");

        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        m = Integer.parseInt(mFormat.format(mDate));

        return m;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인 화면
        drawerLayout = (DrawerLayout) findViewById(R.id.m_drawerLayout);
        //drawer 참조
        drawerView = (View) findViewById(R.id.drawer_menu);

        // 드로어 여는 버튼 리스너
        buttonOpenDrawer = (ImageButton) findViewById(R.id.opendrawer);
        buttonOpenDrawer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        // 드로어 닫는 버튼 리스너
        buttonCloseDrawer = (ImageButton) findViewById(R.id.closedrawer);
        buttonCloseDrawer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                drawerLayout.closeDrawers();
            }
        });

        Today = (TextView) findViewById(R.id.today);
        Today.setText(getTime());

        home = (Button) findViewById(R.id.btn_home);
        season = (TextView) findViewById(R.id.season);
        category = (Button) findViewById(R.id.btn_category);
        search = (ImageButton) findViewById(R.id.btn_search);
        context = this;

        home.setTextColor(ContextCompat.getColor(this, R.color.main));

        //봄, 여름, 가을, 겨울에 따라 한자 출력
        switch (getMonth()) {
            case 3:
            case 4:
            case 5:
                season.setText("春");
                break;

            case 6:
            case 7:
            case 8:
                season.setText("夏");
                break;

            case 9:
            case 10:
            case 11:
                season.setText("秋");
                break;

            case 12:
            case 1:
            case 2:
                season.setText("冬");
                break;
        }

        //계절 intent를 제거했더니 앱이 강제종료가 되지 않음,
        //그러나 계절 넘기는 게 필요
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, category.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, search.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        //drawer menu
        s_festival = findViewById(R.id.s_festival);
        s_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, festival_basic.class);
                intent.putExtra("activity", "main");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_festival_spring = findViewById(R.id.s_festival_spring);
        s_festival_spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, festival_basic.class);
                intent.putExtra("activity", "main");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_festival_summer = findViewById(R.id.s_festival_summer);
        s_festival_summer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, festival_basic.class);
                intent.putExtra("activity", "main");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_festival_fall = findViewById(R.id.s_festival_fall);
        s_festival_fall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, festival_basic.class);
                intent.putExtra("activity", "main");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_festival_winter = findViewById(R.id.s_festival_winter);
        s_festival_winter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, festival_basic.class);
                intent.putExtra("activity", "main");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_sightseeing = findViewById(R.id.s_sightseeing);
        s_sightseeing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, basic_menu.class);
                intent.putExtra("activity", "main");
                intent.putExtra("menu_type", "sightseeing");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_stay = findViewById(R.id.s_stay);
        s_stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, basic_menu.class);
                intent.putExtra("activity", "main");
                intent.putExtra("menu_type", "stay");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        s_food = findViewById(R.id.s_food);
        s_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, basic_menu.class);
                intent.putExtra("activity", "main");
                intent.putExtra("menu_type", "food");
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}