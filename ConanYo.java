package com.coursera.semana3.mascotas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class ConanYo extends AppCompatActivity {
   private ImageView yo;
   private TextView bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        yo=(ImageView) findViewById(R.id.yo);
        bio=(TextView)findViewById(R.id.miBio);
        setContentView(R.layout.conan_yo);
        Toolbar myToolbar=(Toolbar)findViewById(R.id.miActionBar);
        myToolbar.setNavigationIcon(R.drawable.atras);
        ImageView star=new ImageView(this);
        star.setImageResource(R.drawable.cincoestrella);
        Toolbar.LayoutParams tbl=new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        tbl.gravity= Gravity.END;
        star.setLayoutParams(tbl);
        myToolbar.addView(star);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}