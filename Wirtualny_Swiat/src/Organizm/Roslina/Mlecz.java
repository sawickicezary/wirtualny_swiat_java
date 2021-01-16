package Organizm.Roslina;

import Organizm.Organizm;
import Swiat.Swiat;

import javax.swing.*;
import java.awt.*;

public class Mlecz extends Roslina{
    @Override
    protected void rozprzestrzenianie(Roslina rodzic, int x, int y) {
        int losowaLiczba;
        for (int i = 0; i < 3; i++) {
            losowaLiczba = (int) (Math.random() * 5); // szansa na rozmnozenie 20%
            if (losowaLiczba == 0) {

                try {
                    getSwiat__().dodajOrganizm(new Mlecz(rodzic.getSwiat__(), x, y));
                    return;
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }
    public Mlecz(Swiat swiat, int x, int y){
        setX__(x);
        setY__(y);
        setSwiat__(swiat);
        }

    @Override
    public JButton rysowanie() {
        JButton temp = new JButton("Mlecz");
        temp.setBackground(Color.YELLOW);
        return temp;
    }

    @Override
    public boolean reakcja(Organizm przeciwnik) {
        return true;
    }

}
