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

#aggiungo alla web api la ricerca per id del libro
@app.route("/api/v1/resources/books", methods = ["GET"])
def api_id():
    result = []

    if 'id' in request.args:
        id = int(request.args['id']) 

        with sqlite3.connect('static/library.db') as conn:
            cursor = conn.cursor()
            cursor.execute(f"SELECT title, author, year FROM books WHERE id = {id}")
            
            data = cursor.fetchone()
            print(list(data)) 
            result.append(list(data)) 

    elif 'title'in request.args:
        title = request.args['title']
        print(title)
        with sqlite3.connect('static/library.db') as conn:
            cursor = conn.cursor()
            cursor.execute(f"SELECT id, author, year FROM books WHERE title = '{title}'")
            
            data = cursor.fetchone()
            print(data) 
            result.append(data) 
    else:
        return "Error: No id or title field provided. Please specify one of them."

    

    

    """
    for book in books:
        if book['id'] == id:
            result.append(book)
            break
    """
    
    return jsonify(result)

app.run()