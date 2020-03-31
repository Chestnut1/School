from sys import argv
script_name, file_name, second_file_name = argv

#open the txt file
txt = open(file_name)

#shwo the contents of the file
print(f"This is {file_name}:")
print(txt.read())

#show new file name
new_txt = open(second_file_name)
print(f"And this is {second_file_name}: ")
print(new_txt.read())

#close all opened files
txt.close()
new_txt.close()

