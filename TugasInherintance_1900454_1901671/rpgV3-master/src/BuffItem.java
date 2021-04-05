public class BuffItem extends Item{

    private double noHP;
    private double energiSihir;

    //CONSTUCTOR
    public BuffItem(String nama, double HP, double sihir){
        super(nama);
        this.noHP = HP;
        this.energiSihir = sihir;
    }

    @Override
    public void diambil(){
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().setHealth(objGameInfo.getObjPlayer().getHealth()+this.noHP);
        objGameInfo.getObjPlayer().setMagic(objGameInfo.getObjPlayer().getMagic()+this.energiSihir);
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }

    //SETTER GETTER
    public double getNoHP() {
        return noHP;
    }

    public void setNoHP(double noHP) {
        this.noHP = noHP;
    }

    public double getEnergiSihir() {
        return energiSihir;
    }

    public void setEnergiSihir(double energiSihir) {
        this.energiSihir = energiSihir;
    }


}