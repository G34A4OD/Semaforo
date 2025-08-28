package com.example.semaforo;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_cambiar;

    int bucle = 0;
    ImageView imagen1, imagen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // conectar xml con java
        setContentView(R.layout.activity_main);

        btn_cambiar = findViewById(R.id.btn_cambiar);
        imagen1 = findViewById(R.id.imagen1);
        imagen2 = findViewById(R.id.imagen2);

        btn_cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Primer hilo: controla imagen1
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (bucle <= 20) {

                            // Espera 5 segundos
                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imagen1.setImageResource(R.drawable.amarillo);
                                }
                            });

                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imagen1.setImageResource(R.drawable.verde);
                                }
                            });

                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imagen1.setImageResource(R.drawable.rojo);
                                }
                            });

                            bucle++;
                        }
                    }
                });
                thread1.start();

                // Segundo hilo: controla imagen2
                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (bucle <= 20) {

                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imagen2.setImageResource(R.drawable.amarillo);
                                }
                            });

                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imagen2.setImageResource(R.drawable.rojo);
                                }
                            });

                            for (int i = 0; i < 5; i++) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imagen2.setImageResource(R.drawable.verde);
                                }
                            });

                            bucle++;
                        }
                    }
                });
                thread2.start();
            }
        });
    }
}
