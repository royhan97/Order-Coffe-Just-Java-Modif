package com.project.roy.ordercoffe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void tambah (View view){
        TextView inputJumlah = (TextView) findViewById(R.id.nol);
        TextView totalHarga = (TextView) findViewById(R.id.harga);
        CheckBox Chocolate = (CheckBox) findViewById(R.id.Topping);
        CheckBox Vanilla = (CheckBox) findViewById(R.id.Topping1);
        boolean Choc = Chocolate.isChecked();
        boolean Van = Vanilla.isChecked();
        int banyak= Integer.parseInt(inputJumlah.getText().toString());
        int tambah = 1;
        int cost = 5;
        if(Choc==false&&Van==true) {
            int total = banyak + tambah;
            banyak = banyak + 1;
            int price = banyak * (cost + 1);
            inputJumlah.setText(Integer.toString(total));
            totalHarga.setText(Integer.toString(price));
        }
        else if(Choc==true&&Van==true) {
            int total = banyak + tambah;
            banyak = banyak + 1;
            int price = banyak * (cost + 3);
            inputJumlah.setText(Integer.toString(total));
            totalHarga.setText(Integer.toString(price));
        }
        else if(Choc==true&&Van==false) {
                int total = banyak + tambah;
                banyak = banyak + 1;
                int price = banyak * (cost + 2);
                inputJumlah.setText(Integer.toString(total));
                totalHarga.setText(Integer.toString(price));
        }
        else{
                int total = banyak + tambah;
                banyak = banyak + 1;
                int price = banyak * (cost);
                inputJumlah.setText(Integer.toString(total));
                totalHarga.setText(Integer.toString(price));
            }
    }

    public void kurang (View view){
        TextView totalHarga = (TextView) findViewById(R.id.harga);
        TextView inputJumlah = (TextView) findViewById(R.id.nol);
        CheckBox Chocolate = (CheckBox) findViewById(R.id.Topping);
        CheckBox Vanilla = (CheckBox) findViewById(R.id.Topping1);
        boolean Choc = Chocolate.isChecked();
        boolean Van = Vanilla.isChecked();
        int banyak= Integer.parseInt(inputJumlah.getText().toString());
        if(banyak==0){
            Toast.makeText(getApplicationContext(),"Silahkan tap botton +",Toast.LENGTH_SHORT).show();
        }
        else {
            int kurang = 1;
            int cost=5;
            int total = banyak - kurang;
            banyak=banyak-1;
            if(Choc==false&&Van==true) {
                int price = banyak * (cost + 1);
                totalHarga.setText(Integer.toString(price));
            }
            else if(Choc==true&&Van==true) {
                int price = banyak * (cost + 3);
                totalHarga.setText(Integer.toString(price));
            }
            else if(Choc==true&&Van==false) {
                int price = banyak * (cost + 2);
                totalHarga.setText(Integer.toString(price));
            }
            else{
                int price = banyak * (cost);
                totalHarga.setText(Integer.toString(price));
            }
            inputJumlah.setText(Integer.toString(total));
        }
    }

    public void price (View view){
        TextView totalHarga = (TextView) findViewById(R.id.harga);
        int harga;
        TextView  banyak = (TextView) findViewById(R.id.nol);
        int jumlah= Integer.parseInt(banyak.getText().toString());
        CheckBox Chocolate = (CheckBox) findViewById(R.id.Topping);
        CheckBox Vanilla = (CheckBox) findViewById(R.id.Topping1);
        boolean Van = Vanilla.isChecked();
        boolean Choc = Chocolate.isChecked();
        if(Choc==false&&Van==true) {
            harga=jumlah*6;
            totalHarga.setText(Integer.toString(harga));
        }
        else if(Choc==true&&Van==true) {
            harga=jumlah*8;
            totalHarga.setText(Integer.toString(harga));
        }
        else if(Choc==true&&Van==false) {
            harga=jumlah*7;
            totalHarga.setText(Integer.toString(harga));
        }
        else{
            harga=jumlah*5;
            totalHarga.setText(Integer.toString(harga));
        }
    }

    public void order (View view){
        TextView totalHarga = (TextView) findViewById(R.id.harga);
        TextView Jumlah = (TextView) findViewById(R.id.nol);
        TextView summary = (TextView) findViewById(R.id.orderSummary);
        EditText name = (EditText) findViewById(R.id.name);
        CheckBox Chocolate = (CheckBox) findViewById(R.id.Topping);
        CheckBox Vanilla = (CheckBox) findViewById(R.id.Topping1);
        boolean Choc = Chocolate.isChecked();
        boolean Van = Vanilla.isChecked();
        int harga= Integer.parseInt(totalHarga.getText().toString());
        int banyak= Integer.parseInt(Jumlah.getText().toString());
        String pesan2 = name.getText().toString();
        String pesan1 = "\nJumlah kopi dipesan   : "+banyak;
        String pesan3 = "\nChocolate topping     : "+Choc;
        String pesan4 = "\nVanilla Cream Topping : "+Van;
        pesan1 = pesan2+pesan3+pesan4+pesan1+"\nTotal harga                  : $"+harga;
        if(pesan2.equals("")) {
            Toast.makeText(getApplicationContext(),"Inputkan nama terlebih dahulu",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + pesan2);
            intent.putExtra(Intent.EXTRA_TEXT, pesan1);
            if(intent.resolveActivity(getPackageManager())!=null){
                startActivity(intent);
            }
            /*summary.setText(pesan1);*/
        }
    }

}
