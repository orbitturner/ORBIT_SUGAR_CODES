# Just straight up connect by any means possible. https://gist.github.com/Ryanb58/43e8bf5a8935405c455c5b41f8f8a0a3
from ftplib import FTP_TLS

def connect():
    ftp = FTP_TLS()
    ftp.debugging = 2
    ftp.connect('localhost', 2121)
    ftp.login('developer', 'password')
    return ftp

ftp = connect()
ftp.retrlines('LIST')