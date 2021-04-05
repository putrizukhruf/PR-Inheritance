import java.util.ArrayList;

public class Karakter {
    //Attribute
    private String name;
    private double attack;
    private double health;
    //private double magic=0;
    private  ArrayList<String> arrAksi = new ArrayList<>();

    private boolean isBerhasil = false;
    //Constructor
    public Karakter(String name){
        this.name = name;
        this.attack = 10;
        this.health = 100;
    }

    //Method
    public void serang(Karakter target){
        double total = target.health - this.attack;
        target.setHealth(total);
        System.out.println(this.name+" menyerang "+target.name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAttack() {
        return this.attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public ArrayList<String> getAksi() {
        return arrAksi;
    }

    public void setArrAksi(ArrayList<String> arrAksi) {
        this.arrAksi = arrAksi;
    }

    public boolean isBerhasil() {
        return isBerhasil;
    }

    public void setBerhasil(boolean berhasil) {
        isBerhasil = berhasil;
    }
}
