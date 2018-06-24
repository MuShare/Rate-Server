# Rate Assistant Server

This is the Web service of Rate Assistant.

We are working on the News Module now!

# API Document 
This is the REST API document for Rate Assistant.

### 1. Currency

(1)`api/currencies`

   - Get currency list.
   - method: GET
   - param:
      - lan(String): language of this device
      - rev(int): currency revision
   - return:
      - currencies(Array\<Currency>): currency list
      - revision(int): current revision