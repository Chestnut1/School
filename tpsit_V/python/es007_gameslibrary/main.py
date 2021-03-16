"""

Author: Bruno Luca
Date: 12-03-2021

"""

from flask import Flask,render_template, redirect, jsonify
from flask.helpers import url_for
import time
import requests
import json

app = Flask(__name__)

@app.route("/")
def main():
    return render_template("index.html")

@app.route("/relesase", methods = ["GET"])
def last_released():
    results = requests.get('https://api.rawg.io/api/platforms')
    keys = []

    for k,_ in json.loads(results.text).items():
        keys.append(k)

    #return str(keys)        ['WARNING', 'count', 'next', 'previous', 'results']
        
    if "next" in keys:
        return "This GET has more than 1 page."
    else:
        return "This page has just 1 page."


@app.route("/popular", methods = ["GET"])
def most_popular():
    results = requests.get('https://api.rawg.io/api/games?dates=2019-01-01,2019-12-31&ordering=-added')

    return(results.text)

@app.route("/ubisoft", methods = ["GET"])
def best_of_ubisoft():
    return("Implementare giochi ubisoft")

if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)