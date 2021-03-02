"""

Author: Bruno Luca
Date: 28-02-2021

Pagina di controllo del semaforo
"""

from flask import Flask,render_template, redirect, request
from flask.helpers import url_for
import time
from datetime import datetime
import semaforo
import sqlite3


#creo il semaforo e lo imposto subito su attivo
s = semaforo.semaforo()
STATO = "ATTIVO"
STATO_PREC = STATO

app = Flask(__name__)

#tempi del semaforo inizializzato
tempoRosso = 2
tempoGiallo = 2
tempoVerde = 1

#pagina di controllo
@app.route("/")
def control_page():
    #stampo lo stato iniziale
    test()
    #renderizzo la pagina di controllo del semaforo
    return render_template("settings.html")
    

@app.route("/", methods = ["GET","POST"])
def cambiaTempo():

    """
    Questa funzione viene chiamata quando viene cliccato il pulsante "Send". 
    Prendo dalla pagina web i nuovi valori del tempo e li imposto sul semaforo.
    """

    global tempoRosso, tempoGiallo, tempoVerde, STATO, STATO_PREC
    
    if request.method == "POST":
        #prendo i dati inseriti dall'utente
        tempoRosso = int(request.form["tRosso"])
        tempoGiallo = int(request.form["tGiallo"])
        tempoVerde = int(request.form["tVerde"])
        STATO = request.form["stato"].upper()

        #controllo lo stato dell'input
        input_corretto = controllo_input(tempoRosso, tempoGiallo, tempoVerde, STATO)  #controlla se sono dei numeri e non altro

        #se cambia lo stato registro il cambiamento sul db
        if STATO != STATO_PREC:
            with sqlite3.connect("static/operations.db") as conn:   #connessione al DB
                cursor = conn.cursor()  #creo un cursore

                #inserisco i nuovi tempi dentro il db
                cursor.execute(f"INSERT INTO op (time) VALUES('{datetime.now()}');")
                corrispondance = cursor.fetchall()

            STATO_PREC = STATO  #aggiorno lo stato

        if input_corretto:
            #stampo il test e ritorno alla pagina di controllo
            test()
            return render_template("settings.html")
        else:
            error  = "Invalid Credentials. Please try again."   #stay in the login page and say wrong credentials
        
        #stampo il test e ritorno alla pagina di controllo
        test()
        return render_template("settings.html", error = error)

def controllo_input(tempoRosso, tempoGiallo, tempoVerde, STATO):   
    
    """
    Funzione che controlla se i dati inseriti dall'utente sono corretti o meno

    (Se non è presente alcun controllo vuol dire che non sono riuscito ad implementarlo in tempo)
    """
    return True

def test():
    
    """
    Funzine che esegue un test del semaforo quando viene chiamata. 
    Le informazioni vengono loggate a terminale.
    """
    #controllo lo stato del semaforo
    if STATO == "ATTIVO":   
        global tempoRosso, tempoGiallo, tempoVerde
        s.rosso(tempoRosso)
        s.verde(tempoGiallo)
        s.giallo(tempoVerde)
    else:
        #triplo lampeggio giallo, con luci spente finali
        for _ in range(3):
            s.giallo(tempoGiallo)
            s.luci_spente(1)

if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)