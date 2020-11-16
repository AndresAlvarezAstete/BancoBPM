package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_Act extends AppCompatActivity
{
    private EditText edtTxt;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_);

        edtTxt = (EditText)findViewById(R.id.edtTxt);
        txt = (TextView)findViewById(R.id.txt);
    }

    private SecretKeySpec generateKey(String password)throws Exception
    {
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        return secretKey;
    }

    public String Encriptar(String datos, String password)throws Exception
    {
        if (!edtTxt.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(password);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);

            return datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void Encriptar(View view)
    {
        try
        {
            String mensaje = Encriptar(edtTxt.getText().toString(), txt.getText().toString());
            txt.setText(mensaje);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}