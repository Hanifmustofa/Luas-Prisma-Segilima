package com.hanifmustofa.luasprisma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input_Luas_Alas, input_Luas_Selimut;
    Button hitung;
    TextView  keterangan_luas;
    String luas="hasil dari luas prisma segilima adalah";
    int hasil, luas_alas, luas_selimut;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keterangan_luas=(TextView) findViewById(R.id.keterangan_luas);
        input_Luas_Alas=(EditText)findViewById(R.id.input_Luas_Alas);
        input_Luas_Selimut=(EditText)findViewById(R.id.input_Luas_Selimut);
        hitung=(Button) findViewById(R.id.permukaan);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isValid()){
                
                    hitung();

                }
                    
            }
        });
    }

    public void hitung() {

        luas_alas = 5 * Integer.parseInt(input_Luas_Alas.getText().toString()) * 2;
        luas_selimut = Integer.parseInt(input_Luas_Alas.getText().toString()) * Integer.parseInt(input_Luas_Selimut.getText().toString()) * 5 ;

        hasil = luas_alas + luas_selimut;

        Toast.makeText(getApplicationContext(), String.valueOf(hasil), Toast.LENGTH_LONG).show();

        keterangan_luas.setText("2 x (5 x " + input_Luas_Alas.getText().toString() + ") + 5 x (" + input_Luas_Alas.getText().toString() + " x " + input_Luas_Selimut.getText().toString() + ") = " + String.valueOf(hasil));


    }
    public boolean isValid(){

        if (input_Luas_Alas.getText().toString().isEmpty()) {
            input_Luas_Alas.setError("Masukkan Sisi");
            valid = false;
        } else if (input_Luas_Selimut.getText().toString().isEmpty()) {
            input_Luas_Selimut.setError("Masukkan Tinggi");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }
}
