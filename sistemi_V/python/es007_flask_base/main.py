"""

Author: Bruno Luca
Date: 19-01-2020

"""

from flask import Flask,render_template

app = Flask(__name__)

@app.route("/")             # http://127.0.0.1:5000/
def index():                # decoratore. Per accedere alla pagina associata alla funzione index 
    return "pagina principale"

@app.route("/pagina2/")     # http://127.0.0.1:5000/pagina2/ 
def index2():
    return render_template("C:/Users/lucab/Desktop/repo/School/sistemi_V/python/es007_flask_base/template/index.html")



if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = True)