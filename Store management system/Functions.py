import datetime
from Displayables import invalid
#function to extract and diff date
def daydiff():
    datetoday_str = input("Enter the rented date in [YY-MM-DD] format: ")
    yearreturn, monthreturn, dayreturn = datetoday_str.split('-')

    
    yearreturn = int(yearreturn)
    monthreturn = int(monthreturn)
    dayreturn = int(dayreturn)

    diff=0
    today = datetime.datetime.now()
    year = today.year
    month = today.month
    day = today.day
    if dayreturn<0 or dayreturn>31 or monthreturn<0 or monthreturn>12 or yearreturn<0:
        invalid()
        daydiff()
    elif month<monthreturn or year<yearreturn :
        invalid()
        print("\t\t\t\t Not Posible value")
    else:
        diff=day - dayreturn
    return diff,datetoday_str
    
