package Organizm.Zwierze;

import Organizm.Organizm;
import Swiat.Swiat;

import javax.swing.*;
import java.awt.*;

public class Wilk extends Zwierze {
    public Wilk(Swiat swiat, int x, int y)
    {
        this.setSila__(9);
        this.setInicjatywa__(5);
        this.setX__(x);
        this.setY__(y);
        this.setSwiat__(swiat);
    }

    @Override
    protected Zwierze rozmnazanie(Organizm rodzic, int x, int y) {
        return new Wilk(rodzic.getSwiat__(), x, y);
    }

    @Override
    public JButton rysowanie() {
        JButton temp = new JButton("Wilk");
        temp.setBackground(Color.darkGray);
        return temp;
    }
}
