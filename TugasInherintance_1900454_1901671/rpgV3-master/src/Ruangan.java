import java.util.ArrayList;
import java.util.Scanner;

// import static java.lang.String.format;

public class Ruangan {

    private Pintu objPintu;
    private NPC objNPC;
    private Item  objRoti;
    private GameInfo objGameInfo;
    //tambah
    private Musuh objMusuh;

    private ArrayList<Item> arrItem = new ArrayList<>();

    //tambah/
    private String deskripsi;
    private boolean berhasil = true;
    private ActiveItem Pedang;
    private ActiveItem Pisau;
    private BuffItem obat;
    private BuffItem vitamin;
    private PassiveItem baju;
    private PassiveItem jaket;
    private PassiveItem topi;

    private Scanner sc = new Scanner(System.in);

    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        objMusuh.setObjGameInfo(objGameInfo);

        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    //construktor/
    public Ruangan() {
        // init ruangan
        // init pintu, kunci dan roti.
        objPintu = new Pintu();
        objNPC = new NPC();

        objRoti  = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        arrItem.add(objRoti);

        //tambah/
        objMusuh = new Musuh("Monster");

        Pedang = new ActiveItem("Pedang",50);
        Pedang.setDeskripsi("Senjata tajam panjang yang dipegang oleh kedua tangan");
        Pedang.setObjRuangan(this);
        arrItem.add(Pedang);

        Pisau = new ActiveItem("Pisau", 30);
        Pisau.setDeskripsi("Senjata tajam pendek yang dipegang oleh kedua tangan");
        Pisau.setObjRuangan(this);
        arrItem.add(Pisau);

        obat = new BuffItem("Obat Luka",50,0);
        obat.setDeskripsi("Obat Penambah Darah");
        obat.setObjRuangan(this);
        arrItem.add(obat);

        vitamin = new BuffItem("Vitamin Magic",50,50);
        vitamin.setDeskripsi("Vitamin Penambah Darah dan Penambah Sihir"); //bisa dibuat untuk attack tambahan serangan musuh
        vitamin.setObjRuangan(this);


        baju = new PassiveItem("Baju");
        jaket = new PassiveItem("Jaket");
        topi = new PassiveItem("Topi");

        arrItem.add(baju);
        arrItem.add(jaket);
        arrItem.add(topi);

        baju.setObjRuangan(this);
        baju.setDeskripsi("Baju Untuk Menutupi Tubuh dari Hujan dan Panas");
        jaket.setObjRuangan(this);
        baju.setDeskripsi("Jaket Untuk Menghangatkan Tubuh");
        topi.setObjRuangan(this);
        topi.setDeskripsi("Topi Untuk dipakai di Kepala");
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    public void pilihanAksi() {

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        //aksi2 item
        System.out.println("Item di ruangan");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        // aksi2 pintu
        urutPil++;
        subPil = 0;
        int pilPintu  = urutPil; //catat untuk pintu
        System.out.println("Pintu");
        for (String strPil:objPintu.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }

        // aksi2 NPC
        urutPil++;
        subPil = 0;
        int pilNPC  = urutPil; //catat untuk pintu
        System.out.println("NPC");
        for (String strPil:objNPC.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }

        //tambah/
        // aksi2 musuh
        urutPil++;
        subPil = 0;
        int pilMusuh  = urutPil; //catat untuk pintu
        System.out.println("Musuh");
        if(this.objMusuh.getHealth()==0) {
            System.out.println("Monster Telah Anda Kalahkan!");
            setBerhasil(isBerhasil());
        }
        else{
            for (String strPil:objMusuh.getAksi()) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        //tdk perlu if spt ini kalau sudah menggunakan inheritance
        if (pil ==pilPintu) {
            objPintu.prosesAksi(subPil);  //aksi pintu
        } else if (pil==pilNPC) {
            objNPC.prosesAksi(subPil);
        } else if (pil==pilMusuh){
            objMusuh.prosesAksi(subPil,objGameInfo.getObjPlayer());
        } else {
            //item
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }

    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public GameInfo getObjGameInfo() {
        return this.objGameInfo;
    }

    public boolean isBerhasil() {
        return berhasil;
    }

    public void setBerhasil(boolean berhasil) {
        this.berhasil = berhasil;
    }
}