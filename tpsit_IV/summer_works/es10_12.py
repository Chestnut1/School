"""
Author: Bruno Luca
Date: 11-09-2020
Title: word intersection
"""

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

def check_intersection(words,w):
    first = w[::2]
    second = w [1::2]
    return binarySearch(words,first) and binarySearch(words,second)

def main():
    fin = open("words.txt")

    words_list = append_list(fin)

    for word in words_list:
        if(check_intersection(words_list,word)):
            print(f"{word.upper()}\t->\t{word[::2]}\t|\t{word[1::2]}\n")

if __name__ == "__main__":
    main()