import java.util.ArrayList;

/*tambah*/
public class Musuh extends Karakter{
    //Atribut
    GameInfo objGameInfo;


    //Construct
    public Musuh(String name){
        super(name);
    }

    //Method
    public ArrayList<String> getAksi() {
        ArrayList<String> arrayAksi = new ArrayList<>();
        arrayAksi.add("Status Musuh");
        arrayAksi.add("Serang Musuh");
        return(arrayAksi);
    }

    //method serang
    public void prosesAksi(int pilihan, Player pemain){
        if (pilihan==1){
            System.out.println(this.getName()+"\n"+     //menampilkan kesehatan musuh
            this.getHealth()+"\n");
        }else if (pilihan==2){
            if (pemain.cariItem("Pedang")){
                pemain.setAttack(50);
                System.out.println("menggunakan Pedang");
            }
            if (pemain.cariItem("Pisau")){
                pemain.setAttack(30);
                System.out.println("menggunakan Pisau");
            }
            pemain.serang(this);        //menyerang musuh
            if (this.lawanMati()){
                System.out.println("Musuh Anda telah Mati!");
            }

        }
    }

    public boolean lawanMati(){
        boolean mati = false;
        if (this.getHealth()<=0){
            mati=true;
        }
        return mati;
    }

    public GameInfo getObjGameInfo() {
        return this.objGameInfo;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

}

