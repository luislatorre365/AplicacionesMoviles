package com.example.nuevacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    private TextView tv_operacion, tv_resultado;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9,
            btn_porcent,btn_multi, btn_div, btn_rest, btn_suma, btn_igu,
            btn_punto,btn_c,btn_del,btn_parenteis;

    String data;
    private Boolean decimal=false;

    private Boolean tipoPar=false;

    private Boolean bandera=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_operacion =(TextView)findViewById(R.id.Tv_operacion);
        tv_resultado =(TextView)findViewById(R.id.Tv_resultado);

        btn_0 = findViewById(R.id.btn_cero);
        btn_1 = findViewById(R.id.btn_uno);
        btn_2 = findViewById(R.id.btn_dos);
        btn_3 = findViewById(R.id.btn_tres);
        btn_4 = findViewById(R.id.btn_cuatro);
        btn_5 = findViewById(R.id.btn_cinco);
        btn_6 = findViewById(R.id.btn_seis);
        btn_7 = findViewById(R.id.btn_siete);
        btn_8 = findViewById(R.id.btn_ocho);
        btn_9 = findViewById(R.id.btn_nueve);

        btn_porcent = findViewById(R.id.btn_porcentaje);
        btn_multi = findViewById(R.id.btn_multiplicar);
        btn_div = findViewById(R.id.btn_dividir);
        btn_rest = findViewById(R.id.btn_menos);
        btn_suma = findViewById(R.id.btn_mas);
        btn_igu = findViewById(R.id.btn_igual);
        btn_punto = findViewById(R.id.btn_punto);
        btn_c = findViewById(R.id.btn_C);
        btn_del = findViewById(R.id.btn_eliminar);
        btn_parenteis = findViewById(R.id.btn_parentesis);

    }

    public void  calcular (View view){

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"0");
                tipoPar=true;
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"1");
                tipoPar=true;
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"2");
                tipoPar=true;
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"3");
                tipoPar=true;
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"4");
                tipoPar=true;
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"5");
                tipoPar=true;
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"6");
                tipoPar=true;
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"7");
                tipoPar=true;
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"8");
                tipoPar=true;
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data =tv_operacion.getText().toString();
                tv_operacion.setText(data+"9");
                tipoPar=true;
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_operacion.setText("");
                tv_resultado.setText("0");
                tipoPar=false;
                bandera=true;
            }
        });

        btn_punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!decimal){
                    data=tv_operacion.getText().toString();
                    tv_operacion.setText(data+".");
                }
                decimal=true;
            }
        });

        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               data=tv_operacion.getText().toString();
               tv_operacion.setText(data+"+");
                decimal=false;
                tipoPar=false;
            }
        });

        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tv_operacion.getText().toString();
                tv_operacion.setText(data+"-");
                decimal=false;
                tipoPar=false;
            }
        });
        btn_porcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tv_operacion.getText().toString();
                tv_operacion.setText(data+"%");
                decimal=true;
                tipoPar=false;
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tv_operacion.getText().toString();
                tv_operacion.setText(data+"/");
                decimal=true;
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=tv_operacion.getText().toString();
                tv_operacion.setText(data+"*");
                decimal=true;
                tipoPar=false;
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=tv_operacion.getText().toString();
                if (text.length()>1){
                    text=text.substring(0,text.length()-1);
                    tv_operacion.setText(text);
                    if (text.charAt(text.length()-1)=='.'){
                        decimal=true;
                    }else {
                        decimal=false;
                    }
                } else {
                    tv_operacion.setText("");
                    decimal=false;
                    tipoPar=false;
                    bandera=true;
                }
            }
        });

        btn_parenteis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tipoPar==true) {
                    if (bandera == true) {
                        data = tv_operacion.getText().toString();
                        tv_operacion.setText(data + "*(");
                        bandera = false;
                    } else {
                        data = tv_operacion.getText().toString();
                        tv_operacion.setText(data + ")");
                        bandera = true;
                    }
                }else {
                    if (bandera == true) {
                        data = tv_operacion.getText().toString();
                        tv_operacion.setText(data + "(");
                        bandera = false;
                    } else {
                        data = tv_operacion.getText().toString();
                        tv_operacion.setText(data + ")");
                        bandera = true;
                    }
                }
                decimal = false;
            }
        });

        btn_igu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {
                data = tv_operacion.getText().toString();

                data = data.replaceAll("×", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");

                org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
                rhino.setOptimizationLevel(-1);

                String resultadofinal = "";


                Scriptable scriptable = rhino.initStandardObjects();
                resultadofinal = rhino.evaluateString(scriptable, data,"Javascript", 1, null).toString();
                tv_resultado.setText(resultadofinal);
                decimal = false;
            }catch(Exception e){
                tv_resultado.setText("formato invalido");
            }

            }
        });
    }

}