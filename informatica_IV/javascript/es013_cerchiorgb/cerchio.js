"use strict"

//creating circle class
function Cerchio(x,y,radius, r, g, b, ctx){
    this.ctx = ctx
    this.x = x
    this.y = y
    this.radius = radius 
    this.r = (r>+0 && r<= 255 ? r:0)
    this.g = (g>+0 && g<= 255 ? g:0)
    this.b = (b>+0 && b<= 255 ? b:0)

    this.draw = function(){
        this.ctx.beginPath()
        this.ctx.arc(this.x, this.y, this.radius,0, Math.PI *2, true)
        this.ctx.fillStyle = "rgba(" + this.r + "," + this.g + "," + this.b + ", 0.5)" 
        this.ctx.strokeStyle = this.ctx.fillStyle
        this.ctx.fill()
		this.ctx.stroke()
		this.ctx.closePath()
    }
}

function createCircle(){
    let c = new Cerchio(parseInt(Math.random() * (400-10+1))+ 10,parseInt(Math.random() * (200-10+1))+ 10,parseInt(Math.random() * (50-5+1))+ 5,document.getElementById("red").value,document.getElementById("green").value,document.getElementById("blue").value,ctx)
    c.draw()
    cerchi.push(c)
}

function creaCanvas(w,h) {
    var body = document.getElementsByTagName('body')[0]
	var canvas = document.createElement('canvas')
    body.appendChild(canvas)
    canvas.style.border = "1px solid black"
    canvas.style.width = (w || 500) +"px" 
    canvas.style.height = (h || 300) +"px" 
	return canvas.getContext("2d")
}

var ctx
var cerchi = new Array()
window.onload = function(){
    ctx = CNV.getContext("2d")
}





