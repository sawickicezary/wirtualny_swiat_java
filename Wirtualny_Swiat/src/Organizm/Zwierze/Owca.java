package Organizm.Zwierze;

import Swiat.Swiat;

public class Owca extends Zwierze {
    public Owca(Swiat swiat, int x, int y)
    {
        this.setSila__(4);
        this.setInicjatywa__(4);
        this.setX__(x);
        this.setY__(y);
        this.setSwiat__(swiat);
    }

    @Override
    protected Zwierze rozmnazanie(int x, int y) {
        return null;
    }

    @Override
    public void rysowanie() {
        System.out.print('#');
    }
}
