# PAPB-Team-6
Repository untuk pengerjaan tugas Pengembangan Aplikasi Piranti Bergerak Team 6

Berikut merupakan file readme dari kelompok 6 PAPB

### Cara Menjalankan Aplikasi
```
git clone https://github.com/Arifwsno/PAPB-Team-6.git
```

### Ide
Menampilkan list makanan atau minuman dan cara membuatnya

### Latar Belakang
Banyak orang, khususnya pada masa pandemi ini, mereka menginginkan membuat makanan mereka sendiri baik itu untuk hobi, ingin hidup yang lebih sehat atau ingin memulai bisnis
mereka

### Tujuan
Menampilkan tahapan cara membuat makanan atau minuman yang diinginkan

### Konsep
Aplikasi merupakan aplikasi native android yang menggunakan bahasa kotlin sebagai backend dan [API](https://www.themealdb.com/api.php) makanan dan cara membuatnya. Frontend aplikasi menggunakan 1 activity dengan 3 fragment yang terpasang.

#### Fragment tersebut terdiri dari :
- Home (Menampilkan Category) --> Terdiri dari Recycle View bernama "place_card"
- Menu (Menampilkan makanan sesuai kategori) --> Terdiri dari Recycle View bernama "food_card"
- Detail (Menampilkan cara membuat makanan) --> Terdiri dari gambar dan deskripsi cara membuatnya

#### Recycle View tersebut terdiri dari :
- place_card --> Terdiri dari gambar dan nama category
- food_card --> Terdiri dari gambar dan nama makanan

### Flow
Aplikasi menampilkan **Home** > user memilih category > Aplikasi menampilkan **Menu** > user memilih makanan > Aplikasi menampilkan **Detail**

### Batasan Aplikasi
Aplikasi tidak memberikan list alat dan bahan
Gambar pada aplikasi kemungkinan memiliki ratio yang tidak normal (stretched / squashed)
Tidak adanya fitur login

### Fitur
#### Home
  - Menampilkan List Gambar kategori makanan
  - Menampilkan List Kategori makanan

#### Menu
  - Menampilkan List Gambar makanan
  - Menampilkan List Nama makanan

#### Food Detail
  - Menampilkan Gambar
  - Menampilkan Informasi :
    - Nama
    - Detail Isi
    - Cara Memasak

### Lifecycle
Terdapat 2 lifecycle yaitu, lifecycle Activities dan Fragment
Activities
1. onCreate(): 

Fragment
2. onAttach():
3. onCreateView():
4. onViewCreated():


### Arsitektur
Arsitektur yang dipilih adalah Model-ViewModel-Model (MVVM)
Kami memilih arsitektur ini karena:
1. Arsitektur ini paling banyak dipakai di kalangan developer android
2. Arsitektur ini memiliki banyak turtorial di internet
3. Arsitektur ini memiliki struktur yang mudah dimengerti

Arsitektur MVVM sudah kami masukan/kategorikan dengan file-file penamaan sendiri-sendiri, folder dengan nama **View** adalah bagan view, folder dengan nama **ViewModel** adalah bagan viewmodel, folder dengan nama **Model** merupakan bagan model dari aplikasi.
