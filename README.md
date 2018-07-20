# DistributeTheaterBookingSystem

A simple theater booking system in java RMI.The application gives to Client the ability to book a ticket,cancel his reservation,to show the list of the guests of the show and to see all the tiers of theatre and their cost.To execute the app follow the below commands:

0. First of all compile all .java files : javac *.java
1. Hit this command to for the rmiregistry which acts as a dns server (or a middleware) : rmiregistry &<port>
2. Run the Server side : java TheaterServer
3. Run the Client Side:
  a) To see all the parameters who want to run: java HotelClient
  b) To see all the tiers,available positions and their cost: java TheaterClient list localhost
  c) To book tickets: java TheaterClient book localhost <position type>  <number of positions> <client name>
  d) To see the guests of the show: java TheaterClient guests localhost
  e) To cancel a ticket: java TheaterClient cancel localhost <position type>  <number of positions> <client name>
  

