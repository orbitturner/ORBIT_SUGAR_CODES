import humanize_expression as hu
import humanize_number as hn
import digits_library as dl

def test_number_to_triples():
    assert hn.number_to_triples('43200240002') == ['43', '200', '240', '002']
    assert hn.number_to_triples('2') == ['2']


def test_triple2words():
    assert hn.triple2words('002', 2, 0, 0) == 'two million'
    assert hn.triple2words('1', 0, 0, 0) == 'one'
    assert hn.triple2words('209', 1, 0, 0) == 'two hundred and nine thousand'
    assert hn.triple2words('100', 0, 0, 0) == 'one hundred'


def test_number2words():
    assert hn.number2words('002') == 'two'
    assert hn.number2words('00000000990000000009') == 'nine hundred and ninety billion and nine'
    assert hn.number2words('54345433') == 'fifty-four million, three hundred and forty-five thousand, four hundred and thirty-three'


def test_valid_input():
    assert hu.valid_input('0456f', dl.operations) == False
    assert hu.valid_input('004', dl.operations) == True
    assert hu.valid_input('-9', dl.operations) == True
    assert hu.valid_input('-8+5=', dl.operations) == False
    assert hu.valid_input('+9=-4', dl.operations) == True
    assert hu.valid_input('+-9=-4', dl.operations) == True
    assert hu.valid_input('+-9=-4-', dl.operations) == False
