package com.example.unidades.ui.peso;

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


public class peso extends Fragment {

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

        String[] from = {"Kilogramos (kg)","gramo (gm)","miligramo (mg)"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] al = {"Kilogramos (kg)","gramo (gm)","miligramo (mg)"};
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

                if (sp1.getSelectedItem().toString() == "Kilogramos (kg)" && sp2.getSelectedItem().toString() == "gramo (gm)") {
                    tot = amount * 1000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "Kilogramos (kg)" && sp2.getSelectedItem().toString() == "miligramo (mg)")
                {

                    tot = amount * 1000000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "Kilogramos (kg)" && sp2.getSelectedItem().toString() == "Kilogramos (kg)")
                {

                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "gramo (gm)" && sp2.getSelectedItem().toString() == "gramo (gm)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "gramo (gm)" && sp2.getSelectedItem().toString() == "miligramo (mg)")
                {

                    tot = amount * 1000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "gramo (gm)" && sp2.getSelectedItem().toString() == "Kilogramos (kg)")
                {
                    tot = amount * 0.001;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "miligramo (mg)" && sp2.getSelectedItem().toString() == "miligramo (mg)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "miligramo (mg)" && sp2.getSelectedItem().toString() == "Kilogramos (kg)")
                {

                    tot = amount * 0.000001;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "miligramo (mg)" && sp2.getSelectedItem().toString() == "gramo (gm)")
                {

                    tot = amount * 0.001;
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