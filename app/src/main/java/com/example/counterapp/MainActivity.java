package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Toast;

import com.example.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int qty = 0;
    private ActivityMainBinding b;

    // Create the constants....
    public static final String QUANTITY_KEY = "qty";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        qty = preferences.getInt(QUANTITY_KEY,0);

       b.qty.setText(String.valueOf(qty));


    }

        public void deqty(View view) {
            //--qty;
            Toast.makeText(this, "Decrement  by 1", Toast.LENGTH_SHORT).show();

            b.qty.setText("" + -- qty);


        }

        public void inqty(View view) {
            //qty++;
            Toast.makeText(this, "increment by 1", Toast.LENGTH_SHORT).show();
            b.qty.setText("" + ++ qty);


        }
    @Override
    protected void onPause() {
        super.onPause();
        ///  Create the shared prefernces object...
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        preferences.edit()
                .putInt(QUANTITY_KEY,qty)
                .apply();
    }
    }