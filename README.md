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

### 2. Rate

(1)`api/rate/current`

   - Get current exchange rate.
   - method: GET
   - param:
      - from(String): physical id of from currency
      - to(String): physical id of to currency
   - return if from and to are not null at same time
      - rate(double): current exchange rate
   - return if from or to is not null
      - rates(Dictionary<String, double>): dictionary of currency physical id and current exchange rate. 

(2)`api/rate/history`

   - Get historical exchange rate.
   - method: GET
   - param:
      - from(String): physical id of from currency
      - to(String): physical id of to currency
      - start(long): start timestamp
      - end(long): end timestamp
   - return 
      - data(ChartData): historical exchange rate