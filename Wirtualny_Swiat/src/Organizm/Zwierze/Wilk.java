package Organizm.Zwierze;

import Swiat.Swiat;

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
    public void rysowanie() {
        System.out.print('@');
    }
}
