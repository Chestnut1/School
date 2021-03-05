"""

Author: Bruno Luca
Date: 26-01-2021

"""

from flask import Flask,render_template, redirect, request
from flask.helpers import url_for
#import alphabot.py
import time

app = Flask(__name__)

@app.route("/")
def control_page():
    return render_template("index.html")

@app.route("/movements", methods = ['GET'])
def move_bot():
    #alphabot = Alphabot()
    direction = request.args['dir']
    if request.method == "GET":

        if direction == "W":
            #alphabot.forward()
            return("Going foreward")
            time.sleep(3)
            #alphabot.stop()
        elif direction == "A":
            #alphabot.left()
            return("Going left")
            time.sleep(3)
            #alphabot.stop()
        elif direction == "S":
            #alphabot.backward()
            return("Going backward")
            time.sleep(3)
            #alphabot.stop()
        elif direction == "D":
            #alphabot.right()
            return("Going right")
            time.sleep(3)
            #alphabot.stop()
        
        print(direction)
        return render_template("index.html")


if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)