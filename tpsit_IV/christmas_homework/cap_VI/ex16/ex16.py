from sys import argv

script, filename = argv

print(f"We're going to erase {filename}.")
print("If you don't want that, hit CTRL-C (^C).")
print("If you do want that, hit RETURN.")

input("?")

print("Opening the file...")
target = open(filename, 'w')
#READING AND WRITING FILES 85
print("Truncating the file. Goodbye!")  #the text file automatically truncate when opened in 'w' mode

print("Now I'm going to ask you for three lines.")

#ask the users what to write inside the program
line1 = input("line 1: ")
line2 = input("line 2: ")
line3 = input("line 3: ")

print("I'm going to write these to the file.")

target.write(line1 + "\n" + line2 + "\n" + line3 + "\n")

#close the file
target.close()

#open new file and print what's inside
target = open(filename)
print("New file:\n")
print(target.read())

print("And finally, we close it.")
target.close()