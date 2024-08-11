from Items_read import Item
from Operation import items_Display, items_return
from Displayables import main_page, thankuforshopping, invalid

# Define the main function
def main():
    try:
        # Initialize Rentals using the Item class to read available items
        Rentals = Item()

        while True:
            # Display the main menu
            main_page()

            # Get user input for the chosen option
            number = int(input("ENTER ( 1/2/3 ) AS YOUR REQUIREMENTS: "))
            
            # Handle user choices
            if number == 1:
                items_Display(Rentals)
                main()
            elif number == 2:
                items_return()
                main()
            elif number == 3:
                thankuforshopping()
                break
            elif number < 0 or number > 3:
                invalid()
            else:
                ValueError

    except ValueError:
        # Handle ValueErrors during user input
        print("You cannot Enter String. Please enter an option between 1 and 3")
        main()

# Call the main function to start the program
main()
