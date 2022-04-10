package com.coursera.semana3.mascotas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coursera.semana3.mascotas1.adapter.AdaptadorMascotas;
import com.coursera.semana3.mascotas1.adapter.PageAdapter;
import com.coursera.semana3.mascotas1.fragment.PerfilFragment;
import com.coursera.semana3.mascotas1.fragment.RecyclerViewFragment;
import com.coursera.semana3.mascotas1.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    TextView txt;
    private Toolbar myToolbar;
    private TabLayout myTablayout;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTablayout=(TabLayout) findViewById(R.id.myTabLayout);
        myViewPager=(ViewPager) findViewById(R.id.myViewPager);
        myToolbar=(Toolbar)findViewById(R.id.myToolbar);
        myToolbar.setNavigationIcon(R.drawable.pata);
         ImageView star=new ImageView(this);
        star.setImageResource(R.drawable.cincoestrella);
      if(myToolbar!=null) setSupportActionBar(myToolbar);

        setUpViewPager();
        txt=(TextView)findViewById(R.id.MyTextView);
        setUpViewPager();

    }



    private ArrayList<Fragment> agregaFragments(){
        ArrayList<Fragment>fragments=new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void setUpViewPager(){
        myViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregaFragments()));
        myTablayout.setupWithViewPager(myViewPager);
        myTablayout.getTabAt(0).setIcon(R.drawable.ic_home);
        myTablayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infla=getMenuInflater();
        infla.inflate(R.menu.mi_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.contacto:
                startActivity(new Intent(MainActivity.this, FormularioDatos.class));
                break;

            case R.id.ItemEstrella:
                startActivity(new Intent(MainActivity.this,MascotasFavoritas.class));
                break;

            case R.id.AcercDe:
                startActivity(new Intent(MainActivity.this,ConanYo.class));
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}