"""

Author: Bruno Luca
Date: 19-02-2021

WEB APIs that manage a school library

"""

from flask import Flask,render_template, redirect, request, jsonify
from flask.helpers import url_for
import hashlib
import sqlite3

app = Flask(__name__)
app.config["DEBUG"] = True

books = [
    {
        "id": 0,
        "title": "Il Nome della Rosa",
        "author": "Umberto Eco",
        "year_published": "1980"
    },
    {
        "id": 1,
        "title": "Il Problema dei Tre Corpi",
        "author": "Liu Cixin",
        "year_published": "2008"
    },
    {
        "id": 2,
        "title": "Fondazione",
        "author": "Isaac Asimov",
        "year_published": "1951"
    }
    ]

@app.route("/", methods=["GET"])
def home():
    return "<h1>School Library</h1>"

@app.route("/api/v1/resources/books/all", methods = ["GET"])
def api_all():
    return jsonify(books)

app.run()