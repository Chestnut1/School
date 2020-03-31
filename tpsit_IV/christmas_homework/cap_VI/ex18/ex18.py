#let's use some function

#function that print two argument
def two_argv(*argv):
    argv1, argv2 = argv
    print(f"""
    |ARGV 1| -> {argv1}
    |ARGV 2| -> {argv2}
    """)

#same function as beforre, but with a differente name (USELESS)
def two_argv_again(*argv):
    argv1, argv2 = argv
    print(f"""
    |ARGV 1| -> {argv1}
    |ARGV 2| -> {argv2}
    """)

#function that print just one argument
def first_argv(argv1):
    print(f"""
    |ARGV 1| -> {argv1}
    """)

#function that do nothing
def print_none():
    print("\nI got nothing!\n")

two_argv("Lorenzo", "Il tecnico")
two_argv_again("Lorenzo", "Again")
first_argv("SECOND")
print_none()






