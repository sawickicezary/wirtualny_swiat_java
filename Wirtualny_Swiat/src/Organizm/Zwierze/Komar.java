package Organizm.Zwierze;

import Organizm.Organizm;
import Swiat.Swiat;

public class Komar extends Zwierze {
    private int poprzedniX__;
    private int poprzedniY__;

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
    public boolean reakcja(Organizm przeciwnik) {
        if (przeciwnik.getSila__() > this.getSila__()){
            int losowaLiczba = (int) (Math.random() * 2);
            if (losowaLiczba == 0){
                if(getSwiat__().coStoi(poprzedniX__,poprzedniY__) == null) {
                    this.setX__(poprzedniX__);
                    this.setY__(poprzedniY__);
                }
            }
        }
        return super.reakcja(przeciwnik);
    }

    @Override
    public void rysowanie() {
        System.out.print('$');
    }

    @Override
    protected Zwierze rozmnazanie(Organizm rodzic, int x, int y) {
        return new Komar(rodzic.getSwiat__(), x,y);
    }

    @Override
    public void akcja() {
        int sasiadujaceKomary = 0;
        for (int i = -1; i < 2; i++)
            for (int j = -1; j<2;j++){
                if (i != 0 && j!= 0 || (i==0 && j==0))
                    continue;
                Organizm sasiad = getSwiat__().coStoi(getX__() + i, getY__() +j);
                if (sasiad == null)
                    continue;
                if(sasiad.getClass() == this.getClass())
                    sasiadujaceKomary++;
            }
        this.setSila__(1+ sasiadujaceKomary);
        this.setInicjatywa__(1+ sasiadujaceKomary);
        this.poprzedniX__ = getX__();
        this.poprzedniY__ = getY__();
        super.akcja();
    }
}
