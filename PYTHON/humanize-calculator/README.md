# humanize-calculator

Converts any math expression to words like "234/-7=0" > "two hundred and thirty-four divided by minus seven equals zero". 
As you see it doesn't check the correctness. 

Of course I could use num2words library to make my life easier. But…I chose another way and wrote my own conversion algorythm.
Each number is converted EXACTLY as in num2words python library.

Input info:
1) you can use digits and operations '+', '-', '*', '/', '=' only
2) spaces are ignored ("424    535" > |"424535"| > "four hundred and twenty-four thousand, five hundred and thirty-five")
3) invalid when there are two consecutive operation signs ("47 +- 9" > "input error") 
BUT! The following combinations are ok: "=-", "*-", "/-", "=+", "*+", "/+". 
4) cannot begin with '=', '/' and '*'
5) cannot end with an operation
6) maximum number length is 33 but you can change it buy adding another "-illion" to the illions list in digits_library.py

Please go to http://angelinalogvina.pythonanywhere.com to test it! 
