package Organizm.Zwierze;

import Swiat.Swiat;

public class Zolw extends Zwierze {
    public Zolw(Swiat swiat, int x, int y)
    {
        this.setSila(2);
        this.setInicjatywa(1);
        this.setX(x);
        this.setY(y);
        this.setSwiat(swiat);
    }

    @Override
    public void akcja() {
        System.out.println("Jestem żółwiem!");
    }
}
