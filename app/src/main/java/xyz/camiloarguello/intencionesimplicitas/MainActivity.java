package xyz.camiloarguello.intencionesimplicitas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "La app se pauso", Toast.LENGTH_LONG).show();
        Log.i("PAUSA", "La app se pausó");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "La app se detuvo", Toast.LENGTH_SHORT).show();
        Log.i("STOP", "La app se detuvo.");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("STOP", "La app se reinició.");
    }
    public void abrirPaginaWeb(View view) {
        Intent intencionAbrirWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://unilatina.edu.co/"));
        startActivity(intencionAbrirWeb);
    }
    public void llamarAmigo(View view) {

        Intent intencionLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:3208563431"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intencionLlamar);
    }
    public void abrirCamara(View view){
        Intent intencionCamara = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intencionCamara);
    }
    public void enviarCorreo(View view){
        Intent intencionCorreo = new Intent(Intent.ACTION_SEND);
        intencionCorreo.setType("text/plain");
        intencionCorreo.putExtra(Intent.EXTRA_SUBJECT, "Correo institucional - Novedades");
        intencionCorreo.putExtra(Intent.EXTRA_TEXT, "Buenos días, este es un correo de prueba");
        intencionCorreo.putExtra(Intent.EXTRA_EMAIL, "sistemas@unilatina.edu.co");

        startActivity(intencionCorreo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.buscar){
            Toast.makeText(this, "Seleccionó Buscar", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.acerca){
            Toast.makeText(this, "Seleccionó acerca de.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Seleccionó Contacto", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
