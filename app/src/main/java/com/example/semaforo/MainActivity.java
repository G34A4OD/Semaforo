package com.example.semaforo;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_cambiar;

    int bucle = 0;
    ImageView imageGris;
    ImageView imageRojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //conectar xml con javs
        setContentView(R.layout.activity_main);

        btn_cambiar = findViewById(R.id.btn_cambiar);
        imageGris = findViewById(R.id.imageGris);
        imageRojo = findViewById(R.id.imageRojo);

        btn_cambiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run (){


//Primer cambio de imagen
                        //bucle por que si
                        while (bucle <= 20) {
                            //Solo ejecuta el tiempo para que la imagen cambie
                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            //Luego del tiempo se ejecuta el cambio de la imagen
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageRojo.setImageResource(R.drawable.gris);
                                    imageGris.setImageResource(R.drawable.rojo);
                                }
                            });

                            //bucel que devuelve la imagen a su lugar
                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            //Luego del tiempo se ejecuta el cambio de la imagen
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    int imagenRojo = R.drawable.rojo;
                                    int imagenGris = R.drawable.gris;
                                    imageRojo.setImageResource(imagenRojo);
                                    imageGris.setImageResource(imagenGris);
                                }
                            });
                        }
                    }
                });
                //Termina el hilo
                thread.start();
            }
        });

    }
}