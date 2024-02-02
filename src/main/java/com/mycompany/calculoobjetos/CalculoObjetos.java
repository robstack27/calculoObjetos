/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculoobjetos;



import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import frontend.MenuJFrame;

/**
 *
 * @author PC
 */
public class CalculoObjetos {

    public static void main(String[] args) {
        FlatDarkFlatIJTheme.setup();
        MenuJFrame menu = new MenuJFrame ();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);  
    }
}
