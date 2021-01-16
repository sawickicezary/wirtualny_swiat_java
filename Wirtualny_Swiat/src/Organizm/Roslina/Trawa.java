package Organizm.Roslina;

import Organizm.Organizm;
import Swiat.Swiat;

import javax.swing.*;
import java.awt.*;

public class Trawa extends Roslina{

    public Trawa(Swiat swiat, int x, int y){
        this.setX__(x);
        this.setY__(y);
        this.setSwiat__(swiat);
    }
    @Override
    protected void rozprzestrzenianie(Roslina rodzic, int x, int y) {
        int losowaLiczba = (int) (Math.random() * 5); // szansa na rozmnozenie 20%
        if (losowaLiczba == 0){
            try {
                getSwiat__().dodajOrganizm(new Trawa(rodzic.getSwiat__(), x, y));
            }
            catch (Exception e){
                e.getStackTrace();
            }
        }
    }

    @Override
    public JButton rysowanie() {
        JButton temp = new JButton("Trawa");
        temp.setBackground(Color.GREEN);
        return temp;
    }

    @Override
    public boolean reakcja(Organizm przeciwnik) {
        return true;
    }
}
