"""

    SERVER ALPHABOT

"""


import sqlite3
from flask import Flask, json,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests
from flask import request

app = Flask(__name__)

@app.route("/percorsi", methods = ['GET'])
def get_path():
    global precDX, precSX, currDX, currSX
    start = request.args["start"]
    end = request.args["end"]

    print(f"{start}\n{end}")
    if request.method == "GET":
        
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

            return jsonify(paths)

            
            """
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
        
            """

def obstacles():
    with sqlite3.connect("static/percorsi.db") as conn:
        cursor = conn.cursor()

        cursor.execute(f"INSERTO INTO ostacoli (sensoreSX,sensoreDX, posizioneOstacolo) values ({currSX},{currDX},'{statoOstacolo}')")  

if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)

