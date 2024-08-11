import datetime
from Items_read import Item
from Functions import daydiff
from Displayables import thankuforshopping, invalid, sucessful, itemsinshop

# List to hold rented items
rent = []

# Load available items from file
Rentals = Item()

# Function to display available items
def items_Display(Rentals):
    print(" \t ")
    print("╭──────────────────────────────────────────────────────────────────────────────────────────────────╮")
    print("|{:<8} | {:<35} | {:<18} | {:<10} | {:<10}  |".format("S.N","Name of Item","Brand","Price","Quantity left"))
    print("|══════════════════════════════════════════════════════════════════════════════════════════════════|")
    
    # Display available items and their details
    for SN, details in Rentals.items():
        Name = details["name"]
        Brand = details["brand"]
        Price = "${:.1f}".format(details["price"])
        Quantity = details["quantity"]
        print("| {:<7} | {:<35} | {:<18} | {:<10} | {:<14} |".format(SN, Name, Brand, Price, Quantity))
    
    print("╰──────────────────────────────────────────────────────────────────────────────────────────────────╯")
    
    # Ask user if they want to rent an item
    continue_again = input("Do you want to rent anything? (yes/no): ")
    
    if continue_again.upper() == "YES":
        rent_items_info()
    elif continue_again.upper() == "NO":
        thankuforshopping()
        exit()
    else:
        invalid()
        items_Display(Rentals)

# Function to gather rental information from the user
def rent_items_info():
    try:
        cust_Name = input("Enter your name: ")
        if any(r.isdigit() for r in cust_Name):
            raise ValueError
    except ValueError:
        print("\t Invalid input. Name should not contain numbers.")
        return rent_items_info()

    try:
        cust_Address = input("Enter your address: ")
        if any(r.isdigit() for r in cust_Address):
            raise ValueError
    except ValueError:
        print("\t Invalid address. Address should not contain spaces or numbers.")
        return rent_items_info()

    try:
        cust_Phone = input("Enter your phone number: ")
        if not cust_Phone.isdigit():
            raise ValueError
    except ValueError:
        print("\t Invalid phone number ")
        return rent_items_info()

    try:
        SN = int(input("Which item do you want to rent [Enter S.N]: "))
        if SN < 1 or SN > 5:
            raise ValueError
    except ValueError:
        print("\t Invalid item S.N entered. \t\nPlease enter a number between 1 and 5 from the available items.")
        return rent_items_info()
    
    rent_items(SN, cust_Name, cust_Address, cust_Phone)

# Function to handle the rental process
def rent_items(SN,cust_Name,cust_Address,cust_Phone):
    totalprice=0
    todaydate=datetime.datetime.now().strftime('%Y-%m-%d')
    while True:
        quantity= int(input("Enter quantity to rent: "))
        if (quantity<=0):
            print("Invalid amount")
            continue
        elif(quantity>Rentals[SN]["quantity"]):
            print("Invalid Quantity")
            continue
            
        price= Rentals[SN]["price"]
        totalprice = price*quantity
        final=totalprice+50
        invoice = f"""
            ╭───────────────────────────────────────────────────────────────╮
            |                   Equipment Rental shop                       | 
            |                    KULESHWOR-14,KATHMANDU                     | 
            |                          068-458963                           | 
            |---------------------------------------------------------------| 
            |                          RENT INVOICE                         | 
            |---------------------------------------------------------------| 
            | DATE:              {todaydate}{' ' * (43-len(todaydate))}|
            | CUSTOMER NAME:     {cust_Name.upper()}{' ' *(43-len(cust_Name))}|
            | CUSTOMER PHONE:    {cust_Phone}{' '*(43-(len(str(cust_Phone))))}| 
            | CUSTOMER ADDRESS:  {cust_Address.upper()}{' ' * (43 - len(cust_Address))}|
            |---------------------------------------------------------------|
            | PRODUCT NAME:      {Rentals[SN]["name"].upper()}{' ' * (43-len(Rentals[SN]["name"]))}|
            | QUANTITY:          {quantity}{' ' * (43-len(str(quantity)))}|
            | AMOUNT OF 1:       ${price:.1f}{' ' * (42-len(str(price)))}|
            |---------------------------------------------------------------| 
            | SUB-TOTAL AMOUNT:  ${totalprice:.1f}{' ' * (42-len(str(totalprice)))}|
            | SHIPPING CHARGE:   $50{' ' * 40}|
            | TOTAL AMOUNT:      ${final :.1f}{' ' * (42-len(str(final)))}|
            |---------------------------------------------------------------| 
            |                THANK YOU FOR YOUR BUSINESS!!                  |
            ╰───────────────────────────────────────────────────────────────╯
            """
        askbill=input("Do u want to print the bills(yes/no)")
        if askbill.upper()=="YES":
            print(invoice)
        with open("rented_items.txt","a",encoding="utf-8") as file:
            file.write(invoice)
            sucessful()
        Rentals[SN]["quantity"] -= quantity
        with open("rent.txt", "w", encoding="utf-8") as file:
            for SN, details in Rentals.items():
                PSN = SN
                Pname = details['name']
                Pbrand = details['brand']
                Pprice = details['price']
                Pquantity = details['quantity']
                file.write(f"{PSN}, {Pname}, {Pbrand}, ${Pprice:.1f}, {Pquantity}\n")
        addmore= input("Do you want to add more items to rent?(yes/no): ")
        if addmore.upper()=="NO":
            break
        elif addmore.upper()=="YES":
            return items_Display(Rentals)
