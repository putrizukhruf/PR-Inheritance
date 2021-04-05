public class ActiveItem extends Item{

    //DEKLAR VARIABLE
    private double attack;

    //SETTER GETTER

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    //CONSTURTOR
    public ActiveItem(String nama, double attack){
        super(nama);
        this.attack = attack;
    }

    @Override
    public void diambil(){
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().setAttack(objGameInfo.getObjPlayer().getAttack()+this.attack);
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }
}
