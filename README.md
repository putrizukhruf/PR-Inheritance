# PR-Inheritance
Modifikasi Game RPG

## Kelompok :
    - Mushfani Ainul Urwah (1901671)
    - Putri Zukhruf Dinata (1900454)

## Inherintance dan Pholimorpism
    Karakter (parent) :
    - musuh (child)
    - player (child)

    Item (parent) :
    - buffitem (child)
      objek : obat sm vitamin
    - activeitem (child)
      objek : pedang sama pisau
    - passiveitem (child)
      objek : baju, jaket, topi
      
    Pholimorpism :
    - objek seluruh item disimpan di ruangan

## Tambahan
    - menambahkan init musuh, pedang, pisau, obat, vitamin -> di class Ruangan
    - menambah pilihan aksi musuh -> di class ruangan
    - pada class musuh ada arrayAksi, dan proses aksi yaitu menampilkan attack musuh dan menyerang musuh
    - jika player tidak menggunakan item maka attack musuh berkurang 10
    - jika player memilih item pedang attack musuh berkurang 50
    - jika player item pisau attack musuh berkurang 30
    - di objek vitamin menambahkan health dan magic pada karakter
    - menambahkan override pada class BuffItem dan ActiveItem


                        
