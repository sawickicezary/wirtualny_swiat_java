package Organizm.Zwierze;

import Organizm.Organizm;
import Swiat.Swiat;

public class Zolw extends Zwierze {
    public Zolw(Swiat swiat, int x, int y)
    {
        this.setSila__(2);
        this.setInicjatywa__(1);
        this.setX__(x);
        this.setY__(y);
        this.setSwiat__(swiat);
    }

    @Override
    public void rysowanie() {
        System.out.print('!');
    }

    @Override
    public boolean reakcja(Organizm przeciwnik) {
        return !(przeciwnik.getSila__() < 5); // przeciwnik nie może wejśc na to pole(blokuje ruch)
    }
        @Override
    public void akcja() {
        int rand = (int) (Math.random() * 4);
        if (rand == 0)
            super.akcja();
    }
}
