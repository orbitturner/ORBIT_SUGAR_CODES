from flask import Flask, render_template, request
import humanize_expression as he
app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/', methods=['POST'])
def getvalue():
    expression = request.form['expr']
    res = he.humanize_expression(expression)
    s = '_______________________________________________'
    return render_template('index.html', n = expression, separator = s, numwords = res)


if  __name__ == "__main__":
    app.run(debug=True)

