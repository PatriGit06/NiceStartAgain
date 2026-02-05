package com.example.nicestartagain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        miVisorWeb = findViewById(R.id.vistaweb);

        String html =
                "<html>" +
                        "<head><style>" +
                        "html, body { margin:0; padding:0; height:100%; overflow:hidden; }" +
                        "img { width:100%; height:100%; object-fit:cover; }" +
                        "</style></head>" +
                        "<body>" +
                        "<img src='https://thispersondoesnotexist.com' />" +
                        "</body></html>";

        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);

        // 2. SwipeRefreshLayout - CONECTADO CON TU XML (myswipe)

        // 3. Context Menu para WebView
        registerForContextMenu(miVisorWeb);

        // Long click listener para WebView
        miVisorWeb.setOnLongClickListener(v -> {
            openContextMenu(miVisorWeb);
            return true;
        });

        // 4. Edge to edge handling - CONECTADO CON TU XML (main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // AQUÍ NECESITO SABER QUÉ MENÚ TIENES: ¿menu_appbar? ¿menu_context?
        getMenuInflater().inflate(R.menu.menu_appbar, menu); // O el que uses
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast.makeText(this, "Item copied", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.item2) {
            Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.item3) {

            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
            builder.setTitle("¿Quieres salir?");
            builder.setMessage("Acción importante");

            builder.setPositiveButton("Ir al login", (dialog, which) -> {
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            });

            builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            showAlertDialogButtonClicked(MainActivity.this);
            return true;
        }

        if (id == R.id.item2) {
            Toast.makeText(this, "Fixing", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.item3) {
            startActivity(new Intent(MainActivity.this, Profile.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialogButtonClicked() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Options!!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.fresitas);

        builder.setPositiveButton("Scrolling", (dialog, which) ->
                Toast.makeText(MainActivity.this, "Scrolling...", Toast.LENGTH_LONG).show()
        );

        builder.setNegativeButton("Do nothing", (dialog, which) -> dialog.dismiss());

        builder.setNeutralButton("Inicio", (dialog, which) -> {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        });

        builder.show();
    }

    public void showAlertDialogButtonClicked(MainActivity view) {
        showAlertDialogButtonClicked();
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener =
            () -> {
                Toast.makeText(MainActivity.this,
                        "Hi there! I don't exist :)",
                        Toast.LENGTH_LONG).show();
                swipeLayout.setRefreshing(false);
            };
}