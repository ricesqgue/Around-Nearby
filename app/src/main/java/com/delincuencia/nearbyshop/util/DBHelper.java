package com.delincuencia.nearbyshop.util;

/**
 * Created by Ricardo on 30/11/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private String sqlCreate =
            "CREATE TABLE IF NOT EXISTS usuario " +
                    "(id INTEGER, username TEXT, password TEXT, firstname TEXT, lastname TEXT, " +
                    "sex TEXT, address TEXT)";

    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // NOTA: Por simplicidad del ejemplo aquí solo borramos la tabla
        //y la volvemos a crear.
        // Sin embargo el proceso normal es migrar los datos de la
        // tabla antigua a la nueva (con un formato distinto, nuevas columnas, etc)
        // por lo que este método debería
        // ser más elaborado.

        // Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        // Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);

    }
}