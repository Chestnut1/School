"""

Author: Bruno Luca
Date: 26-01-2021

"""

import sqlite3
from flask import Flask,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
import requests

app = Flask(__name__)

@app.route("/")
def control_page():
    print("dentro control page")
    return render_template("index.html")

@app.route("/", methods = ['GET','POST'])
def get_path():
    print("dentro movimento")
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
        
            return jsonify(paths)


if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)