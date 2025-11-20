 package com.example.nicestartagain;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

 public class MainActivity extends AppCompatActivity {
     private SwipeRefreshLayout swipeLayout;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         //EdgeToEdge.enable(this);
         TextView mycontext=findViewById(R.id.textview);
         setContentView(R.layout.activity_main);

         swipeLayout = findViewById(R.id.myswipe);
         swipeLayout.setOnRefreshListener(mOnRefreshListener);


         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
             Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
             return insets;
         });
     }
     protected SwipeRefreshLayout.OnRefreshListener
             mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

         @Override
         public void onRefresh() {
             Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
             toast0.show();
             swipeLayout.setRefreshing(false);
         }
     };

         @Override
         public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo) {
             getMenuInflater().inflate(R.menu.menu_context, menu);
         }


         public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
//                item.getMenuInfo();
             if (item.getItemId() == R.id.item1) {
                 Toast toast = Toast.makeText(this, "Item copied",
                         Toast.LENGTH_LONG);
                 toast.show();
             } else if (item.getItemId() == R.id.item2) {
                 Toast toast2 = Toast.makeText(this, "Downloading item...",
                         Toast.LENGTH_LONG);
                 toast2.show();
             }
             return false;
         }

         @Override
         public boolean onCreateOptionsMenu(Menu menu) {
             // Inflate the menu; this adds items to the action bar if it is present.
             getMenuInflater().inflate(R.menu.menu_appbar, menu);
             return true;
         }

         @Override
         public boolean onOptionsItemSelected(MenuItem item) {
             // Handle action bar item clicks here. The action bar will
             // automatically handle clicks on the Home/Up button, so long
             // as you specify a parent activity in AndroidManifest.xml.
             int id = item.getItemId();

             if (id == R.id.item1) {
//            showAlertDialogButtonClicked(Main.this);

                 Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
                 toast.show();

             }
             if (id == R.id.item2) {
                 Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
                 toast.show();
             }


             return super.onOptionsItemSelected(item);
         }


 }