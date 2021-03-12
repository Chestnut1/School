import requests


def main():
    url = "localhost:5000"
    start_end = {"start" : "aula3.0", "end" : "info1"}

    x = requests.post(url, data = start_end)


if __name__ == "__main__":
    main()