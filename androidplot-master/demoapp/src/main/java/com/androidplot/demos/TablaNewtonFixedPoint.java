package com.androidplot.demos;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hassler on 17/03/2018.
 */

public class TablaNewtonFixedPoint extends Activity {



    ArrayList<String> n,Xn,GXn,error;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newton_fixed_point_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        n = getIntent().getExtras().getStringArrayList("n");
        Xn = getIntent().getExtras().getStringArrayList("Xn");
        GXn = getIntent().getExtras().getStringArrayList("GXn");
        error = getIntent().getExtras().getStringArrayList("error");


        init();

    }

    public void init(){

        TableLayout ll = (TableLayout) findViewById(R.id.myTableLayout);

            for (int j = 0; j < n.size(); j++){
                TableRow row= new TableRow(this);
                TextView vistaN = new TextView(this);
                vistaN.setWidth(50);
                vistaN.setHeight(70);
                vistaN.setGravity(0x00000001);
                vistaN.setText(n.get(j));
                row.addView(vistaN);

                TextView vistaXn = new TextView(this);
                vistaXn.setWidth(50);
                vistaXn.setHeight(70);
                vistaXn.setGravity(0x00000001);
                vistaXn.setText(Xn.get(j));
                row.addView(vistaXn);

                TextView vistaGxn = new TextView(this);
                vistaGxn.setWidth(50);
                vistaGxn.setHeight(70);
                vistaGxn.setGravity(0x00000001);
                vistaGxn.setText(GXn.get(j));
                row.addView(vistaGxn);

                TextView vistaError = new TextView(this);
                vistaError.setWidth(50);
                vistaError.setHeight(70);
                vistaError.setGravity(0x00000001);
                vistaError.setText(error.get(j));
                row.addView(vistaError);

                ll.addView(row,j+1);

            }

        }






}
