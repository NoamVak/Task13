package com.example.task13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * @author		Noam Vaknin <noamvak765@gmail.com>
 * @version	1.6 (current version number of program) - I don't know exac what to do here
 * @since		21/8/2016 (the date of the package the class was added)
 *
 */
public class MainActivity extends AppCompatActivity {
    ToggleButton kind;
    EditText first,
    dif_mult;
    double a1, d_m;
    int choice;
    String con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kind=(ToggleButton) findViewById(R.id.kind);
        first=(EditText)findViewById(R.id.first);
        dif_mult=(EditText)findViewById(R.id.dif_mult);
    }


    /**
     * Sub initiate. - series info
     *
     * <p>
     *
     * @param view the view
     */
    public void SubInitiate(View view) {
        con=first.getText().toString();
        if(con.equals("")){
            Toast.makeText(this,"have to enter initiate",Toast.LENGTH_SHORT).show();
        }
        else{
            a1=Double.parseDouble(con);
        }
    }

    /**
     * Sub dif mult- series info
     *
     * <p>
     *
     * @param view the view
     */
    public void SubDifMult(View view) {
        con=dif_mult.getText().toString();
        if(con.equals("")){
            Toast.makeText(this,"have to enter initiate",Toast.LENGTH_SHORT).show();
        }
        else{
            d_m=Double.parseDouble(con);
        }
    }

    /**
     * Result- first checks if everything have been submitted - sends current data to next act
     *
     * <p>
     *
     * @param view the view
     */
    public void Result(View view) {
        if(dif_mult.getText().toString().equals("")||first.getText().toString().equals("")){
            Toast.makeText(this,"nothing submitted",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent res=new Intent(this,SeriesInfo.class);
            res.putExtra("choice",choice);
            res.putExtra("a1",a1);
            res.putExtra("d_m",d_m);
            startActivity(res);
        }
    }

    /**
     * Register.
     *
     * <p>
     *
     * @param view the view
     */
    public void Register(View view) {
        if(kind.isChecked()){
            choice=1;
        }
        else{
            choice=2;
        }
    }
}