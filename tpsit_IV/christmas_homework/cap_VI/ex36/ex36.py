def introduction():
    print("""
    8:11 di mercoledì. Fuori fa freddo, si gela.
    Hai perso il bus, sei in ritardo di un minuto e ben 27 secondi. 
    Corri a perdifiato nei corridoi fregandotene altamente dei richiami delle bidelle.
    Arrivi davanti alla porta. Ti fermi e la guardi.
    Fai un respiro profondo e azioni la maniglia della porta. Un cigolio di vecchio e ruggine rimbomba nel corridoio. 
    Una luce passa attraverso la fessura della porta. Senti la spiegazione già iniziata interrompersi. Ti fai coraggio ed entri.
    La vedi. In piedi davanti a te. La bocca è spalancata e ti divora con lo sguardo mentre la sua testa elabora una frase ad effetto...
    devi trovare trovare qualcosa da dire prima che lei possa dire qualsiasi cosa.
    Cosa scegli?
    --------------------------------------------------------------------------------------------------------------------------------------
    """)

    choose = input(f"""
    a) "Buongiorno, scusi il ritardo ma ho perso il bus"
    b) "Scusi il ritardo"
    c) "Non dici nulla e ti dirigi verso il tuo posto in Agbonson style"
    """)

    if choose == 'a':
        print("BIG P> Sarebbe sempre meglio arrivare in orario... comunque, hai la giustifica?")
    elif choose == 'b':
        print("BIG G> Per prima cosa sarebbe meglio salutare l'insegante... come mai sei in ritardo?")
        late = input("""
        Come motivi il tuo ritardo?
        e) "Ho perso il bus..."
        f) "Non ha suonato la sveglia."
        g) "Sono rimasto sveglio fino alle 3 per fare i compiti di informatica..."
        """)
        if late == 'e':
            print("BIG P> Va bene.. la prossima volta cerca di non perderlo.")
        elif late == 'f':
            print("BIG P> Dalla sua faccia percepisci un lieve senso di incazzatura. Ti fa segno di sederti a posto, e tu esegui.")
        elif late == 'g':
            print("""BIG P> Stai quindi insinuando che la mia materia è meno importante di altre?
            Sono stufa del vostro comportamento menefreghista...

            |la ramanzina va anati per altri 20 minuti, durante i quali ti si calcificano le ginocchia a forza di stare in piedi. |
            |Al termine sei stremato e decidi quindi di fare la faccia seria per poter finalmente tornare al tuo posto.           |
            """)
    elif choose == 'c':
        print("""
        BIG P> EHHHHH SCUSA?! Ti sembra pre caso questo il comportamento da tenere quando si arriva in ritardo?? Senza nemmeno una spiegazione ed un saluto?
        """)
    

introduction()