# datacsv
demo: Spring boot with h2 database load data.csv on startup
db console enable at http://localhost:9030/dbconsole username/password:admin/admin url: jdbc:h2:mem:datadb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
api:
http://localhost:9030/data/count  //count all rows
http://localhost:9030/data/top?count={count}&lat1={lat1}&lon1={lon1}  //display top {count} points nearest to point {lat1} {lon1} 
  sample url http://localhost:9030/data/top?count=40&lat1=37.74540642941645&lon1=-122.39008122484672
  display top 40 points nearest to point lat=37.74540642941645 lon=-122.39008122484672
  result format as {locationid, location, distance}

csvclient: React app for load csv file
use command: npm start
url: localhost:3000


