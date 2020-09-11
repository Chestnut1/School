"""
Author: Bruno Luca
Date: 11-09-2020
Title: ricerca binaria
"""
import time

def append_list(file):
    t = []
    for line in file:
        t.append(line)
    return t

def binarySearch(words, item):
	start = 0
	end = len(words)-1
	
	while start<=end:
	    index = (start + end)//2
	    if words[index] == item:
	        return True, index
	    elif item < words[index]:
	        end = index-1
	    else:
	        start = index+1
	
	return False,None


def main():
    fin = open("words.txt")
    
    execution_time = time.time()
    found, position = binarySearch(append_list(fin),"dog\n")
    execution_time = time.time() - execution_time

    if found:
        print(f"Words found at {position} in {execution_time} seconds...")
    else:
        print("Element not found")

    fin.close()

if __name__ == "__main__":
    main()