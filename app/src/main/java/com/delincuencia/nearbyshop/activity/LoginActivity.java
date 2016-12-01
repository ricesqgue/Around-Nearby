package com.delincuencia.nearbyshop.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.delincuencia.nearbyshop.R;
import com.delincuencia.nearbyshop.util.DBHelper;
import com.delincuencia.nearbyshop.util.SharedPreferenceHelper;

/***
 * Created by Ricardo on 30/11/2016.
 */
public class LoginActivity extends Activity {
    private EditText etUsuario, etPassword;
    private CheckBox checkRecordar;
    private Button btnEntrar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        checkSharedPreferences();
        inicializaElementos();
        inicializaEventos();
        abrirDataBase();

    }

    private void inicializaElementos(){
        this.etUsuario = (EditText) findViewById(R.id.etUsuario);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.checkRecordar = (CheckBox) findViewById(R.id.checkRecordar);
        this.btnEntrar = (Button) findViewById(R.id.btnEntrar);
    }

    private void inicializaEventos(){
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarBDLogin();
            }
        });
    }

    private void abrirDataBase(){
        DBHelper dbHelper = new DBHelper(this, "around.db", null, 1);
        db = dbHelper.getWritableDatabase();
        //insertarBD();
    }

    private void insertarBD(){
        db.execSQL("INSERT INTO usuario (id, username, password, firstname, lastname, sex, address) " +
        "VALUES ('1', 'edsonpuch','edsonpuch', 'Edson', 'Puch', 'Masculino', " +
        "'Heroe de Nacozari 2001, Aguascalientes, Ags.')");
    }

    private void consultarBDLogin() {
        Cursor c = db.rawQuery("SELECT id, username, firstname, lastname, sex, address " +
                "FROM usuario WHERE username = '" + this.etUsuario.getText() + "' and " +
                "password = '" + etPassword.getText() + "'", null);

        if (c.moveToFirst()) {
            //Si existe
            saveSharePreferences(c);
        }else{
            //No existe.
            Toast.makeText(this, R.string.loginNoRegistrado, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveSharePreferences(Cursor c){
        int idIndex = c.getColumnIndex("id");
        int usernameIndex = c.getColumnIndex("username");
        int firstnameIndex = c.getColumnIndex("firstname");
        int lastnameIndex = c.getColumnIndex("lastname");
        int sexIndex = c.getColumnIndex("sex");
        int addressIndex = c.getColumnIndex("address");

        SharedPreferenceHelper.putID(this, c.getString(idIndex));
        SharedPreferenceHelper.putUsername(this, c.getString(usernameIndex));
        SharedPreferenceHelper.putFirstname(this, c.getString(firstnameIndex));
        SharedPreferenceHelper.putLastname(this, c.getString(lastnameIndex));
        SharedPreferenceHelper.putSex(this, c.getString(sexIndex));
        SharedPreferenceHelper.putAddress(this, c.getString(addressIndex));

        if (this.checkRecordar.isChecked()){
            SharedPreferenceHelper.putRemember(this,true);
        }
        else{
            SharedPreferenceHelper.putRemember(this, false);
        }

    }

    private void checkSharedPreferences(){
        if (SharedPreferenceHelper.getRemember(this)){
            Toast.makeText(this,"Esta guardado " + SharedPreferenceHelper.getFirstname(this)
                    + " " + SharedPreferenceHelper.getLastname(this),Toast.LENGTH_SHORT).show();
        }
    }
}
