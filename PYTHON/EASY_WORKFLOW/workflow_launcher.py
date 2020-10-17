#coding: utf-8

# /* === 🌌 WELCOME TO ORBIT LAUNCHER 🌌  ===
# *                     
# *	  By :
# *
# *     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗ 
# *    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗
# *    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝
# *    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗
# *    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║
# *     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝
# *          
# *  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal
# *                              GITHUB : Orbit Turner    -   Website: http://orbitturner.yj.fr/ 
# */
'''
THIS PROGRAM WILL HELP YOU OPEN MANY WINDOWS PROGRAMS QUICKLY
FOR A BETTER WORKFLOW
'''
import subprocess
import os

running = True
while running:        
    # STARTING OF THE PROGRAM
    os.system("cls")
    print("\n===============================> WELCOME <===============================\n")
    print("\t\t!! WORKFLOW APP LAUNCHER V1.0.1 !!")
    print("\n==========================================================================\n")

    # RECUPERATION & CONTROLE DES VALEURS SAISIES
    exact = False
    while not(exact):
        try:
            print("\n==================================================================\n")
            print("\t\t--> QUE VOULEZ-VOUS CALCULER ? <--")
            print("\n\t==> 1 ............. CODING MODE")
            print("\n\t==> 2 ............. WEB SURF MODE")
            print("\n\t==> 3 ............. [ EXIT ]")
            print("\n==================================================================\n")
            choice = int(input("-> VEUILLEZ SAISIR UN NOMBRE ENTIER: "))
            assert choice == 1 or choice == 2 or choice == 3
        except ValueError:
            print("\n!! VOUS AVEZ SAISI UNE VALEUR INCORRECTE !!")
            os.system("pause")
            os.system("cls")
            continue
        except AssertionError:
            print("\n!! VEUILLEZ FAIRE UN CHOIX ENTRE 1 & 3 !!\n")
            os.system("pause")
            os.system("cls")
            continue
        else:
            exact = True
    print("")

    # CASE TREATMENT
    if choice == 1:
        print("->LAUNCHING CODING PROGRAMS...")
        subprocess.Popen('C:\\laragon\\laragon.exe')
        subprocess.Popen('"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"')
        subprocess.Popen('C:\\Program Files\\Microsoft VS Code\\Code.exe')
        subprocess.Popen('C:\\Users\\shado\\AppData\\Local\\Discord\\Update.exe --processStart Discord.exe')
        print(" ! Sucessfully Launched !")
        
    elif choice == 2:
        pass
    elif choice == 3:
        print("\n===============================> ! AU REVOIR ! <===============================\n")
        running == False
        exit(0)
        quit(0)
