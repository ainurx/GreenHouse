package com.example.greenhouse;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greenhouse.Rest.ApiClient;
import com.example.greenhouse.Rest.ApiInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    TextView ph1, ph2, air1, air2, tds1, tds2, udara1, udara2, kelembaban1, kelembaban2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ph1 = findViewById(R.id.ph_tangki1);
        ph2 = findViewById(R.id.ph_tangki2);
        air1 = findViewById(R.id.air_tangki1);
        air2 = findViewById(R.id.air_tangki2);
        tds1 = findViewById(R.id.tds_tangki1);
        tds2 = findViewById(R.id.tds_tangki2);
        udara1 = findViewById(R.id.udara1);
        udara2 = findViewById(R.id.udara2);
        kelembaban1 = findViewById(R.id.kelembaban1);
        kelembaban2 = findViewById(R.id.kelembaban2);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<String>> kontakCall = mApiInterface.getPh1();
        System.out.println("isinya " + kontakCall);
        kontakCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                System.out.println(response.body());
                ph1.setText(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "get gagal", Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get", t.toString());
            }
        });
       }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        final Handler ha = new Handler();
//        ha.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                refresh();
//                ha.postDelayed(this, 5000);
//            }
//        }, 5000);
//    }

//    public void refresh() {
//        Call<List<String>> kontakCall = mApiInterface.getPh1();
//        System.out.println("isinya " + kontakCall);
//        kontakCall.enqueue(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                System.out.println(response.body());
//                ph1.setText(response.body().get(0));
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//                Log.e("Retrofit Get", t.toString());
//            }
//        });
//    }

}
