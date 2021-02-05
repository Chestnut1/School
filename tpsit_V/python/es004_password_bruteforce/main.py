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
def index():                
    return render_template("login.html")


@app.route("/", methods = ["GET","POST"])
def login():

    """
    This function is called when the login button is pressed.
    It takes username and the password that is instantly hashed in SHA512.
    Connect to the credential DB and check for corrispondace and let the user see a secret page.
    """

    if request.method == "POST":
        #get username and password
        usr = request.form["usr"]
        pwd = hashlib.sha512(request.form["pwd"].encode()).hexdigest()

        completion = validate(usr,pwd)  #check if password is correct

        if completion:
            return redirect(url_for("secret"))  #redirect user to the secret page
        else:
            error  = "Invalid Credentials. Please try again."   #stay in the login page and say wrong credentials
        
        return render_template("login.html", error = error)

def validate(username,password):

    """
    This function is called when the login button is pressed.
    It takes username and the hashed password. It connect to the credential DB and check if 
    username and password are correct.
    """

    with sqlite3.connect("static/credential.db") as conn:   #connect to DB
        cursor = conn.cursor()  #create a cursor

        #search for user email
        cursor.execute(f"SELECT email FROM users WHERE email = '{username}' AND password = '{password}' ")
        corrispondance = cursor.fetchall()

    return len(corrispondance) # 1 --> user found!  |  0 --> user not found!

@app.route("/signup", methods = ["POST"])
def signup():

    """
    When Signup button is pressed load this page. It allow user to insert a new email and password 
    in the credential DB.
    If user already exist say it to the user and stay in the signup page.
    """

    #get username and password
    usr = request.form["usr"]
    pwd = hashlib.sha512(request.form["pwd"].encode()).hexdigest()

    #connect to db
    with sqlite3.connect("static/credential.db") as conn:
        cursor = conn.cursor()  #create a cursor 

        #selecet all user with the same email to see if it already exist
        cursor.execute(f"SELECT email FROM users WHERE email = '{usr}' ")
        corrispondance = cursor.fetchall()

    if len(corrispondance) == 0:    #user dows not exist
        with sqlite3.connect("static/credential.db") as conn:
            cursor = conn.cursor()

            cursor.execute(f"INSERT INTO users (email,password) VALUES ('{usr}','{pwd}')")
            corrispondance = cursor.fetchall()

        return "User created!"
    else:   #user already exist
        error  = "User already exist!"
        
    return render_template("signup", error = error)

    
@app.route("/secret")
def secret():   
    """
    This function rendere a secret page.
    """
    return "This is a scerte page."

@app.route("/signup")
def load_signup():
    """
    This function rendere a page where user can add email and password to credentail DB.
    """
    return render_template("signup.html")



if __name__ == "__main__":
    app.run(host="127.0.0.1", debug = False)