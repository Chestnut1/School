import socket as sck

def main():
    host = "192.168.88.72"
    port = "6000"

    s = sck.socket(sck.AF_INET,sck.SOCK_DGRAM)

    s.bind((host,port))

    while True:
        raw_data, address = s.recvfrom(4096)
        data = raw_data.decode()

        print(f"{address}>> {data}")

        if data == "exit":
            break

        s.sendto(raw_data, address)

    s.close()

if __name__ == "__main__":
    main()