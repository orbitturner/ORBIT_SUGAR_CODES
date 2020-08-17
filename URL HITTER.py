#coding: utf-8

'''
#  *	  By :
#  *
#  *     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗ 
#  *    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗
#  *    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝
#  *    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗
#  *    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║
#  *     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝
#  *          
#  *  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Email: orbitturner@gmail.com - Country: Senegal
#  */
This program allows you to hit an url X times.
'''
import urllib.request as urllib2

# RECUPERATION & CONTROLE DES VALEURS SAISIES
correct = False
while not(correct):
    try:
        url = str(input("-> VEUILLEZ DONNER L'URL A ATTACKER: "))
        iteration = int(input("-> VEUILLEZ DONNER LE NOMBRE DE HIT A FAIRE: "))
        # assert hd >= 0 and md >= 0 and ha >= 0 and ma >= 0 
    except ValueError:
        print("\n!! VOUS AVEZ SAISI UNE VALEUR INCORRECTE !!")
        continue
    else:
        correct = True
print("")


print("\n--> FETCHING THE URL... ")
try:
	for _ in range(iteration):
    urllib2.urlopen(url)
except:
	print("\n===============================> STATE <===============================\n")
	print("\t\t!! AN ERROR OCURRED DURING EXECUTION !!")
	print("\t\t!! PLEASE TRY AGAIN LATER OR USE ANOTHER URL !!")
	print("\n==========================================================================\n")
else:
	print("\n===============================> STATE <===============================\n")
	print("\t\tSUCESSFULLY DONE !")
	print("\n==========================================================================\n")
finally:
	print("PROGRAM ENDED")