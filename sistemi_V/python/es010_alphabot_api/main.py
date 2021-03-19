"""

Author: Bruno Luca
Date: 26-01-2021

"""

import sqlite3
from typing import ByteString
from flask import Flask,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests
import datetime

app = Flask(__name__)

@app.route("/")
def control_page():
    print("dentro control page")
    return render_template("index.html")


#variabili di stato dell'ostacolo resettate
precSX = 0  #stato precedente sensore sinistro
precDX = 0  #stato precedente sensore destro 
currSX = 0  #stato attuale sensore sinistro
currDX = 0  #stato attuale sensore destro

@app.route("/", methods = ['GET','POST'])
def get_path():
    global precDX, precSX, currDX, currSX
    start = request.form['start']
    end = request.form['end']
    if request.method == "POST":
        
        with sqlite3.connect("static/percorsi.db") as conn:
            cursor = conn.cursor()

            cursor.execute(f"SELECT id FROM luoghi WHERE luoghi.nome = '{start}' OR  luoghi.nome = '{end}' ")
            ids = list(cursor.fetchall())
            print(ids)


            cursor.execute(f"SELECT percorso FROM percorsi, inzio_fine WHERE inzio_fine.id_start = {int(ids[0][0])} AND inzio_fine.id_end = {int(ids[1][0])} AND percorsi.id = inzio_fine.id_percorso ")

            percorsi = cursor.fetchall()

            paths = []

            for percorso in percorsi[0]:
                paths.append({"id" : percorsi[0].index(percorso), "path" : percorso})
                print(paths)

            

            #controllo sugli ostacoli
            for i in range(20):
                
                #pin dei sensori
                irDX = 16
                irSX = 19

                #setting dei sensori
                GPIO.setmode(GPIO.BCM)
                GPIO.setwarnings(False)
                GPIO.setup(DR,GPIO.IN,GPIO.PUD_UP)
                GPIO.setup(DL,GPIO.IN,GPIO.PUD_UP)

                #leggo lo stato attuale dei sensori
                currDX = GPIO.input(irDX)   #0 - 1
                currSX = GPIO.input(irSX)

                #controllo se ci sono stati dei cambiamenti
                if currDX != precDX or currSX != precSX:
                    if not currDX and not currSX:
                        stato = "SCOMPARSO"
                    elif currSX and not currDX:
                        statoOstacolo = "SINISTRA"
                    elif not currSX and currDX:
                        statoOstacolo = "DESTRA"
                        
                    elif currSX and currDX:
                        statoOstacolo = "CENTRO"


                cursor.execute(f"INSERTO INTO ostacoli (sensoreSX,sensoreDX, posizioneOstacolo) values ({currSX},{currDX},'{statoOstacolo}')")        
                        

                time.sleep(500)
        
            return jsonify(paths)


if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)