# Function to handle the return process
def items_return():
    try:
        cust_Name = input("Enter your name: ")
        if any(r.isdigit() for r in cust_Name):
            raise ValueError
    except ValueError:
        print("\t Invalid input. Name should not contain numbers.")
        items_return()

    try:
        cust_Address = input("Enter your address: ")
        if any(r.isdigit() or r.isspace() for r in cust_Address):
            raise ValueError
    except ValueError:
        print("\t Invalid address. Address should not contain spaces or numbers.")
        items_return()

    try:
        cust_Phone = input("Enter your phone number: ")
        if not cust_Phone.isdigit():
            raise ValueError
    except ValueError:
        print("\t Invalid phone number ")
        items_return()
    totalamount = 0
    diff, date = daydiff()
    todaydate = datetime.datetime.now().strftime('%Y-%m-%d')
    itemsinshop(Rentals)
    
    while True:
        try:
            SN = int(input("Which item do you want to return [Enter S.N]: "))
            if SN < 1 or SN > 5:
                raise ValueError
        except ValueError:
            print("\t Invalid item S.N entered. \t\nPlease enter a number between 1 and 5 from the available items.")
            items_return()

        quantity = int(input("Enter quantity to return: "))
        if quantity <= 0:
            print("Invalid amount")
            continue
        penaltyamount=0  
        price = Rentals[SN]["price"]
        totalamount = quantity * price
        if diff <= 5:
            penaltyamount = 0
        elif diff == 6:
            penaltyamount = 25
        elif diff == 7:
            penaltyamount = 50
        elif diff == 8:
            penaltyamount = 75
        elif diff == 9:
            penaltyamount = 100
        elif diff == 10:
            penaltyamount = 125
        elif diff>=11:
            penaltyamount = 300
        elif diff >= 20:
            penaltyamount = 400
        final = totalamount + penaltyamount

        invoice=f"""
            ╭───────────────────────────────────────────────────────────────╮
            |                   Equipment Rental shop                       | 
            |                    KULESHWOR-14,KATHMANDU                     | 
            |                          068-458963                           | 
            |---------------------------------------------------------------| 
            |                        RETURN INVOICE                         | 
            |---------------------------------------------------------------| 
            | DATE TODAY:        {todaydate}{' ' * (43-len(todaydate))}|
            | DATE OF RETURN:    {date}{' '*(43-len(date))}|
            | CUSTOMER NAME:     {cust_Name.upper()}{' ' *(43-len(cust_Name))}|
            | CUSTOMER PHONE:    {cust_Phone}{' '*(43-(len(str(cust_Phone))))}| 
            | CUSTOMER ADDRESS:  {cust_Address.upper()}{' ' * (43 - len(cust_Address))}|
            |---------------------------------------------------------------|
            | PRODUCT NAME:      {Rentals[SN]["name"].upper()}{' ' * (43-len(Rentals[SN]["name"]))}|
            | QUANTITY:          {quantity}{' ' * (43-len(str(quantity)))}|
            | AMOUNT OF 1:       ${price:.1f}{' ' * (42-len(str(price)))}|
            |---------------------------------------------------------------| 
            | SUB-TOTAL AMOUNT:  ${totalamount:.1f}{' ' * (42-len(str(totalamount)))}|
            | TOTAL AMOUNT:      ${final :.1f}{' ' * (42-len(str(final)))}|
            |---------------------------------------------------------------| 
            |                THANK YOU FOR YOUR BUSINESS!!                  |
            ╰───────────────────────────────────────────────────────────────╯
        """
        displayinvoice=input("Do u want to display the invoice? [yes/no]: ")
        
        if penaltyamount!=0:
            print("U have returned the rented items late")
        with open("returned_items.txt","a",encoding="utf-8") as file:
            file.write(invoice)
            sucessful()
        Rentals[SN]["quantity"] += quantity
        with open("rent.txt", "w", encoding="utf-8") as file:
            for SN, detail in Rentals.items():
                PSN = SN
                Pname = detail['name']
                Pbrand = detail['brand']
                Pprice = detail['price']
                Pquantity = detail['quantity']
                file.write(f"{PSN}, {Pname}, {Pbrand}, ${Pprice:.1f}, {Pquantity}\n")
        if displayinvoice.upper()=="YES":
            print(invoice)
        elif displayinvoice.upper()=="NO":
            break
        addmore= input("Do you want to add more items to return?(yes/no): ")
        if addmore.upper()=="NO":
            break
        elif addmore.upper()=="YES":
            return items_return()
        
    
    