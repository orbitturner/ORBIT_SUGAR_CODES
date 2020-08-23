import humanize_number as hn
import digits_library as dl
import re


def valid_input(expression, operations):
    if re.sub(r'[0-9\+\-\*\/\=]+', '', expression).strip() != '':
        return False

    if expression[0] in {'=', '/', '*'}:
        return False

    if expression[len(expression) - 1] in {'-', '+', '=', '/', '*'}:
        return False

    for opr in operations:
        if len(opr) > 1 and opr not in {'=-', '*-', '/-', '=+', '*+', '/+'}:
            return False
    return True


def expression2words(expression):
    syntax = re.sub(r'[0-9]+', 'N', expression)
    numexp = re.findall('\d+', expression)
    n = 0
    humanized_expression = ''

    for element in syntax:
        if element == 'N':
            humanized_expression = f'{humanized_expression} {hn.number2words(numexp[n])}'
            n += 1
        else:
            humanized_expression = f'{humanized_expression} {dl.operations[element]}'

    return humanized_expression.replace("  ", " ").strip()


def humanize_expression(expr):
    regex = re.compile('\d+')
    expr = expr.replace(" ", "")
    operations = regex.split(expr)
    if not valid_input(expr, operations):
        result = "invalid input"
    else:
        while '' in operations:
            operations.remove('')
        result = expression2words(expr)
    return result
