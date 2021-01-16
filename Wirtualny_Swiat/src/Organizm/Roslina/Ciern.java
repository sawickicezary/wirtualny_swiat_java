package Organizm.Roslina;

import Organizm.Organizm;
import Swiat.Swiat;

public class Ciern extends Roslina {

    public Ciern(Swiat swiat, int x, int y) {
        setSila__(2);
        setX__(x);
        setY__(y);
        setSwiat__(swiat);
        }

    @Override
    protected void rozprzestrzenianie(Roslina rodzic, int x, int y) {
        try{
            getSwiat__().dodajOrganizm(new Ciern(rodzic.getSwiat__(), x, y));
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public void rysowanie() {
        System.out.print('3');
    }

    @Override
    public boolean reakcja(Organizm przeciwnik) {
        return true;
    }
}
