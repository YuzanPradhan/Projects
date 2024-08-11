from Items_read import Item
Rentals = Item()
##function to display varuous commands
def main_page():
    print('''
                    ╭───────────────────────────────────────────────────────────────────╮
                    │                                                                   │
                    │                WELCOME TO Equipment Rental Shop                   │
                    │                                                                   │
                    │===================================================================│
                    │        PLEASE SELECT (1/2/3/4), ACCORDING TO YOUR CHOICE:         │
                    │                                                                   │
                    │                   1 = Show Available Items                        │
                    │                   2 = Returned Items                              │    
                    │                   3 = Exit Shop                                   │
                    ╰───────────────────────────────────────────────────────────────────╯

        ''')
    
def thankuforshopping():
    print('''
                    ╭───────────────────────────────────────────────────────────────────╮
                    |               THANKYOU !!  FOR SHOPPING WITH US                   |
                    ╰───────────────────────────────────────────────────────────────────╯
            ''')

def invalid():
    print('''
                    ╭───────────────────────────────────────────────────────────────────╮
                    |             ENTER A VALID INPUT TO PROCEED FORWARD. !!            |
                    ╰───────────────────────────────────────────────────────────────────╯
    ''')
def sucessful():

    print('''
                        ╭─────────╮
                        |SUCESSFUL|
                        ╰─────────╯
    ''')

def itemsinshop(Rentals):
    print (" \t ")
    print("╭──────────────────────────────────────────────────────────────────────────────────────────────────╮")
    print("|{:<8} | {:<35} | {:<18} | {:<10} | {:<10}  |".format("S.N","Name of Item","Brand","Price","Quantity left"))        
            
            
    print("|══════════════════════════════════════════════════════════════════════════════════════════════════|")
    for SN, details in Rentals.items():
        Name=details["name"]
        Brand = details["brand"]
        Price = "${:.1f}".format(details["price"])
        Quantity = details["quantity"]
        print("| {:<7} | {:<35} | {:<18} | {:<10} | {:<14} |".format(SN,Name,Brand,Price,Quantity))
    print("╰──────────────────────────────────────────────────────────────────────────────────────────────────╯")