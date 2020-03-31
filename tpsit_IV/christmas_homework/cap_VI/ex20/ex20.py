from sys import argv
script_name, file_name = argv

#function that print all the file
def print_file(f):
    print(f.read())

#function thath goes to the start of the file
def rewind(f):
    f.seek(0)

#function that print one line
def println(f,line):
    print(line, f.readline())

current_file = open(file_name)

print_file(current_file)

rewind(current_file)

current_line = 1

println(current_file,current_line)
current_line += 1

println(current_file, current_line)
current_line += 1



