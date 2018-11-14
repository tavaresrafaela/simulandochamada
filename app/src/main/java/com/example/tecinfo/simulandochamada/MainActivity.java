package com.example.tecinfo.simulandochamada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences meusdados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meusdados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        Button btnlogin = findViewById(R.id.login);
        TextView btnregistrar = findViewById(R.id.registrar);
        final EditText email = findViewById(R.id.novoemail);
        final EditText senha = findViewById(R.id.novasenha);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String meuEmail = email.getText().toString();
                String minhaSenha = senha.getText().toString();

                if (meusdados.contains("email")&& meusdados.contains("senha")){

                    if(meuEmail.equals(meusdados.getString("email", ""))&& minhaSenha.equals(meusdados.getString("senha", "")) ){

                        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Email ou senha invalidos!", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Não existem cadastros!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
