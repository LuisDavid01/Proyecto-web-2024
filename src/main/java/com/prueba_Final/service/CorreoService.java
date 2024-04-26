/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba_Final.service;

import jakarta.mail.MessagingException;

/**
 *
 * @author Luis David
 */
public interface CorreoService {
    public void enviarCorreoHtml(
    String para, String asunto, String contenidoHtml )throws MessagingException;
}
