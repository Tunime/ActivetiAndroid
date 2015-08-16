package com.example.alvaro.activetiandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Date;
import java.util.List;

/**
 * Created by alvaro on 15/08/15.
 */
public class Activity_cin extends Activity implements View.OnClickListener{



    public EditText txtnombre;
    public EditText txtcodigo;
    public EditText txtnota;
    public EditText txtfecha;
    public Button guardar;
    public Button presion2;
    public Button presion3;
    int c=1;

    String month;
    String monthday;
    String year;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cin);

        //para el boton
        presion2=(Button)findViewById(R.id.presion2);
        presion2.setOnClickListener(this);

        presion3=(Button)findViewById(R.id.presion3);
        presion3.setOnClickListener(this);

        //capturamos el edit
        txtnombre=(EditText)findViewById(R.id.txtnombre);
        txtcodigo=(EditText)findViewById(R.id.txtcodigo);
        txtnota  =(EditText)findViewById(R.id.txtnota);
        txtfecha =(EditText)findViewById(R.id.txtfecha);

        Time date = new Time(Time.getCurrentTimezone());
        date.setToNow();
        month   = date.month+"";
        monthday=date.monthDay+"";
        year    =date.year+"";

        if(c==1)
        {
            for (int i = 1; i <= 9; i++) {
                modelo alumno = new modelo();
                alumno.nombre = "adada " + i;
                alumno.codigo = "123123";
                alumno.nota   = "dadaad";
                alumno.day    =monthday;
                alumno.month  =month;
                alumno.year   =year;
                alumno.save();

                Log.i("Datos : ", "Nombre : " + alumno.nombre
                        +"\n"+"Codigo : "+ alumno.codigo
                        +"\n"+"Nota : "+ alumno.nota
                        +"\n"+"Fecha : " + alumno.day+"/"+alumno.month+"/"+alumno.year);

            }
            c=0;
        }


    }

    public void onClick(View v)
    {

        if (v == presion2){
            //------------------------------------------------
            //Time date = new Time(Time.getCurrentTimezone());
            //date.setToNow();
            //String month = date.month+"";
            //String monthday=date.monthDay+"";
            //-------------------------------------

            //obtenemos en una string  los datos del edit text
            String iwanombre = txtnombre.getText().toString();
            String iwacodigo = txtcodigo.getText().toString();
            String iwanota   = txtnota.getText().toString();
            String iwadate   =txtfecha.getText().toString();

            modelo alumno = new modelo();
            alumno.nombre = iwanombre;
            alumno.codigo = iwacodigo;
            alumno.nota   = iwanota;
            alumno.day    =monthday;
            alumno.month  =month;
            alumno.year   =year;
            alumno.save();
            //Log.i("FECHA : ", alumno.date.toString());

        }
        if(v== presion3)
        {
            //String date = txtfecha.getText().toString();
            Intent i = new Intent(this, MainActivity.class );
            //i.putExtra("date",date);
            startActivity(i);
        }

    }
}
