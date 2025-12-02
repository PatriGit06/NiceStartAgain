 package com.example.nicestartagain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

 public class MainActivity extends AppCompatActivity {
     private SwipeRefreshLayout swipeLayout;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_main);

         TextView mycontext=findViewById(R.id.textview);
         registerForContextMenu(mycontext);
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
             super.onCreateContextMenu(menu, v, menuinfo);
             getMenuInflater().inflate(R.menu.menu_context, menu);
         }


         public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
//                item.getMenuInfo();
             if (item.getItemId() == R.id.item1) {
                 Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                 toast.show();
                 return true;
             } else if (item.getItemId() == R.id.item2) {
                 Toast toast2 = Toast.makeText(this, "Downloading item...",
                         Toast.LENGTH_LONG);
                 toast2.show();
                 return true;
             }
             return super.onContextItemSelected(item);
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
                 showAlertDialogButtonClicked(MainActivity.this);
                 return true;
             }
             if (id == R.id.item2) {
                 Toast.makeText(this, "Fixing", Toast.LENGTH_LONG).show();
                 return true;
             } else if (id == R.id.item3) { // Si tienes más ítems
                 showAlertDialogButtonClicked(MainActivity.this);
                 return true;
             }



             return super.onOptionsItemSelected(item);
         }

         public void showAlertDialogButtonClicked(MainActivity view){
             MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

             builder.setTitle("Uiba!");
             builder.setMessage("A dónde quieres ir?");
             builder.setIcon(R.drawable.llavecita);

             builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                 }
             });
             builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                 }
               });

             builder.setNeutralButton("Nada", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                 }
             });
             AlertDialog dialog=builder.create();
             dialog.show();
             }
 }



