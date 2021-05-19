"""

Author: Bruno Luca, Van Cleeff Jacopo
Date: 20-04-2021

"""

from flask import Flask, render_template, url_for
from flask_socketio import SocketIO
import socketio
import geventwebsocket
import websocket

app = Flask(__name__)
app.config['SECRET_KEY'] = 'vnkdjnfjknfl1232#'
socketio = SocketIO(app)

@app.route('/')
def sessions():
    #QUA TOMMY METTI LA PAGINA DELLA CHAT
    return render_template('session.html')

def messageReceived(methods=['GET', 'POST']):
    print('message was received!!!')

@socketio.on('my event')
def handle_my_custom_event(json, methods=['GET', 'POST']):
    print('received my event: ' + str(json))
    socketio.emit('my response', json, callback=messageReceived)

if __name__ == '__main__':
    socketio.run(app, debug=True)