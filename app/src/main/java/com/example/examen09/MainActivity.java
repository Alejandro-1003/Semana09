package com.example.examen09;

import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textresultado1 = findViewById(R.id.textresultado1);
        TextView textresultado2 = findViewById(R.id.textresultado2);
        TextView textresultado = findViewById(R.id.textresultado);

        Button jugador = findViewById(R.id.jugador);
        Button reset = findViewById(R.id.reset);

        jugador.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String jugadorTexto = jugador.getText().toString();
                if (jugadorTexto.equals("JUGADOR 1")) {
                    int numeroAleatorio = generarNumeroAleatorio(1, 10);
                    textresultado1.setText(String.valueOf(numeroAleatorio));
                } else if (jugadorTexto.equals("JUGADOR 2")) {
                    int numeroAleatorio = generarNumeroAleatorio(1, 10);
                    textresultado2.setText(String.valueOf(numeroAleatorio));

                    int resultado1 = Integer.parseInt(textresultado1.getText().toString());
                    int resultado2 = Integer.parseInt(textresultado2.getText().toString());

                    if (resultado1 > resultado2) {
                        textresultado.setText("¡JUGADOR 1 gana!");
                    } else if (resultado1 < resultado2) {
                        textresultado.setText("¡JUGADOR 2 gana!");
                    } else {
                        textresultado.setText("¡Empate!");
                    }

                    jugador.setText("JUGADOR 2");
                }
                jugador.setText("JUGADOR 2");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jugador.setText("JUGADOR 1");
                textresultado1.setText("");
                textresultado2.setText("");
                textresultado.setText("");
            }
        });
    }

    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


}
