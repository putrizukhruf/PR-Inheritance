public class PassiveItem extends Item{


    //CONSTUCTOR
    public PassiveItem(String nama){
        super(nama);
    }

    public void diambil(){
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }


}
