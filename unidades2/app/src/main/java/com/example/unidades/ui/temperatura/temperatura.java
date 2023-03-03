package com.example.unidades.ui.temperatura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.unidades.R;


public class temperatura extends Fragment {

    Spinner sp1,sp2;
    EditText ed1;
    Button btn1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootVie = inflater.inflate(R.layout.fragment_temperatura, container, false);

        ed1 = (EditText)rootVie.findViewById(R.id.txtcantidad_temp);
        sp1 = (Spinner) rootVie.findViewById(R.id.spfrom_temp);
        sp2 = (Spinner) rootVie.findViewById(R.id.spto_temp);
        btn1= (Button) rootVie.findViewById(R.id.btn_convertir_temp);

        String[] from = {"Celsius (°C)","Fahrenheit (°F)","Kelvin (K)"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] al = {"Celsius (°C)","Fahrenheit (°F)","Kelvin (K)"};
        ArrayAdapter <String> ad1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, al);
        sp2.setAdapter(ad1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ed1.getText().toString().trim().equals("")){
                    Toast.makeText(getContext(),"Ingresa un valor",Toast.LENGTH_LONG).show();
                    return;

                }

                Double tot;

                Double amount = Double.parseDouble(ed1.getText().toString());

                if (sp1.getSelectedItem().toString() == "Celsius (°C)" && sp2.getSelectedItem().toString() == "Celsius (°C)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "Celsius (°C)" && sp2.getSelectedItem().toString() == "Fahrenheit (°F)")
                {

                    tot = amount * 33.8;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "Celsius (°C)" && sp2.getSelectedItem().toString() == "Kelvin (K)")
                {

                    tot = amount * 214.15;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "Fahrenheit (°F)" && sp2.getSelectedItem().toString() == "Fahrenheit (°F)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "Fahrenheit (°F)" && sp2.getSelectedItem().toString() == "Celsius (°C)")
                {

                    tot = amount * -17.22222;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "Fahrenheit (°F)" && sp2.getSelectedItem().toString() == "Kelvin (K)")
                {
                    tot = amount * 255.9278;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "Kelvin (K)" && sp2.getSelectedItem().toString() == "Kelvin (K)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "Kelvin (K)" && sp2.getSelectedItem().toString() == "Celsius (°C)")
                {

                    tot = amount * -272.15;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "Kelvin (K)" && sp2.getSelectedItem().toString() == "Fahrenheit (°F)")
                {

                    tot = amount * -457.8;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

            }
        });


        return rootVie;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}