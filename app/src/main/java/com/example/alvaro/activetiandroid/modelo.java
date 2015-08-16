package com.example.alvaro.activetiandroid;

import android.content.ClipData;
import android.text.format.Time;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by alvaro on 25/07/15.
 */
//creamos los modelos  con sus diferentes  id (nombres)
@Table(name="Alumno",id ="id")
public class modelo extends Model {

    @Column
    public String nombre;
    @Column
    public String codigo;
    @Column
    public String nota;
    @Column
    public Date date;
    //@Column
    //public  String month;
    //las columnas simpre van  ariba de los  variables

}
