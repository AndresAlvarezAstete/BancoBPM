package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_Act extends AppCompatActivity
{
    private EditText codigoTxt, nombreTxt, salarioTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_);

        codigoTxt = (EditText)findViewById(R.id.codigoTxt);
        nombreTxt = (EditText)findViewById(R.id.nombreTxt);
        salarioTxt = (EditText)findViewById(R.id.salarioTxt);
    }

    public void LimpiarCampos()
        {
            codigoTxt.setText("");
            nombreTxt.setText("");
            salarioTxt.setText("");
        }

    public void GuardarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "inventario", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigoTxt.getText().toString();

        if (!codigo.isEmpty())
        {
            ContentValues cont = new ContentValues();

            cont.put("codigo", codigoTxt.getText().toString());
            cont.put("nombre", nombreTxt.getText().toString());
            cont.put("salario", salarioTxt.getText().toString());

            db.insert("clientes", null, cont);
            db.close();

            Toast.makeText(this, "Has guardado un Cliente", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Debes ingresar un codigo valido", Toast.LENGTH_LONG).show();
        }

        LimpiarCampos();
    }

    public void MostrarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "inventario", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigoTxt.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo=" + codigo, null);

            if (fila.moveToFirst())
            {
                nombreTxt.setText(fila.getString(0));
                salarioTxt.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "No hay campos en la entidad clientes", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "No existe cliente con el codigo asociado", Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "inventario", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigoTxt.getText().toString();

        db.delete("clientes", "codigo=" + codigo, null);
        db.close();

        Toast.makeText(this, "Has eliminado un cliente", Toast.LENGTH_LONG).show();

        LimpiarCampos();
    }

    public void ActualizarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "inventario", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigoTxt.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", codigoTxt.getText().toString());
        cont.put("nombre", nombreTxt.getText().toString());
        cont.put("salario", salarioTxt.getText().toString());

        if (!codigo.isEmpty())
        {
            db.update("clientes", cont, "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this, "Has actualizado un campo", Toast.LENGTH_LONG).show();
        }

        LimpiarCampos();
    }
}