package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity
{
    private ViewFlipper viewF;
    private int[] img = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        viewF = (ViewFlipper)findViewById(R.id.slider);

        for (int i = 0; i < img.length; i++)
        {
            flip_img(img[i]);
        }
    }

    public void flip_img(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        viewF.addView(view);
        viewF.setAutoStart(true);
        viewF.setFlipInterval(2500);

        viewF.setInAnimation(this, android.R.anim.slide_in_left);
        viewF.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_Act.class);
        startActivity(i);
    }

    public void Seguridad(View view)
    {
        Intent i = new Intent(this, Seguridad_Act.class);
        startActivity(i);
    }

    public void Prestamos(View view)
    {
        lista();
    }

    public void Clientes(View view)
    {
        Intent i = new Intent(this, Clientes_Act.class);
        startActivity(i);
    }

    public void lista()
    {
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> creditos = new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");
        clientes.add("Betzabe");
        clientes.add("Matias");
        creditos.add("Credito Hipotecario");
        creditos.add("Credito Automotriz");

        Intent i = new Intent(this, Prestamos_Act.class);
        i.putExtra("listaClientes", clientes);
        i.putExtra("listaCreditos", creditos);
        startActivity(i);
    }
}