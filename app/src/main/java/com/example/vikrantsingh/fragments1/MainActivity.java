package com.example.vikrantsingh.fragments1;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ClassListener{
 TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.details);




    if(findViewById(R.id.layout_default)!=null){
        FragmentManager manager=this.getSupportFragmentManager();
        manager.beginTransaction()
                .hide(manager.findFragmentById(R.id.detailFrag))
                .show(manager.findFragmentById(R.id.listFrag))

                .commit();
    }
    else if(findViewById(R.id.layout_land)!=null){
        FragmentManager manager=this.getSupportFragmentManager();
        manager.beginTransaction().
                show(manager.findFragmentById(R.id.detailFrag))
                .show(manager.findFragmentById(R.id.listFrag))
                .commit();
    }

    }

    @Override
    public void ClassListen(int index) {
        if(findViewById(R.id.layout_default)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
        String [] description=getResources().getStringArray(R.array.classes);
        t1.setText(description[index]);
    }
}
