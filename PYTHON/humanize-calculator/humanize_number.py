import digits_library as dl


#let we have a number '12345678. Then the triples would be '12', '345' and '678.


def number_to_triples(num):
    triples = []
    for i in range(0, len(num), 3):
        triples.append(num[-3:])
        num = num[:-3]
    return list(reversed(triples))


def add_illion_suffix(triple, index):   #index: position of the triple
    if (not len(triple) == 0):
       triple = f"{triple} {dl.illions[index]}"
    return triple


def triple2words(triple, index, status, status2):
    triple_name = ""

    triple = triple.zfill(3)

    if status and not status2:
        if triple[0] == '0' and (triple[1] != '0' or triple[2] != '0'):
            triple_name += "and "

    triple_name += "" if triple[0] == '0' else dl.digits[int(triple[0])]

    if not triple[0] == '0':
        triple_name += " hundred"
        triple_name += " and " if triple[1] != '0' or triple[2] != '0' else ""
    else:
        triple_name += ""

    if (int(triple[1]) > 1):
        triple_name = f"{triple_name}{dl.tens[int(triple[1]) - 2]}"
        if int(triple[2]) != 0:
            triple_name = f"{triple_name}{'-'}"
        triple_name = f"{triple_name}{dl.digits[int(triple[2])]}"
    elif (int(triple[1]) == 1):
        triple_name = f"{triple_name}{dl.teens[(int(int(triple[1]) + int(triple[2])) % 10) - 1]}"
    elif (int(triple[1]) == 0):
        triple_name = f"{triple_name}{dl.digits[int(triple[2])]}"

    return add_illion_suffix(triple_name, index).strip()


def number2words(number):
    print(number, ": ", end="", flush=True)
    if number == '0':
        return "zero"
    triples_list = number_to_triples(str(number))
    number_of_triples = len(triples_list)

    humanized_triples = []
    status = False
    status2 = False
    if(number_of_triples == 1):
        status2 = True    #in case of one triple only
    for i in range(number_of_triples):
        if i == len(triples_list) - 1:
            status = True #in case of the last triple
        humanized_triples.append(
            triple2words(triples_list[i], number_of_triples-1, status, status2))
        number_of_triples -= 1

    while '' in humanized_triples:
        humanized_triples.remove('')
    s = ', '
    res = s.join(humanized_triples)
    return res.replace(", and", " and")




