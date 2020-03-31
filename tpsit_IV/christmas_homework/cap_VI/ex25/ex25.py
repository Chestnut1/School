def break_words(stuff):
    """This function will break up words"""
    return stuff.split(" ")

def sort_words(words):
    """This function will return sorted words"""
    return sorted(words)

def print_first_word(words):
    """This function will return the first word of the list after popping it off"""
    print(words.pop(0))

def print_last_word(words):
    """This function will return the last word of the list, after popping it off"""
    print(words.pop(-1))

def sort_sentence(sentence):
    """This function sort words inside a sentence and return it"""
    return sort_words(break_words(sentence))

def print_first_and_last(sentence):
    """This function print the last and the first word of the sentence"""
    words = break_words(sentence)
    print_first_word(words)
    print_last_word(words)

def print_first_and_last_sorted(sentence):
    """This function sorts the words and then print the fisrt and the last one"""
    words = sort_sentence(sentence)
    print_first_word(words)
    print_last_word(words)




