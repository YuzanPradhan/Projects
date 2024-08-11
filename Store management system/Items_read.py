#function to read the values form rent.txt
def Item():
    Rentals = {}
    with open("rent.txt", "r") as file:
        for line in file:
            items = line.strip().split(", ")
            SN, name, brand, price, quantity = items
            Rentals[int(SN)] = {
                "S.N": int(SN),
                "name": name,
                "brand": brand,
                "price": float(price.strip("$")),
                "quantity": int(quantity)
            }
    return Rentals
