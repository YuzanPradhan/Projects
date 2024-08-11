from read import read
from display import front,error
from datetime import datetime

d = {}

# Read content of the file
read()
while True:
    front()
    user_input = input(" Enter your choice: ")

    if user_input == "1":
        l = list(d.keys())
        name = input(" Enter your name: ")
        phone_number = input(" Enter your contact number: ")

        print("LandID \t City \t\t Direction \t Anna\t\tPrice \t\t Availability")
        for key, value in d.items():
            print(key,"\t",value[0],"\t",value[1],"\t\t",value[2],"\t\t",value[3],"\t",value[4])

        print("\n")
        bills = []

        while True:
            # Checking valid land id
            land_id = input(" Enter desired land ID (or type 'done' to finish): ")
            if land_id.lower() == "done":
                break

            if land_id not in l or d[land_id][4].strip()!= "Available":
                print(" Invalid LandID // Land not available for rent!!")
                continue

            print(" Valid LandID !!")

            user_month = int(input(" Enter rent period(month) as per your requiremnt: "))
           
           

            # Updating Dictionary
            selected_item = d[land_id]
            total_price = int(selected_item[3]) * user_month
            items = [land_id, selected_item[0], selected_item[1], selected_item[3], user_month, total_price]
            bills.append(items)

            selected_item[4] = "Not Available"

        # Updating Dictionary and writing to the file
        try:
            with open("land.txt", "w") as file:
                for key, value in d.items():
                    file.write(key+","+",".join(value)+"\n")
        except IOError:
            error()
            exit(1)

        # Print bills
        grand_total = sum(int(i[5]) for i in bills)
        today_date_and_time = datetime.now()

        print("\n")
        print("\t \t \t \t TECHNO PROPERTY NEPAL ")
        print("\n")
        print("\t \t Bafal, Kathmandu | Phone No: 9869000000 ")
        print("\n")
        print("-------------------------------------------------------------------------")
        print("Customer Details:")
        print("-------------------------------------------------------------------------")
        print(key,"Name of the Customer :", name)
        print(key," Contact number:", phone_number)
        print(key," Date and time of purchase:", today_date_and_time)
        print("-------------------------------------------------------------------------")
        print("\n")
        print(" Land Rent Details:")
        print("------------------------------------------------------------------------------------------------------------------")
        print(" LandID \t City \t\t Direction \t Price \t\t Rented Month \t\t Total Price")
        print("------------------------------------------------------------------------------------------------------------------")
        for each in bills:
            print(key,each[0],"\t",each[1],"\t",each[2],"\t",each[3],"\t",each[4],"\t",each[5])
        print("------------------------------------------------------------------------------------------------------------------")

        print(key, "Grand Total: ", grand_total)
        print("\n")

        try:
            with open("bill.txt", "w") as file:
                # Writing bills to file
                file.write("\n")
                file.write("\t \t \t \t Techno Property Nepal \n")
                file.write("\n")
                file.write("\t \t Bafal, Kathmandu | Phone No: 9869000000 ")
                file.write("\n")
                file.write("-------------------------------------------------------------------------")
                file.write(" Customer Details:")
                file.write("-------------------------------------------------------------------------")
                file.write(key," Name of the Customer: ",name)
                file.write(key," Contact number: : ",phone_number)
                file.write(key," Date and time of purchase: ",today_date_and_time)
                file.write("-------------------------------------------------------------------------")
                file.write("\n")
                file.write(" Land Rent Details:")
                file.write("------------------------------------------------------------------------------------------------------------------")
                file.write(" LandID \t City \t Direction \t Price \t Rented Month \t Total Price\n")
                file.write("------------------------------------------------------------------------------------------------------------------")
                for each in bills:
                    file.write(key,each[0],"\t\t\t",each[1],"\t\t\t",each[2],"\t\t\t",each[3],"\t\t\t",each[4],"\t\t\t",each[5])
                file.write("------------------------------------------------------------------------------------------------------------------")
                file.write(key,"Grand Total: ",grand_total)
                file.write("\n")
        except IOError:
            print("Error occurred while writing bill file.")
            exit(1)

    elif user_input == "2":
        l = list(d.keys())
        name = input(" Enter your name: ")
        print("LandID \t City \t\t Direction \t\t Price \t\t Availability")
        for key, value in d.items():
            if value[4] != "Available":
                print(key,"\t",value[0],"\t",value[1],"\t",value[2],"\t\t",value[3],"\t\t",value[4])

        land_id = input(" Enter the land ID to return: ")
        while land_id not in l or d[land_id][4] != "Not Available":
            print(" Invalid LandID or Land not rented by you!!")
            land_id = input(" Enter the land ID to return: ")

        selected_item = d[land_id]
        rented_months = int(input(" Enter the number of months rented: "))
        refund_amount = int(selected_item[3]) * rented_months

        selected_item[4] = "Available"

        # Updating Dictionary and writing to the file
        try:
            with open("land.txt", "w") as file:
                for key, value in d.items():
                    file.write(key,{','.join(value)})
        except IOError:
            print("Error occurred while updating land file.")
            exit(1)

        # Print return bill
        today_date_and_time = datetime.now()
        print("\n")
        print("\t \t \t \t TECHNO PROPERTY NEPAL ")
        print("\n")
        print("\t \t Bafal, Kathmandu | Phone No: 9869000000 ")
        print("\n")
        print("-------------------------------------------------------------------------")
        print(" Customer Details:")
        print("-------------------------------------------------------------------------")
        print(key," Name of the Customer: ",name)
        print(key," Contact number: ",phone_number)
        print(key," Date and time of return: ",today_date_and_time)
        print("-------------------------------------------------------------------------")
        print("\n")
        print(" Returned Land Details are:")
        print("------------------------------------------------------------------------------------------------------------------")
        print(" LandID \t City \t\t Direction \t Price \t\t Rented Months \t\t Refund Amount\n")
        print("------------------------------------------------------------------------------------------------------------------")
        print(key,land_id,"\t",selected_item[0],"\t",selected_item[1],"\t",selected_item[3],"\t\t",rented_months,"\t\t",refund_amount)
        print("------------------------------------------------------------------------------------------------------------------")

        try:
            with open("return_bill.txt", "w") as file:
                # Writing return bill to file
                file.write("\n")
                file.write("\t \t \t \t Techno Property Nepal ")
                file.write("\n")
                file.write("\t \t Bafal, Kathmandu | Phone No: 9869000000 ")
                file.write("\n")
                file.write("-------------------------------------------------------------------------")
                file.write(" Customer Details:")
                file.write("-------------------------------------------------------------------------")
                file.write(key," Name of the Customer: ",name)
                file.write(key," Contact number: ",phone_number)
                file.write(key," Date and time of return: ", today_date_and_time)
                file.write("-------------------------------------------------------------------------")
                file.write("\n")
                file.write(" Returned Land Details are:")
                file.write("------------------------------------------------------------------------------------------------------------------")
                file.write(" LandID \t City \t\t Direction \t Price \t\t Rented Months \t\t Refund Amount")
                file.write("------------------------------------------------------------------------------------------------------------------")
                file.write(key,land_id,"\t",selected_item[0],"\t",selected_item[1],"\t",selected_item[3],"\t\t",rented_months,"\t\t",refund_amount)
                file.write("------------------------------------------------------------------------------------------------------------------")
        except IOError:
            print("Error occurred while writing return bill file.")
            exit(1)

    elif user_input == "3":
        break
    elif user_input == "4":
        try:
            with open("land.txt", "r") as file:
                print("LandID \t City \t\t Direction \t\t Price \t\t Availability")
                for line in file:
                    line = line.strip()
                    l = line.split(",")
                    print(key,l[0],"\t",l[1],"\t",l[2],"\t",l[3],"\t\t",l[4])
        except FileNotFoundError:
            print("Land file not found. Please check the file path and try again.")
    else:
        print(" Invalid input")
