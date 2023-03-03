package com.example.unidades.ui.longitud;


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


public class longitud extends Fragment {

    Spinner sp1,sp2;
    EditText ed1;
    Button btn1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootVie = inflater.inflate(R.layout.fragment_longitud, container, false);


        ed1 = (EditText)rootVie.findViewById(R.id.txtcantidad_long);
        sp1 = (Spinner) rootVie.findViewById(R.id.spfrom_long);
        sp2 = (Spinner) rootVie.findViewById(R.id.spto_long);
        btn1= (Button) rootVie.findViewById(R.id.btn_convertir_long);


        String[] from = {"metros (m)","kilometros (km)","milimetros (mm)"};
        ArrayAdapter <String> ad = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] al = {"metros (m)","kilometros (km)","milimetros (mm)"};
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

                if (sp1.getSelectedItem().toString() == "metros (m)" && sp2.getSelectedItem().toString() == "kilometros (km)") {
                    tot = amount * 0.001;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "metros (m)" && sp2.getSelectedItem().toString() == "milimetros (mm)")
                {

                    tot = amount * 1000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "metros (m)" && sp2.getSelectedItem().toString() == "metros (m)")
                {

                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }



                else if (sp1.getSelectedItem().toString() == "kilomtros (km)" && sp2.getSelectedItem().toString() == "kilometros (km)") {
                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "kilomtros (km)" && sp2.getSelectedItem().toString() == "milimetros (mm)")
                {

                    tot = amount * 1000000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "kilomtros (km)" && sp2.getSelectedItem().toString() == "metros (m)")
                {

                    tot = amount * 1000;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "milimetros (mm)" && sp2.getSelectedItem().toString() == "kilometros (km)") {
                    tot = amount * 0.000001;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }

                else if (sp1.getSelectedItem().toString() == "milimetros (mm)" && sp2.getSelectedItem().toString() == "milimetros (mm)")
                {

                    tot = amount * 1;
                    Toast.makeText(getContext()," Resultado "+tot.toString(),Toast.LENGTH_LONG).show();

                }
                else if (sp1.getSelectedItem().toString() == "milimetros (mm)" && sp2.getSelectedItem().toString() == "metros (m)")
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
