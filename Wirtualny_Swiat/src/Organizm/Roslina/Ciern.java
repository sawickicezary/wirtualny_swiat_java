package Organizm.Roslina;

import Swiat.Swiat;

public class Ciern extends Roslina {

    public Ciern(Swiat swiat, int x, int y) {
        setSila__(2);
    }

    @Override
    public void akcja() {
        System.out.println("SILA:" + getSila__());
        System.out.println("INICJATYWA:" + getInicjatywa__());
    }

    @Override
    public void rysowanie() {
        System.out.print('3');
    }
}
