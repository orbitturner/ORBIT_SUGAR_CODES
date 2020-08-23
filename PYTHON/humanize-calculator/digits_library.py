operations = {
    '+': 'plus',
    '-': 'minus',
    '*': 'multiplied by',
    '/': 'divided by',
    '=': 'equals'
}

digits = [     #{𝑥|𝑥∈N_0 ∧ 𝑥≤9}, N_0 is {N ∧ {0}}
    "",        #zero=we don't write anything !!!!!!SPECIAL CASE
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine"
]

teens = [       #{𝑦|𝑦∈ℕ ∧ 𝑦≥10 ∧ 𝑦≤19}
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
]
tens = [        #{𝑧|𝑧∈ℕ ∧ 𝑧|10 ∧ 𝑧≥20 ∧ 𝑧≤100}
    "twenty",
    "thirty",
    "forty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety",
    "hundred"];

illions = [     #this list can be infinitely long
    "",
    "thousand",
    "million",
    "billion",
    "trillion",
    "quadrillion",
    "quintillion",
    "sextillion",
    "septillion",
    "octillion",
    "nonillion"
]