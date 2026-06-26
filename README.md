# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information

| Field      | Isi                                      |
|------------|------------------------------------------|
| Name       | Sawega Fatchur Rachman                   |
| Student ID | 5026251202                               |
| Class      | A                                        |

---

## Project Description

Aplikasi permainan Tic-Tac-Toe berbasis Java Swing dengan fitur login menggunakan database PostgreSQL, pencatatan statistik per pemain, dan tampilan Top 5 Scorers. Pemain berlomba melawan komputer yang menggunakan algoritma **random** untuk menentukan langkah terbaik.

---

## Features

- Login menggunakan data dari database (username & password)
- Papan Tic-Tac-Toe interaktif berbasis JButton 3x3
- Komputer menggunakan algoritma random
- Deteksi otomatis: menang, kalah, dan seri
- Statistik (wins, losses, draws, score) tersimpan di database setelah setiap game
- Halaman Statistik Pribadi yang diambil langsung dari database
- Halaman Top 5 Scorers menggunakan JTable

---

## Score Calculation

| Hasil  | Tambahan Skor |
|--------|---------------|
| Menang | +10 poin      |
| Seri   | +3 poin       |
| Kalah  | +0 poin       |

---

## Database

**DBMS:** PostgreSQL  
**Nama Database:** `game_project`  
**Jumlah Tabel:** 1 (tabel `players`)

### Skema Tabel `players`

| Kolom    | Tipe         | Keterangan          |
|----------|--------------|---------------------|
| id       | SERIAL (PK)  | ID unik pemain          |
| username | VARCHAR(50)  | Username pemain (UNIQUE) |
| password | VARCHAR(100) | Password pemain           |
| wins     | INT          | Jumlah kemenangan   |
| losses   | INT          | Jumlah kekalahan    |
| draws    | INT          | Jumlah seri         |
| score    | INT          | Total skor          |

---

## How to Run

### 1. Siapkan Database
- Buka pgAdmin → buat database `game_project`
- Buka Query Tool → jalankan `database/schema_postgresql.sql`

### 2. Tambahkan PostgreSQL JDBC Driver
- Download di: https://jdbc.postgresql.org/download/
- Di VSCode: File → Project Structure → Libraries → + → Java → pilih file .jar

### 3. Konfigurasi DatabaseManager.java
```java
private static final String URL      = "jdbc:postgresql://localhost:5433/game_project";
private static final String USER     = "________"; isi user
private static final String PASSWORD = "________"; isi Password
```

### 4. Jalankan
- Run `Main.java`
- Login: `player1` / `12345`

---

## Class Explanation

| Class             | Tanggung Jawab                                              |
|-------------------|-------------------------------------------------------------|
| Main              | Entry point, membuka LoginFrame                            |
| DatabaseManager   | Menyediakan koneksi JDBC ke PostgreSQL                     |
| Player            | Model data pemain (id, username, statistik)                |
| PlayerService     | Operasi database: login, update statistik, Top 5           |
| GameLogic         | Logika board: validasi move, cek menang/seri, bot random   |
| LoginFrame        | Window login                                               |
| MainMenuFrame     | Window navigasi utama setelah login                        |
| GameFrame         | Window permainan Tic-Tac-Toe interaktif                    |
| StatisticsFrame   | Window statistik pribadi pemain                            |
| TopScorersFrame   | Window Top 5 Scorers menggunakan JTable                    |

---

## Screenshots

### Login
| Form Login | Login Berhasil | Login Gagal |
|:---:|:---:|:---:|
| <img width="217" height="143" alt="image" src="https://github.com/user-attachments/assets/b4986bd9-d2c1-4153-b7c0-900e59ab11ca" /> | <img width="217" height="143" alt="image" src="https://github.com/user-attachments/assets/92a3655f-f0e2-457c-ab67-1326f2048369" /> | <img width="213" height="141" alt="image" src="https://github.com/user-attachments/assets/12dabab2-f9fb-4c13-9a6c-2df3400a5cf9" /> |

### Main Menu & Game
| Main Menu | Mulai Game |
|:---:|:---:|
| <img width="288" height="292" alt="image" src="https://github.com/user-attachments/assets/6df50a0e-97a7-46af-8d41-78a6a67e1db8" /> | <img width="288" height="292" alt="image" src="https://github.com/user-attachments/assets/4d4b2f06-fcaf-4358-9ad9-ba776579ea93" /> |

### Kondisi Game
| Menang | Kalah | Draw |
|:---:|:---:|:---:|
| <img width="577" height="580" alt="image" src="https://github.com/user-attachments/assets/053b7cdb-8310-4775-8c33-b470ebf612fa" /> | <img width="570" height="582" alt="image" src="https://github.com/user-attachments/assets/571ecc92-cc29-42dc-a6ff-238948fb59b3" /> | <img width="570" height="582" alt="image" src="https://github.com/user-attachments/assets/0e97612c-9565-4229-b110-27b6da69ca0f" /> |

### Statistik & Leaderboard
| Statistik | Leaderboard |
|:---:|:---:|
| <img width="212" height="215" alt="image" src="https://github.com/user-attachments/assets/2ab628f0-529b-4652-9ece-5e69f15781c4" /> | <img width="290" height="218" alt="image" src="https://github.com/user-attachments/assets/10881d4e-aad9-4c4d-9d71-fdb7de05a79b" /> |

---

## Video Link
YouTube: [_(link video)_ ](https://youtu.be/7Zdj8c6x4M8)

## GitHub Link
Github: [_(link Github)_ ](https://github.com/Regaz12/TicTacToeFPPemdas_202
)
