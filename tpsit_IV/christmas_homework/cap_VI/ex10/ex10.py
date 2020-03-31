#i hate cats >:C
tabby_cat = "\tI'm tabbed in."
pesrian_cat = "I'm split\non a line."
backslash_cat = "I'm \" a \" backslashed cat"

#let's print a USELESS list
fat_cat = '''
I'll do a lsit:
\t* Cat food
\t* Fishes
\t* Catnip\n\t* Grass
'''


"""

and there it is, finally, a USEFUL list of ESCAPE SEQUENCES
\\          '\'
\'          '''
\"          '"'
\a          'BEL' ASCII bel
\b          'BS' ASCII backspace
\f          'FF' ASCII formfeed
\n          'LF' ASCII linefeed
\N{name}    'Unicode only' Chacater named name in the unicode database
\r          '\CR" Carriage Return
\t          '' horizontal tab
\uxxxx      '' charcater with 16-it hex value xxxx
\Uxxxxxxxx  '' charater with 32-bit hex value xxxxxxxx
\v          '' vertial tab
\ooo        '' character with octal value ooo
\xhh        '' character with hex value hh

"""

#let's print some ugly cats
print(tabby_cat)
print(pesrian_cat)
print(backslash_cat)
print(fat_cat)