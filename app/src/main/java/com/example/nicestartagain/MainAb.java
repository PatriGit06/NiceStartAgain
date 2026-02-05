package com.example.nicestartagain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainAb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_ab);

        BottomAppBar bottomAppBar=findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab=findViewById(R.id.fab);

        myfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainAb.this, "FAB Clicked", Toast.LENGTH_LONG).show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.heart){
                    Toast.makeText(MainAb.this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.search){
                    Toast.makeText(MainAb.this, "Buscando...", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    private void showBottomSheetDialog(){
        View view= LayoutInflater.from(this).inflate(R.layout.activity_my_bottom_sheet, null);

        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

        TextView op1=view.findViewById(R.id.op1);
        TextView op2=view.findViewById(R.id.op2);
        TextView op3=view.findViewById(R.id.op3);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainAb.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainAb.this, "About clicked", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });

        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainAb.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
    }
}