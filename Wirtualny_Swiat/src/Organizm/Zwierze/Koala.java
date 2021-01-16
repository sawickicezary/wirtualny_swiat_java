package Organizm.Zwierze;

import Organizm.Organizm;
import Swiat.Swiat;

import javax.swing.*;
import java.awt.*;

public class Koala extends Zwierze {
    public Koala(Swiat swiat, int x, int y)
    {
        this.setSila__(1);
        this.setInicjatywa__(1);
        this.setX__(x);
        this.setY__(y);
        this.setSwiat__(swiat);
    }
    @Override
    public JButton rysowanie() {
        JButton temp = new JButton("Koala");
        temp.setBackground(Color.GRAY);
        return temp;
    }

    @Override
    protected Zwierze rozmnazanie(Organizm rodzic, int x, int y) {
        return new Koala(rodzic.getSwiat__(), x,y );
    }

    @Override
    public void akcja() {
        int rand = (int) (Math.random() * 100);
        if (rand < 10)
            super.akcja();
        else if(rand == 99){
            this.setZyje__(false); // Spada z drzewa
        }

    }
}
