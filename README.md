# PAPB-Team-6
Repository untuk pengerjaan tugas Pengembangan Aplikasi Piranti Bergerak Team 6

Berikut merupakan file readme dari kelompok 6 PAPB

## Cara Menjalankan Aplikasi
```
git clone https://github.com/Arifwsno/PAPB-Team-6.git
```

### Ide
Menampilkan list makanan atau minuman dan cara membuatnya

### Latar Belakang
Banyak orang, khususnya pada masa pandemi ini, mereka menginginkan membuat makanan mereka sendiri baik itu untuk hobi, ingin hidup yang lebih sehat atau ingin memulai bisnis
mereka

## Tujuan
Menampilkan tahapan cara membuat makanan atau minuman yang diinginkan

## Konsep
Aplikasi merupakan aplikasi native android yang menggunakan bahasa kotlin sebagai backend dan [API](https://www.themealdb.com/api.php) makanan dan cara membuatnya. Frontend aplikasi menggunakan 1 activity dengan 3 fragment yang terpasang.

### Fragment tersebut terdiri dari :
- Home (Menampilkan Category) --> Terdiri dari Recycle View bernama "place_card"
- Menu (Menampilkan makanan sesuai kategori) --> Terdiri dari Recycle View bernama "food_card"
- Detail (Menampilkan cara membuat makanan) --> Terdiri dari gambar dan deskripsi cara membuatnya

### Recycle View tersebut terdiri dari :
- place_card --> Terdiri dari gambar dan nama category
- food_card --> Terdiri dari gambar dan nama makanan

### Flow
Aplikasi menampilkan **Home** > user memilih category > Aplikasi menampilkan **Menu** > user memilih makanan > Aplikasi menampilkan **Detail**

### Batasan Aplikasi
- Aplikasi tidak memberikan list alat dan bahan
- Gambar pada aplikasi kemungkinan memiliki ratio yang tidak normal (stretched / squashed)
- Tidak adanya fitur login

## Fitur
### Home
  - Menampilkan List Gambar kategori makanan
  - Menampilkan List Kategori makanan

### Menu
  - Menampilkan List Gambar makanan
  - Menampilkan List Nama makanan

### Food Detail
  - Menampilkan Gambar
  - Menampilkan Informasi :
    - Nama
    - Detail Isi
    - Cara Memasak

## Lifecycle

onCreate(), merupakan lifecycle yang terjadi ketika activity atau fragmen dibuat dan ditampilkan. Pada aplikasi ini semua activity dan fragment terdapat lifecycle ini
onResume(), merupakan lifecycle yang yang dieksekusi setelah activity atau fragmen mengalami lifecycle onPause() atau setelah mengalami lifecycle onStart(). Skenario override pada lifecycle ini adalah ketika membuka aplikasi ini, maka pada halaman ini akan memuat data vocabulary dan kbbi. Lalu ketika membuka menu lain atau membuka activity lain, setelah kembali ke menu home akan memuat ulang dan mengganti data vocabulary dan kbbi yang ditampilkan. Update tersebut juga terjadi ketika pengguna keluar dari aplikasi sementara kemudian kembali lagi
onDestroy(), merupakan lifecycle ketika fragmen atau activity dihancurkan dari memori. Skenario override pada lifecycle ini adalah ketika activity DetailBiografi dihancurkan maka akan keluar Toast yang bertuliskan "Jangan lupa kunjungi sosial media kami"

### Terdapat 2 lifecycle yaitu, lifecycle Activities dan Fragment
#### Activities
1. onCreate(): lifecycle pertama yaitu ketika suatu Activities dijalankan oleh aplikasi, Activities tersebut yaitu MainActivity yang merupakan layout utama dari aplikasi

#### Fragment
2. onAttach(): lifecycle pertama fragment saat fragment dijalankan, yaitu meng-attach/memasangkan fragment ke MainActivity
3. onCreateView(): dimana proses binding dijalankan dan menginflate view
4. onViewCreated(): lifecycle yang dimana view setup dijalankan, adapter menampilkan value ke recycle view pada fragment, value tersebut diambil dari view-model
5. onPause(): lifecycle dimana sebuah fragment ditahan prosesnya karena fragment lainnya sedang dijalankan
6. onResume(): lifecycle dimana sebuah fragment yang ditahan prosesnya atau sedang dalam lifecycle onPause(), dijalankan kembali karena suatu event

#### Activities
7. onDestroy(): lifecycle ketika aplikasi di tutup dan diberhentikan prosesnya.


## Arsitektur
Arsitektur yang dipilih adalah Clean Architecture
Kami memilih arsitektur ini karena:
1. Melatih tim untuk mengimplementasikan arsitektur yang kompleks dimana arsitektur ini mengimplementasiakn SOLID PRINCIPAL
2. Arsitektur digunakan oleh perusahaan-perusahaan besar, maka proyek ini akan menjadi pengalaman yang sangat berguna
3. Penambahan fitur pada aplikasi akan sangat mudah dengan tidak memodifikasi file lainnya
4. Flow data yang jelas dan fungsi setiap class sangat spesifik
5. Maintanance aplikasi yang mudah dilakukan

Komponen **Data** merupakan seluruh fungsi yang mengambil data dari API, Room Database, dan repository data. **APP / Presentation** merupakan seluruh tampilan atau frontend dari aplikasi serta view model yang dihubungkan dari use case, UI komponen terdiri dari recycle view dan dihubungkan oleh adapter. **Domain** merupakan jembatan serta logic yang menghubungkan antara data dan presentation, layer ini terdiri dari use case, data mapper. Use case merupakan komponen yang menampilkan value yang diambil dari repository, lalu disalurkan ke layer presentation, kemudian data mapper digunakan untuk mengalokasikan data dari layer **data** ke **domain** serta dari **data** ke **table ROOM Database** jika user menjalankan fungsi favourite. 

Anggota Tim
- Arif Wicaksono 18/429056/TK/47558
- Nafisah Faza Qinthari 18/429080/TK/47582
- Adam Arga Fikri 18/429049/TK/47551
