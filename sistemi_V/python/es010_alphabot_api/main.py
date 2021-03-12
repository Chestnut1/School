"""

Author: Bruno Luca
Date: 26-01-2021

"""

from flask import Flask,render_template, redirect, request
from flask.helpers import url_for
import time
import requests

app = Flask(__name__)

@app.route("/")
def control_page():
    return render_template("index.html")

@app.route("/movements", methods = ['GET'])
def move_bot():
    #alphabot = Alphabot()
    direction = request.args['dir']
    time = request.args['time']
    if request.method == "GET":

        if direction == "W":
            #alphabot.forward()
            return(f"Going foreward for {time} seconds")
            time.sleep(3)
            #alphabot.stop()
        elif direction == "A":
            #alphabot.left()
            return(f"Going left for {time} seconds")
            time.sleep(3)
            #alphabot.stop()
        elif direction == "S":
            #alphabot.backward()
            return(f"Going backward for {time} seconds")
            time.sleep(3)
            #alphabot.stop()
        elif direction == "D":
            #alphabot.right()
            return(f"Going right for {time} seconds")
            time.sleep(3)
            #alphabot.stop()
        
        print(direction)
        return render_template("index.html")


if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)