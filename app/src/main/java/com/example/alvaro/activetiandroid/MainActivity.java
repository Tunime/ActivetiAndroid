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
    String dateNow;
    Date dateParam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = getIntent().getExtras().getString("date");
        dateParam = new Date(date);

        //capturamos el edit
        expnombre=(EditText)findViewById(R.id.expnombre);
        expcodigo=(EditText)findViewById(R.id.expcodigo);
        expnota  =(EditText)findViewById(R.id.expnota);
        expdate  =(EditText)findViewById(R.id.expdate);


        List<modelo> alumno  = getmodel();
        DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
        for (int i = 0; i < alumno.size(); i++) {
            String nombre1  = alumno.get(i).nombre;
            String codigo1  = alumno.get(i).codigo;
            String nota1    = alumno.get(i).nota;
            Date date1      = alumno.get(i).date;

            Log.i("Datos : ", "Nombre : " + nombre1
            +"\n"+"Codigo : "+ codigo1
            +"\n"+"Nota : "+ nota1
            +"\n"+"Fecha : " + shortDf.format(date1));

        }




        //DateFormat mediumDf = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //DateFormat longDf = DateFormat.getDateInstance(DateFormat.LONG);
        //DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL);
        //DateFormat defaultDf = DateFormat.getDateInstance();


        //Log.i("defaultdf"," 1. " + defaultDf.format(now));
        //Log.i("mediundf"," 3. " + mediumDf.format(now));
        //Log.i("longdf"," 4. " + longDf.format(now));
        //Log.i("fulldf"," 5. " + fullDf.format(now));
        //dateNow =  shortDf.format(now);


    }
    public List<modelo> getmodel(){
        return new Select()
                .from(modelo.class)
                .where("date=?",dateParam)
                .executeSingle();
    }


}
