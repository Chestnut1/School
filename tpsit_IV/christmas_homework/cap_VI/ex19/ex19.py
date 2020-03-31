def python_exercise_left(exercises):
    if exercises < 10:
        print("Well done, you're doing the right thing!")
    elif exercises < 20:
        print("Keep going, you're almost there!")
    elif exercises < 30:
        print("May be it's better if you start doing something...")
    elif exercises < 50:
        print("You little ba***rd, move you a** and study python >:(")

ex_left = 17

python_exercise_left(int(input("How many python esercise dou you still have to do?")))
python_exercise_left(40)
python_exercise_left(int(ex_left))
print(f"""
So, if you have 30 exercise left the program will print:
    {python_exercise_left(30)}
else, if you have 0 exercise left it will say:
    {python_exercise_left(0)}
""")


