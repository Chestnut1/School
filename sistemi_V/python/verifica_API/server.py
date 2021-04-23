"""

Author: Bruno Lua
Date: 20-04-2021

"""


from os import stat
import sqlite3
from sqlite3.dbapi2 import Cursor
from typing import Mapping
from flask import Flask, json,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests
from flask import request

app = Flask(__name__)

@app.route('/get_idgrandezza')
def get_grandezza():

    """
    dato un nome di una grandezza ne restituisce l'id
    """

    #prendo il nome della grandezza dall'URL
    nome_grandezza = request.args["nome"]

    #connesione al DB
    with sqlite3.connect("static/meteo.db") as conn:
        
        cursor = conn.cursor()

        #ricerco l'id
        cursor.execute(f"SELECT id_misura FROM grandezze WHERE grandezza_misurata = '{nome_grandezza}'")
        id_grandezza = cursor.fetchone()

        if id_grandezza == None:    #se la grandezza richiesta non è presente invio un comando di chiusura al client
            return(jsonify({"id" : -1}))

        return(jsonify({'id' : id_grandezza[0]}))

@app.route('/get_idstazione')
def get_stazione():

    """
    dato un nome di una stazione ne restituisce l'id
    """

    #prendo il nome della stazione dall'URL
    nome_stazione = request.args["nome"]

    #connesione al DB
    with sqlite3.connect("static/meteo.db") as conn:
        
        cursor = conn.cursor()

        #ricerco l'id
        cursor.execute(f"SELECT id_stazione FROM stazioni WHERE nome = '{nome_stazione}'")
        id_stazione = cursor.fetchone()

        if id_stazione == None:    #se la stazione richiesta non è presente invio un comando di chiusura al client
            return(jsonify({"id" : -1}))

        print(id_stazione)

        return(jsonify({'id' : id_stazione[0]}))

@app.route('/set_misurazione')   
def add_misurazione():
    
    """
    dati i valori di una misurazione (valore, id grandezza, id stazione e data) 
    inserisce una nuova misurazione nella tabella corrispettiva
    """

    #prendo valori dall'URL
    valore = request.args["valore"]
    id_grandezza = request.args["id_grandezza"]
    id_stazione = request.args["id_stazione"]
    data = request.args["data"]

    print(f"""
    
        INSERTING NEW MISURATION:
        value:          {valore}
        id_grandezza:   {id_grandezza}
        id_stazione:    {id_stazione}
        data:           {data}
    
    """)


    #connesione al DB
    with sqlite3.connect("static/meteo.db") as conn:
        
        cursor = conn.cursor()
        #inserisco la misurazione
        cursor.execute(f"INSERT INTO misurazioni (id_stazione, id_grandezza, data_ora, valore) VALUES ({id_stazione}, {id_grandezza}, '{data}', {valore})")
        cursor.fetchone()

        return(jsonify({'stato' : 'INSERITO CORRETAMENTE'}))

@app.route('/get_stats')   
def get_stats():

    """
    dati l'id di una stazione e l'id di una grandezza ne restituisce il valore minimo,
    il massimo ed il medio
    """

    #prendo gli id dall'URL
    id_grandezza = request.args["id_grandezza"]
    id_stazione = request.args["id_stazione"]

    print(f"""
    
        GETTING STATS OF:

        id_grandezza:   {id_grandezza}
        id_stazione:    {id_stazione}
    
    """)


    #connesione al DB
    with sqlite3.connect("static/meteo.db") as conn:
        
        cursor = conn.cursor()
        #prendo le statistiche
        cursor.execute(f"SELECT MIN(valore), MAX(valore), AVG(valore) FROM misurazioni WHERE id_grandezza = {id_grandezza} AND id_stazione = {id_stazione}")
        stats = cursor.fetchone()

        return(jsonify({'min' : stats[0], 'max' : stats[1], 'avg' : stats[2]}))

if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)
































