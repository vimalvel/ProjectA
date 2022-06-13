package com.chainsys.springproject.beans;

public class LunchFactory {
    public Lunch createNonvegSouthIndianLunch() {
        Starters s1 = new Chicken();
        s1.name = "Honeychicken";
        Maincourse m = new SouthIndian();
        m.name = "Rice";

        Desert d = new Cakes();
        d.name = "ChocoBrownie";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }

    public Lunch createVegSouthIndianLunch() {
        Starters s1 = new Vegroll();
        s1.name = "Cabbageroll";
        Maincourse m = new SouthIndian();
        m.name = "Rice";
        Desert d = new Icecream();
        d.name = "Falooda";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }

    public Lunch createNorthIndianLunch() {
        Starters s1 = new Soup();
        s1.name = "Sweetcorn";
        Maincourse m = new NorthIndian();
        m.name = "Chappatti";
        Desert d = new Sweets();
        d.name = "Rasagulla";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }

    public Lunch createChineseIndianLunch() {
        Starters s1 = new Vegroll();
        s1.name = "Springroll";
        Maincourse m = new Chinese();
        m.name = "Noodles";
        Desert d = new Icecream();
        d.name = "Snake";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }
}