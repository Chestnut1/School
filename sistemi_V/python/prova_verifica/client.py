"""

Author: Bruno Luca
Date: 13-04-2021


"""

import sqlite3
from sqlite3.dbapi2 import connect
from flask import Flask,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests
import json
from threading import Thread

def main():
    ip = input("IP>> ")
    espression = f"http://127.0.0.1:5000/getop?ip={ip}"
    
    while True:
        
        r = requests.get(espression)   #invio la get per richiedere un'operazione
        if r.status_code == 200:    #tutto OK
            print("richiesta riuscita")

        print(r.text)
        operation = json.loads(r.text)['espression']
        op_id = json.loads(r.text)['id']
        result = eval(operation)    #calcolo l'operaizone

        
        setresult = f"http://127.0.0.1:5000/setresult?result={result}&id={op_id}"

        r = requests.get(setresult)
        if r.status_code == 200:    #tutto OK
            print("risultato inviato")


        input()
        


if __name__ == "__main__":
    main()