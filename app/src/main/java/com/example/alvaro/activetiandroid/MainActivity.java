package com.example.alvaro.activetiandroid;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;
import com.activeandroid.query.Select;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class MainActivity extends Activity{


    EditText expnombre;
    EditText expcodigo;
    EditText expnota;
    EditText expdate;


    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //capturamos el edit
        expnombre=(EditText)findViewById(R.id.expnombre);
        expcodigo=(EditText)findViewById(R.id.expcodigo);
        expnota  =(EditText)findViewById(R.id.expnota);
        expdate  =(EditText)findViewById(R.id.expdate);



        date="14-8-15";

        List<modelo> alumno  = getmodel();
        String nombre1  = alumno.get(0).nombre;
        String codigo1  = alumno.get(0).codigo;
        String nota1    = alumno.get(0).nota;
        Date date1      = alumno.get(0).date;

        Date now = new Date("05/12/2015");

        DateFormat defaultDf = DateFormat.getDateInstance();
        DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat mediumDf = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat longDf = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL);

        //Log.i("defaultdf"," 1. " + defaultDf.format(now));
        Log.i("shortdf"," 2. " + shortDf.format(now));
        Log.i("mediundf"," 3. " + mediumDf.format(now));
        Log.i("longdf"," 4. " + longDf.format(now));
        Log.i("fulldf"," 5. " + fullDf.format(now));

        expnombre.setText(nombre1);
        expcodigo.setText(codigo1);
        expnota.setText(nota1);
        expdate.setText(date1.getDay()+"-"+date1.getMonth()+"-"+date1.getYear());


    }
    public List<modelo> getmodel(){
        return new Select()
                .from(modelo.class)
                .where("date<=?",date)
                .execute();
    }


}
