"""


"""

from os import stat
import sqlite3
from flask import Flask, json,render_template, redirect, request, jsonify
from flask.helpers import url_for
import time
from flask import request
import requests

app = Flask(__name__)



@app.route('/getContetnFrom')
def getContentFrom():
    """
    
    given a ip 
    
    """
    peerIP = requests.args['peerIP']

    with sqlite3.connect("contents.db") as conn:

        cursor = conn.cursor()

        cursor.execute(f"SELECT id, plai_text FROM messages WHERE peerIP = {peerIP}")


if __name__ == "__main__":
    app.run(host = '127.0.0.1', debug = True)