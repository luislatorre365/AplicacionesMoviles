package com.example.unidades.ui.volumen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.unidades.R;


public class volumen extends Fragment {

    Spinner sp1,sp2;
    EditText ed1;
    Button btn1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootVie = inflater.inflate(R.layout.fragment_peso, container, false);

        ed1 = (EditText)rootVie.findViewById(R.id.txtcantidad_peso);
        sp1 = (Spinner) rootVie.findViewById(R.id.spfrom_peso);
        sp2 = (Spinner) rootVie.findViewById(R.id.spto_peso);
        btn1= (Button) rootVie.findViewById(R.id.btn_convertir_peso);

        String[] from = {"litros (L)","centimetros cubicos (Cm2)","galones (Gal)"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] al = {"litros (L)","centimetros cubicos (Cm2)","galones (Gal)"};
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

                if (sp1.getSelectedItem().toString() == "litros (L)" && sp2.getSelectedItem().toString() == "litros (L)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "litros (L)" && sp2.getSelectedItem().toString() == "centimetros cubicos (Cm2)")
                {

                    tot = amount * 1000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "litros (L)" && sp2.getSelectedItem().toString() == "galones (Gal)")
                {

                    tot = amount * 0.219969;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "centimetros cubicos (Cm2)" && sp2.getSelectedItem().toString() == "centimetros cubicos (Cm2)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "centimetros cubicos (Cm2)" && sp2.getSelectedItem().toString() == "litros (L)")
                {

                    tot = amount * 0.001;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "centimetros cubicos (Cm2)" && sp2.getSelectedItem().toString() == "galones (Gal)")
                {
                    tot = amount * 0.00022;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "galones (Gal)" && sp2.getSelectedItem().toString() == "galones (Gal)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "galones (Gal)" && sp2.getSelectedItem().toString() == "litros (L)")
                {

                    tot = amount * 4.54609;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "galones (Gal)" && sp2.getSelectedItem().toString() == "centimetros cubicos (Cm2)")
                {

                    tot = amount * 4546.09;
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