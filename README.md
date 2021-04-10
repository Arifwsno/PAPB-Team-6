# PAPB-Team-6
Repository untuk pengerjaan tugas Pengembangan Aplikasi Piranti Bergerak Team 6

Berikut merupakan file readme dari kelompok 6 PAPB

## Ide
List Cara Membuat suatu Makanan atau Minuman

## Latar Belakang
Banyak orang, khususnya pada masa pandemi ini, mereka menginginkan membuat makanan mereka sendiri baik itu untuk hobi, ingin hidup yang lebih sehat atau ingin memulai bisnis
mereka

## Tujuan
Menampilkan tahapan cara membuat makanan atau minuman yang diinginkan

## Konsep
Aplikasi merupakan aplikasi native android yang menggunakan bahasa kotlin sebagai backend. Frontend aplikasi menggunakan 1 activity dengan 3 fragment yang terpasang.

### Fragment tersebut terdiri dari :
- Home (Menampilkan Category) --> Terdiri dari Recycle View bernama "place_card"
- Menu (Menampilkan makanan sesuai kategori) --> Terdiri dari Recycle View bernama "food_card"
- Detail (Menampilkan cara membuat makanan) --> Terdiri dari gambar dan deskripsi cara membuatnya

### Recycle View tersebut terdiri dari :
- place_card --> Terdiri dari gambar dan nama category
- food_card --> Terdiri dari gambar dan nama makanan/minuman

## Flow
Home > pilih category > Menu > pilih makanan > Detail

## Batasan Aplikasi
Aplikasi tidak memberikan list alat dan bahan
Gambar pada aplikasi kemungkinan memiliki ratio yang tidak normal (stretched / squashed)
Tidak adanya fitur login


## Fitur
### Home
  - List Gambar kategori makanan
  - List Kategori makanan

### Menu
  - List Gambar makanan
  - List Nama makanan

### Food Detail
  - Gambar
  - Informasi :
    - Nama
    - Detail Isi
    - Cara Memasak

## Lifecycle


## Arsitektur
Arsitektur yang dipilih adalah Model-ViewModel-Model (MVVM)
Kami memilih arsitektur ini karena:
1. Arsitektur ini paling banyak dipakai di kalangan developer android
2. Arsitektur ini memiliki banyak turtorial di internet
3. Arsitektur ini memiliki struktur yang mudah dimengerti

Arsitektur MVVM sudah kami masukan/kategorikan dengan file-file penamaan sendiri-sendiri, folder dengan nama **View** adalah bagan view, folder dengan nama **ViewModel** adalah bagan viewmodel, folder dengan nama **Model** merupakan bagan model dari aplikasi.
