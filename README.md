# DistributeTheaterBookingSystem

<p>A simple theater booking system in java RMI.The application gives to Client the ability to book a ticket,cancel his reservation,to show the list of the guests of the show and to see all the tiers of theatre and their cost.To execute the app follow the below commands:</p>
 <dl>
 <dt>First of all compile all .java files :</dt>
  <dd>javac *.java</dd>
 
 <dt>Hit this command for the rmiregistry which acts as a dns server (or a middleware) :</dt>
 <dd>rmiregistry &port<p align="center">
  <img src="screenshots/1.jpg" >
</p></dd>
 
 <dt>Run the Server side :</dt>
 <dd>java TheaterServer<p align="center">
  <img src="screenshots/2.jpg" >
</p></dd>

  <dt> To see all the parameters who want to run:<dt>
  <dd>java TheaterClient<p align="center">
  <img src="screenshots/3.jpg" >
</p><dd>
 
  <dt> To see all the tiers,available positions and their cost:</dt>
  <dd>java TheaterClient list localhost<p align="center">
  <img src="screenshots/4.jpg" >
</p><dd>
 
  <dt> To book tickets:</dt>
  <dd>java TheaterClient book localhost [position type] [number of positions]  [client name]<p align="center">
  <img src="screenshots/5.jpg" >
</p></dd>
 
  <dt> To see the guests of the show:</dt>
  <dd>java TheaterClient guests localhost<p align="center">
  <img src="screenshots/6.jpg" >
</p></dd>
 
  <dt> To cancel a ticket:</dt>
  <dd>java TheaterClient cancel localhost [position type]  [number of positions] [client name]<p align="center">
  <img src="screenshots/7.jpg" >
</p></dd>
 </dl>
