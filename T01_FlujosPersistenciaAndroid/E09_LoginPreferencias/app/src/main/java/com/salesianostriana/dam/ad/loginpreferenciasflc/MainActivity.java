package com.salesianostriana.dam.ad.loginpreferenciasflc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("NuevasPreferencias", Context.MODE_PRIVATE);
        //Comprueba que en el archivo de las preferencias del Usuario si el booleano recordar está como True (recordado) o
        //False (no recordado), para iniciar un activity u otro. Si está recordado se logea directamente, si no muestra la pantalla
        //de Login.
        if(!prefs.getBoolean("recordar", false)){
            i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            this.finish();
        }else{
            i = new Intent(MainActivity.this, BienvenidoActivity.class);
            startActivity(i);
            this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
