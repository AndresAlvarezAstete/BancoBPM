package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText edTxt, edTxt1;
    private ProgressBar progressBar;
    private Button iniciarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxt = (EditText)findViewById(R.id.edTxt);
        edTxt1 = (EditText)findViewById(R.id.edTxt1);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        iniciarBtn = (Button)findViewById(R.id.iniciarBtn);

        progressBar.setVisibility(View.INVISIBLE);

        iniciarBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String user = edTxt.getText().toString();
                String pass = edTxt1.getText().toString();

                if (user.equalsIgnoreCase("android") && pass.equalsIgnoreCase("123"))
                {
                    new Task().execute();
                }
                else
                    {
                        Toast.makeText(view.getContext(), "Debes ingresar un usuario y contraseña validos", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 10; i++)
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            progressBar.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Home_Activity.class);
            startActivity(i);
        }
    }

}