"""

Author: Bruno Luca
Date: 23-03-2021

Client alphabot

"""

import sqlite3
from sqlite3.dbapi2 import connect
from flask import Flask,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests
import json

def main():
    url = f"http://127.0.0.1:5000/percorsi?start=info1&end=aula3.0"

    r = requests.get(url)
    if r.status_code == 200:
        print("richiesta riuscita")

    paths = []
    for d in json.loads(r.text):
        paths.append(d['path'])

    print(paths)

    for path in paths: 
        index = 0
        while index < len(path):
            distance = ''
            if path[index] == 'W':
                index = index + 1
                while index < len(path) and path[index].isnumeric():
                    distance = distance + path[index]
                    index = index + 1
                t.forward(int(distance)/2)

            elif path[index] == 'S':
                index = index + 1
                while index < len(path) and path[index].isnumeric():
                    distance = distance + path[index]
                    index = index + 1
                t.backward(int(distance)/2)

            elif path[index] == 'A':
                index = index + 1
                while index < len(path) and path[index].isnumeric():
                    distance = distance + path[index]
                    index = index + 1
                t.left(int(distance))

            elif path[index] == 'D':
                index = index + 1
                while index < len(path) and path[index].isnumeric():
                    distance = distance + path[index]
                    index = index + 1
                t.right(int(distance))
    
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

        request.get(f"http://127.0.0.1:5000/ostacoli?sx={currSX}&dx={currDX}&status=")      

        time.sleep(500)
    




if __name__ == "__main__":
    main()
