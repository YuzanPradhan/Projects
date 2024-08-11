def read():
    try:
        with open("land.txt", "r") as file:
            for line in file:
                line = line.strip()
                l = line.split(",")
                k = l[0]
                value = l[1:]
                d[k] = value
    except FileNotFoundError:
        print("Land file not found. Please check the file path and try again.")
        exit(1)
    print("WELCOME TO TECHNO PROPERTY NEPAL, what service are you looking for?")

