/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kevyn
 */
public class EnviarMail {
    public void enviarCorreo(String destinatario, String asunto, String mensaje){
        try {
            //propiedades de la conexion
            Properties p = new Properties();
            p.setProperty("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", "kevyn.proyectowad@gmail.com");//correo
            p.setProperty("mail.smtp.auth", "true");
            
            //crear la sesion
            Session session = Session.getDefaultInstance(p);
            //trabaja con el msj
            MimeMessage m = new MimeMessage(session);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            m.setSubject(asunto);
            m.setText(mensaje);
            Transport t = session.getTransport("smtp");
            t.connect(p.getProperty("mail.smtp.user"),"contrasena123");//contra
            t.sendMessage(m, m.getAllRecipients());
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        EnviarMail email=new EnviarMail();
        String destinatario="kevyn.cs24@gmail.com";
        String asunto="regis satisfactorio";
        String texto="su regis fue satis...";
        email.enviarCorreo(destinatario, asunto, texto);
       
    }
}
