Proiect Java:

  Roluri:
    Anonymous
    Administrator
    Autheticated

  Comenzi:
    help - returneaza comenzile disponibile pentru tipul de rol
    login username parola - logheaza utilizatorul anonim
    logout - delogheaza utilizatorul autentificat
    register username parola - inregistreaza un utilizator
    create song "nume" "autor" anLansare - creeaza o melodie
    create playlist "nume" - creeaza un playlist
    reset - reseteaza baza de date
    read - citeste melodiile din fisierul .csv
    promote - promoveaza un utilizator in admin
    add byname "numePlaylist" [id_melodie] - adauga in playlist o melodie sau o lista de melodii
    add byid idPlaylist [id_melodie] - adauga in playlist o melodie sau o lista de melodii
    list playlists - afiseaza toate playlist-urile pe ecran paginat(iti poti alege cate playlist uri sa fie afisate pe pagina)
    export playlist "numePlaylist" - afiseaza toate melodiile dintr-un playlist intr-un fisier json
    search "criteriuCautare" "criteriu" - afiseaza paginat toate melodiile in functie de criteriul de cautare ex: search author "James Brown"
    audit username - afiseaza paginat toate comenzile utilizate de utilizatorul cu username-ul specific

  Specificatii:
    Aplicatia foloseste o baza de date postgreSQL, unde stocheaza toate obiectele create(utilizatori, melodii, playlist-uri), astfel incat dupa oprirea rularii aplicatiei
  aceasta isi face un backup la inceput si rememoreaza toate datele date anterior.
