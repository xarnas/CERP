package com.example.arnaspetrauskas.caniaserp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
//import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;


import com.ias.webservice.LoginResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // MultiDex.install(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onButtonTap(View v){
        /*Toast myToast = Toast.makeText(getApplicationContext(),"Arnas", Toast.LENGTH_LONG);
        myToast.show();*/
        //setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.hello);
        EditText et1= (EditText)findViewById(R.id.editText);
        EditText et2= (EditText)findViewById(R.id.editText2);
        String URLCaniasConnector ="";
        CaniasConnect CC = new CaniasConnect("","","CANIAS","TEST","E","00",URLCaniasConnector);
        LoginResponse iCanias = CC.login();
        tv.setText(iCanias.getSessionId()+" "+iCanias.getErrorMessage()+" "+iCanias.getContactNum()+" "+iCanias.isSuccess());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
