#alphabet mapping
number2char = {}
char2number = {}
for i in range (65,91):
    char2number[chr(i)] = i - 65
    number2char[i-65] = chr(i)

#list of special chars
special_chars = [" ","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}","\\","|",":",";","'","\"",",","<",".",">","/","?","`","~"]
