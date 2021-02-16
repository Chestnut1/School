"""

Author: Bruno Luca
Date: 26-01-2021

"""

from School.sistemi_V.python.es009_alphabot_control.alphabot import AlphaBot
from flask import Flask,render_template, redirect, request
from flask.helpers import url_for
import alphabot.py
import time

app = Flask(__name__)

@app.route("/")
def control_page():
    return render_template("index.html")

@app.route("/", methods = ['POST'])
def move_bot():
    alphabot = Alphabot()

    if request.method == "POST":
        command = request.form["btn"]

        if command == "W":
            alphabot.forward()
            time.sleep(3)
            alphabot.stop()
        elif command == "A":
            alphabot.left()
            time.sleep(3)
            alphabot.stop()
        elif command == "W":
            alphabot.backward()
            time.sleep(3)
            alphabot.stop()
        elif command == "W":
            alphabot.right()
            time.sleep(3)
            alphabot.stop()
        
        print(command)
        return render_template("index.html")
    
def secret():
    return "This is a scerte page."

def validate(username,password):
    return False

if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)