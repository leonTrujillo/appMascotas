package com.coursera.semana3.mascotas1.pojo;

import static com.coursera.semana3.mascotas1.FormularioDatos.error;

import android.app.ProgressDialog;
import android.content.Context;

import android.content.Intent;
import android.os.AsyncTask;
import java.util.Properties;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail extends AsyncTask {
    private Context context;
    private Session session;
    private String email;
    private String subject;
    private String message;
    private ProgressDialog progressDialog;
    public SendMail(Context context, String email, String subject, String message){
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

       Properties props = new Properties();


        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getInstance(props,  new javax.mail.Authenticator() {
            //Authenticating the password
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ContraYmail.mail, ContraYmail.contra);
            }
        });
        session = Session.getDefaultInstance(new Properties());
        session.setDebug(true);
        try {

            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(ContraYmail.mail));
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(ContraYmail.mail));
            mm.setSubject(subject);
            mm.setText(message);
            Transport trans= session.getTransport("smtp");
            trans.connect("smtp.live.com", 25,ContraYmail.mail,ContraYmail.contra);

            trans.sendMessage(mm, mm.getAllRecipients());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"Sending message","Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        progressDialog.dismiss();
        Toast.makeText(context,"Message Sent", Toast.LENGTH_LONG).show();
        error.setText("Mensaje enviado correctamente");

    }
}