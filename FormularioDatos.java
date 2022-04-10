package com.coursera.semana3.mascotas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.coursera.semana3.mascotas1.pojo.SendMail;
import com.google.android.material.textfield.TextInputLayout;

public class FormularioDatos extends AppCompatActivity {

    private TextInputLayout nombre,telefono,email,parentComent;
    private Button miBoton;
    private String contenidoNombre,contenidoTelefono,contenidoMail;
    private EditText editName,editPhone,editMail;
    public static TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_datos);


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

        nombre=findViewById(R.id.parentName);
        editName=findViewById(R.id.EditName);
        telefono=findViewById(R.id.parentPhone);
        email=findViewById(R.id.parentMail);
        error=findViewById(R.id.error);
        miBoton=(Button)findViewById(R.id.boton);

        editPhone=findViewById(R.id.EditPhone);
        editMail=findViewById(R.id.EditMail);

        parentComent=findViewById(R.id.parentComent);

        telefono.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);

        miBoton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
               sendEmail();
            }
        });

    }

    private void sendEmail() {
        contenidoMail = editMail.getText().toString().trim();
        contenidoNombre = editName.getText().toString().trim();
        contenidoTelefono = editPhone.getText().toString().trim();
        SendMail sm = new SendMail(this, contenidoMail, contenidoNombre,parentComent.getEditText().getText().toString());
        try {
            sm.execute();
        }catch(Exception e){
            error.setText(e.toString());
        }
    }


}