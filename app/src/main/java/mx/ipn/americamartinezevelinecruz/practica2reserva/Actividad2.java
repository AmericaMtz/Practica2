package mx.ipn.americamartinezevelinecruz.practica2reserva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

	String nombre = "", fecha = "", hora = "",correo="",telefono="",codigo="" ;
	int personas = 0;
	TextView muestraDatos;
	Button imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

		muestraDatos = (TextView) findViewById(R.id.muestraDatos);
		imagen=(Button) findViewById(R.id.imagen);

		Bundle recibe = new Bundle();
		recibe = this.getIntent().getExtras();

		nombre = recibe.getString("nombre");
		personas = recibe.getInt("personas");
		fecha = recibe.getString("fecha");
		hora = recibe.getString("hora");
		correo= recibe.getString("correo");
		telefono=recibe.getString("telefono");
		codigo= recibe.getString("codigo");

		imagen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(Actividad2.this, ImagenActivity.class);
				startActivity(intent);
			}
		});
		muestraDatos.setText("Reservacion a nombre de:\n" + nombre + "\n" + personas
				+ " personas\nFecha: " + fecha + "\nHora: " + hora
				+ " \nCorreo: " + correo + "\nTelefono: " + telefono + "\n"
				+ "Codigo Postal: " + codigo );

	}


    public void hacerOtraReserva(View v) {
        Intent envia = new Intent(this, MainActivity.class);
        finish();
        startActivity(envia);
    }

}
