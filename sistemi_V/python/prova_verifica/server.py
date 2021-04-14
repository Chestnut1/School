"""

Author: Bruno Luca
Date: 13-04-2021

CALCOLO DISTRIBUITO 2

"""

import sqlite3
from typing import Mapping
from flask import Flask, json,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests
from flask import request

app = Flask(__name__)

@app.route("/")
def index():
    return("pagina principale")

@app.route("/getop")
def get_an_operations():
    ip = request.args["ip"]     #prendo l'ip dalla GET
    
    print(ip)

    #controllo se l'ip può ricevere l'operazione
    with sqlite3.connect("static/operations.db") as conn:
        cursor = conn.cursor()

        #seleziono gli di consentiti
        cursor.execute(f"SELECT client.ip FROM client WHERE client.ip = '{ip}'")
        permission = cursor.fetchall()

        print(permission)

        if permission:
            
            cursor.execute(f"SELECT id,espressione FROM operazioni WHERE calcolata = 0")
            operation = list(cursor.fetchone())

            print(operation)

            if len(operation) == 0:
                return jsonify({"err" : "no more operation left"})
            else:
                return jsonify({"id" : operation[0], "espression" : operation[1]})
        
        
        return jsonify({"err" : "ip access denied"})
            

@app.route("/setresult")
def set_a_result():
    result = request.args["result"]     #prendo l'ip dalla GET
    op_id = request.args["op_id"]

    print(result)
    print(op_id)

    #controllo se l'ip può ricevere l'operazione
    with sqlite3.connect("static/operations.db") as conn:
        cursor = conn.cursor()

        #aggiorno lo stato dell'operazioe ad eseguita
        cursor.execute(f"UPDATE operazioni SET calcolata = 1 WHERE id = {op_id}")
        cursor.fetchall()

        #aggiungo il risultato alla tabella
        cursor.execute(f"UPDATE operazioni SET calcolata = 1 WHERE id = {op_id}")
        cursor.fetchall(f"INSERT INTO risultati (risultato, id_esp) values ({result},{op_id})")

    

if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)