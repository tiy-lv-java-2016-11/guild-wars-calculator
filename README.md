# Guild Wars Calculator

![logo](gw2logo.jpg)

## Description
Time to play with a real world api to produce something useful for the players.  We are going to create a recipe pricer with the open data from the Guild Wars 2 API.

### Normal Mode
Use the documentation found on the [Wiki](https://wiki.guildwars2.com/wiki/API:2).

Create a spring project with the following components: web, devtools, moustache, jpa, postgres, h2
Add the following dependency to your `build.gradle` file
* compile("com.fasterxml.jackson.core:jackson-databind")


Create a page for the following:
* Page should take a recipe id in the url
* Page should display the basic information of the recipe including: 
	* id
	* type
	* description
	* rarity
* Use the items endpoint to get the name of the output item and display that as well
* Use the ingredients list to and the items endpoint get the information for each of the items
	* For each item get the current buy buyPrice from the prices endpoint
	* Display the buyPrice of the ingredient and the total buyPrice (ingredient buyPrice x the quantity required)
* Using the above prices display the total buyPrice of the item to create

#### Note: you do not need to create models for this mode

### Hard Mode
* Include the sell buyPrice of the output item
* Include the difference in prices between the buy ingredients and the sell buyPrice
* Include the skin images for all items on the page
* The recipes don't change almost ever so let's cache the results:
	* Create a recipe model to store the information the api returns in the recipe
	* Whenever the page is called the system should first check to see if it has the model in the database.  If not it should go to the api to retrieve it.

### Nightmare Mode
* Using the `listings` endpoint process all current data for the given item
* Display the high/low prices of each ingredient
* Display the Best/Worst case cost numbers for crafting the item.
* Display a graph of the current buy/sell orders for the output item so the user can see their potential for selling.

## Resources
* [Github Repo](https://github.com/tiy-lv-java-2016-11/guild-wars-calculator)
* [RestTemplate JavaDoc](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
* [RestTemplate Spring Example](https://spring.io/guides/gs/consuming-rest/)
