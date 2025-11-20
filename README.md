# ISO2-2025-GrupoA2.2-Testing-P2

### ET.02.03 Second Problem: Airline Fares

You are required to design an algorithm that, based on the travel data of a potential airline customer (age, travel frequency, traveler type, preferred class, preferred destination, financial means, and the possibility of traveling with children), determines the most suitable fare type:

* **Pajarillo Fare:** If the customer is a minor and takes at least 6 flights per year, the fare offered should be “Pajarillo” (with a 10% discount off the flight price).
* **Gorrión Fare:** If the customer is between 18 and 25 years old and is studying at a university in another city, traveling in economy class from their family home at least once a month during the academic months between both cities, they should be offered the "Gorrión" fare (with a 15% discount off the flight price).
* **Young Traveler Fares:** * If the customer is between 18 and 25 years old, has started working but still lives with their parents, and takes at least three leisure trips a year in economy class, they should be offered the **"Travel While You Can"** fare (with a 5% discount off the flight price).
    * On the other hand, if they no longer live with their parents, they should be offered the **"Daring to Leave the Nest"** fare (with a 25% discount off the flight price).
* **Discover Europe Fares:** If the customer is over 25 years old, has an income above €20,000 but less than €35,000, and takes at least 6 trips a year in economy class to destinations within Europe, they may be offered the **"Discover Europe"** fare (with a 15% discount off the flight price); and if traveling with children (under 12 years old), they may be offered the **"Discover Europe with Your Little Ones"** fare (with a 10% discount off each ticket).
* **Discover the World Fares:** If the customer is over 25 years old, has an income above €35,000, and takes at least 6 trips a year in business class to destinations in Asia or America, they may be offered the **"Discover the World"** fare (with a 20% discount off the flight price); and if traveling with children (under 12 years old), they may be offered the **"Discover the World with Your Little Ones"** fare (with a 10% discount off each ticket).

*Note: It is assumed that no ambiguities exist regarding the type of offer that may be extended to a given customer. If any ambiguities are found, please write the assumptions and exceptions you consider most appropriate.*