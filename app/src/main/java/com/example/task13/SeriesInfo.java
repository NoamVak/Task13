package com.example.task13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class SeriesInfo extends AppCompatActivity  implements View.OnCreateContextMenuListener , AdapterView.OnItemClickListener{
    ListView series;
    TextView info;
    Intent res;
    int choice, row;
    double a1, d_m;
    String [] seriesV=new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_info);

        series=(ListView) findViewById(R.id.series);
        info=(TextView)findViewById(R.id.info);

        res=getIntent();
        choice=res.getIntExtra("choice",-10);
        a1=res.getDoubleExtra("a1",-99999);
        d_m=res.getDoubleExtra("d_m",-999);

        series.setOnItemClickListener(this);
        series.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, seriesV);
        series.setAdapter(adp);

        FillArray();
        seriesV[0]=String.valueOf(a1);

        series.setOnCreateContextMenuListener(this);
    }

    /**
     * Fill array. -fill ListView array with series elements
     * <p>
     */
    public void FillArray(){
        if(choice==1){
            for (int i=1;i<20;i++){
                seriesV[i]=String.valueOf(a1*(Math.pow(d_m,i)));
            }
        }
        else if(choice==2){
            for (int i=1;i<20;i++){
                seriesV[i]=String.valueOf(a1+d_m*(i));
            }
        }
    }



    /**
     * CreateContextMenu- create and fill context menu
     *
     * <p>
     *
     * @param	menu , menuInfo, View v
     */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Series Info");
        menu.add("n");
        menu.add("Sn");
    }

    /**
     * OnContextItemSelected-  shows series info when item selected
     *
     * <p>
     *
     * @param	item
     * @return boolean value
     */

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String oper=item.getTitle().toString();
        if(oper.equals("n")){
            info.setText(""+row);
            return true;
        }
        else if(oper.equals("Sn")){
            if(choice==1){
                double sum=Math.pow(d_m,row+1);
                info.setText(String.valueOf((a1*sum-a1)/(d_m-1)));
                return true;
            }
            else{
                double sum=2*a1+d_m*(row+1)-d_m;
                info.setText(String.valueOf(((row+1)*sum)/2));
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    /**
     * OnItemClick- List View - saves placement of item on the ListView
     *
     * <p>
     *
     * @param	adapterView , view, Integer i, long l
     */

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        row=i;

    }
}