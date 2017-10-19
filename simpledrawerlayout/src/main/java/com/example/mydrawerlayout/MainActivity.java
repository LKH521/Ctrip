package com.example.mydrawerlayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
  Button bt;
  TextView tx;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
    bt = (Button) findViewById(R.id.button);
    bt.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        drawerLayout.openDrawer(Gravity.LEFT);
      }
    });
    tx = (TextView) findViewById(R.id.textView);
    tx.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(MainActivity.this, "sadasdasda", Toast.LENGTH_SHORT).show();
        drawerLayout.closeDrawer(Gravity.LEFT);
      }
    });
  }
}
