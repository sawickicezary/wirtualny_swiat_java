package Organizm.Zwierze;

import Swiat.Swiat;

public class Komar extends Zwierze {
    public Komar(Swiat swiat, int x, int y)
    {
        int poprzedniX = x;
        int poprzedniY = y;
        this.setSila__(1);
        this.setInicjatywa__(1);
        this.setX__(x);
        this.setY__(y);
        this.setSwiat__(swiat);
    }

    @Override
    public void rysowanie() {
        System.out.print('$');
    }

    @Override
    public void akcja() {

        super.akcja();
    }
}
