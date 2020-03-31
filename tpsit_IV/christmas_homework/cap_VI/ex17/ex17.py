from sys import argv
from os.path import exists

script_name, mother_file, child_file = argv

print(f"\nCOPYING FILES |{mother_file}|-->|{child_file}|\n")

#copy  files from mother file to child file
child = (open(child_file, "w")).write(open(mother_file).read())