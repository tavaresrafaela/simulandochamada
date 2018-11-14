package com.example.tecinfo.simulandochamada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference ="call";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        final EditText NovoEmail = findViewById(R.id.novoemail);
        final EditText NovaSenha = findViewById(R.id.novasenha);
        final EditText ConfimarSenha = findViewById(R.id.confirmasenha);
        final Button Cadastrar = findViewById(R.id.btncadastrar);

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(NovaSenha.getText().toString().equals(ConfimarSenha.getText().toString())){

                    SharedPreferences.Editor editor = meusDados.edit();
                    editor.putString("email",NovoEmail.getText().toString());
                    editor.putString("senha", NovaSenha.getText().toString());

                    editor.commit();

                    Toast.makeText(getApplicationContext(), "DADOD SALVOS", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "As senhas não conferem", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
