package com.example.notasapk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listViewTexto;
    EditText editTextTexto;
    List<String> lista = new ArrayList<>();
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTexto = (ListView) findViewById(R.id.txtView);
        listViewTexto.setOnItemClickListener(this);
        editTextTexto = (EditText) findViewById(R.id.editTextTextPersonName);
        leer();
    }

    public void nuevo(View view){
        lista.add(editTextTexto.getText().toString().trim());
        editTextTexto.getText().clear();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        listViewTexto.setAdapter(adaptador);
        guardar(view);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "La tarea ha sido completada", Toast.LENGTH_SHORT).show();
        lista.remove(i);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        listViewTexto.setAdapter(adaptador);
        guardar(view);
    }

    public void guardar(View v){
        File ruta = getApplicationContext().getFilesDir();
        String nombreArch = "elementos.tpo";
        try {
            FileOutputStream escribirArch = new FileOutputStream(new File(ruta,nombreArch));
            ObjectOutputStream streamArch = new ObjectOutputStream(escribirArch);
            streamArch.writeObject(lista);
            streamArch.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leer(){
        File ruta = getApplicationContext().getFilesDir();
        String nombreArch = "elementos.tpo";
        try {
            FileInputStream leeArch = new FileInputStream (new File(ruta,nombreArch));
            ObjectInputStream streamArch = new ObjectInputStream (leeArch);
            lista = (ArrayList<String>) streamArch.readObject();
            streamArch.close();
            ArrayAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
            listViewTexto.setAdapter(adaptador);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}