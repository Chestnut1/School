"""

Author: Bruno Luca
Date: 26-01-2021

"""

from flask import Flask,render_template, redirect, request
from flask.helpers import url_for
import hashlib
import sqlite3

app = Flask(__name__)

@app.route("/")             # http://127.0.0.1:5000/
def index():                # decoratore. Per accedere alla pagina associata alla funzione index 
    return render_template("login.html")


@app.route("/", methods = ["GET","POST"])
def login():
    if request.method == "POST":
        usr = request.form["usr"]
        pwd = hashlib.sha512(request.form["pwd"].encode()).hexdigest()

        completion = validate(usr,pwd)

        if completion:
            return redirect(url_for("secret"))
        else:
            error  = "Invalid Credentials. Please try again."
        
        return render_template("login.html", error = error)

def validate(username,password):
    with sqlite3.connect("static/credential.db") as conn:
        cursor = conn.cursor()

        cursor.execute(f"SELECT email FROM users WHERE email = '{username}' AND password = '{password}' ")
        corrispondance = cursor.fetchall()

    print(len(corrispondance))

    return len(corrispondance)

@app.route("/signup", methods = ["POST"])
def signup():
    usr = request.form["usr"]
    pwd = hashlib.sha512(request.form["pwd"].encode()).hexdigest()

    print(pwd)

    with sqlite3.connect("static/credential.db") as conn:
        cursor = conn.cursor()

        cursor.execute(f"SELECT email FROM users WHERE email = '{usr}' ")
        corrispondance = cursor.fetchall()

    if len(corrispondance) == 0:
        with sqlite3.connect("static/credential.db") as conn:
            cursor = conn.cursor()

            cursor.execute(f"INSERT INTO users (email,password) VALUES ('{usr}','{pwd}')")
            corrispondance = cursor.fetchall()

        return "User created!"
    else:
        error  = "User already exist!"
        
    return render_template("signup", error = error)

    
@app.route("/secret")
def secret():
    return "This is a scerte page."

@app.route("/signup")
def load_signup():
    return render_template("signup.html")



if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)