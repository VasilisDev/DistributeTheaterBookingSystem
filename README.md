# DistributeTheaterBookingSystem

A simple theater booking system in java RMI.The application gives to Client the ability to book a ticket,cancel his reservation,to show the list of the guests of the show and to see all the tiers of theatre and their cost.To execute the app follow the below commands:
 <dl>
 <dt>First of all compile all .java files :</dt>
   <dd>```javac *.java```</dd>
 
 <dt>Hit this command for the rmiregistry which acts as a dns server (or a middleware) :</dt>
   <dd>`rmiregistry &port`</dd>
 
 <dt>Run the Server side :</dt>
 <dd>```java TheaterServer```</dd>
 
 <dt> Run the Client Side: </dt>
 <dd>```java TheaterClient```<dd>
 
 <dt> To see all the parameters who want to run:<dt>
  <dd>```java TheaterServer```<dd>
 
<dt> To see all the tiers,available positions and their cost:</dt>
<dd>```java TheaterClient list localhost```<dd>
 
<dt> To book tickets:</dt>
<dd>```java TheaterClient book localhost position type number of positions  client name```</dd>
 
<dt> To see the guests of the show:</dt>
<dd>```java TheaterClient guests localhost```</dd>
 
<dt> To cancel a ticket:</dt>
<dd>```java TheaterClient cancel localhost position type  number of positions client name```</dd>
 </dl>
