from sys import argv
script_name, name, surname = argv

prompt = "ANSWER>>"

print(f"""
Hi {name} {surname}!
I't {script_name} here!
I'd like to ask you some question...
Do you like {script_name} (me)?
""")
likes = input(prompt)

print(f"Where do you live {name}")
where = input(prompt)

print("What kind of computer do you have?")
computer = input(prompt)

print(f"""
Ok {name}!
So, you said {likes} about liking me...
and you live in {where}, even if o don't really know where it is...
And you have a {computer}. Nice!
""")