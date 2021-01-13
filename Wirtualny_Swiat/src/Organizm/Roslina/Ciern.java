package Organizm.Roslina;

import Swiat.Swiat;

public class Ciern extends Roslina {

    public Ciern(Swiat swiat, int x, int y) {
        setSila(2);
    }

    @Override
    public void akcja() {
        System.out.println("SILA:" + getSila());
        System.out.println("INICJATYWA:" + getInicjatywa());
    }
}
