package com.example.my_cronometro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button iniciar, detener,reiniciar;
boolean isOn=false;
TextView crono;
Thread cronos;
int mili=0, seg=0, minutos=0;
Handler h=new Handler();

private int contador=1;
private List<String> registro=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar=(Button)findViewById(R.id.iniciar);
        detener=(Button)findViewById(R.id.detener);
        reiniciar=(Button)findViewById(R.id.reiniciar);
        crono=(TextView)findViewById(R.id.crono);
        iniciar.setOnClickListener(this);
        detener.setOnClickListener(this);
        reiniciar.setOnClickListener(this);
        cronos=new Thread(new Runnable() {
            public void run() {
                while (true){
                    if (isOn){
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        mili++;
                        if(mili==999){
                            seg++;
                            mili=0;
                        }
                        if (seg==59){
                            minutos++;
                            seg=0;
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                String m="",s="",mi="";
                                if (mili<10){
                                    m="00"+mili;
                                }else if (mili<100){
                                    m="0"+mili;
                                }else {
                                    m=""+mili;
                                }
                                if (seg<10){
                                    s="0"+seg;
                                }else {
                                    s=""+seg;
                                }
                                if (minutos<10){
                                    mi="0"+minutos;
                                }else {
                                    mi=""+minutos;
                                }
                                crono.setText(mi+":"+s+":"+m);
                            }
                        });
                    }
                }
            }
        });
        cronos.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iniciar:
                isOn=true;
                break;
            case R.id.detener:
                isOn=false;
                break;
            case R.id.reiniciar:
                isOn=false;
                mili=0;
                seg=0;
                minutos=0;
                crono.setText("00:00:000");

                registro.clear();
                ArrayAdapter <String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,registro);
                ListView listView = findViewById(R.id.inicio);
                listView.setAdapter(adapter);
                contador = 1;
                break;
        }

    }

    public void bandera(View view){

        String tiempos =((TextView) findViewById(R.id.crono)).getText().toString();
        tiempos = contador+" = "+ tiempos;
        registro.add(tiempos);
        contador++;
        ArrayAdapter <String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,registro);
        ListView listView = findViewById(R.id.inicio);
        listView.setAdapter(adapter);


    }
}