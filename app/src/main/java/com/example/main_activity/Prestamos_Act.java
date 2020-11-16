package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Clases.Datos;

public class Prestamos_Act extends AppCompatActivity
{
    private Spinner spinner, spinner1;
    private TextView textTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        textTxt = (TextView)findViewById(R.id.textTxt);

        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>)getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapt1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);
        spinner.setAdapter(adapt);
        spinner1.setAdapter(adapt1);
    }

    public void CalcularPrestamo(View view)
    {
        Datos datos = new Datos();
        String clientes = spinner.getSelectedItem().toString();
        String creditos = spinner1.getSelectedItem().toString();
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        //(datos.getCreditoHipotecario() + datos.getAxel())

        if (clientes.equals("Axel") && creditos.equals("Credito Hipotecario"))
        {
            textTxt.setText("El total es de " + (formatea.format(datos.getCreditoHipotecario() + datos.getAxel())));
        }

        if (clientes.equals("Axel") && creditos.equals("Credito Automotriz"))
        {
            textTxt.setText("El total es de: " + (formatea.format(datos.getCreditoAutomotriz() + datos.getAxel())));
        }

        if (clientes.equals("Roxana") && creditos.equals("Credito Hipotecario"))
        {
            textTxt.setText("El total es de " + (formatea.format(datos.getCreditoHipotecario() + datos.getRoxana())));
        }

        if (clientes.equals("Roxana") && creditos.equals("Credito Automotriz"))
        {
            textTxt.setText("El total es de: " + (formatea.format(datos.getCreditoAutomotriz() + datos.getRoxana())));
        }
    }

    public void CalcularDeudas(View view)
    {
        Datos datos = new Datos();
        String clientes = spinner.getSelectedItem().toString();
        String creditos = spinner1.getSelectedItem().toString();
        DecimalFormat formatea = new DecimalFormat("###,###.##");

        int hipotecarioAxel = (datos.getCreditoHipotecario() + datos.getAxel());
        int automotrizAxel = (datos.getCreditoAutomotriz() + datos.getAxel());
        int hipotecarioRoxana = (datos.getCreditoHipotecario() + datos.getRoxana());
        int automotrizRoxana = (datos.getCreditoAutomotriz() + datos.getRoxana());

        int operacionAxel = hipotecarioAxel / 12;
        int operacionAxel1 = automotrizAxel / 8;
        int operacionRoxana = hipotecarioRoxana / 12;
        int operacionRoxana1 = automotrizRoxana / 8;

        if (clientes.equals("Axel") && creditos.equals("Credito Hipotecario"))
        {
            textTxt.setText("Tu credito Hipotecario serían 12 cuotas de: " + (formatea.format(operacionAxel)));
        }

        if (clientes.equals("Axel") && creditos.equals("Credito Automotriz"))
        {
            textTxt.setText("Tu credito Automotriz serían 8 cuotas de: " + (formatea.format(operacionAxel1)));
        }

        if (clientes.equals("Roxana") && creditos.equals("Credito Hipotecario"))
        {
            textTxt.setText("Tu credito Hipotecario serían 12 cuotas de: " + (formatea.format(operacionRoxana)));
        }

        if (clientes.equals("Roxana") && creditos.equals("Credito Automotriz"))
        {
            textTxt.setText("Tu credito Automotriz serían 8 cuotas de: " + (formatea.format(operacionRoxana1)));
        }
    }
}