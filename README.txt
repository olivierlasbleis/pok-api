API to calculate probability to win a hand of poker

====================================================
HOW TO SUBSCRIBE ?

To use it you need to subscribe to an api key first with a get to the url: https://pok-api.herokuapp.com/getApiKey
It give you as response for exemple "dinsszqgkljpjoafirngtfi"

This api key allow you to make 100 request per 24 hours to calculate the probability to win any hand of poker.

====================================================
HOW TO USE IT IT ?

you can make a get request to the url :
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=YOUR_API_KEY&carte1=YOUR_CARD&carte2=YOUR_CARD&carte3=YOUR_CARD&carte4=YOUR_CARD&carte5=YOUR_CARD&carte6=YOUR_CARD&carte7=YOUR_CARD

as you can see the url can be divide in several parts:
_ the main url : https://pok-api.herokuapp.com/obtenirPrevision
_ the api key part : ?apiKey=YOUR_API_KEY
_ the cards part : &carte1=YOUR_CARD&carte2=YOUR_CARD&carte3=YOUR_CARD&carte4=YOUR_CARD&carte5=YOUR_CARD&carte6=YOUR_CARD&carte7=YOUR_CARD
where the two first cards are the cards in the player's hand (not common cards) and the others are the cards on the board (common cards)

you can ask for the probability with at leat 5 cards : &carte1=YOUR_CARD&carte2=YOUR_CARD&carte3=YOUR_CARD&carte4=YOUR_CARD&carte5=YOUR_CARD
or 6 cards : &carte1=YOUR_CARD&carte2=YOUR_CARD&carte3=YOUR_CARD&carte4=YOUR_CARD&carte5=YOUR_CARD&carte6=YOUR_CARD
or a maximum of 7 cards : &carte1=YOUR_CARD&carte2=YOUR_CARD&carte3=YOUR_CARD&carte4=YOUR_CARD&carte5=YOUR_CARD&carte6=YOUR_CARD&carte7=YOUR_CARD

HOW TO REPRESENT A CARD:
each card is represented by two parameters, the first is the value and the second is the color.
As: A, King: K, Queen: Q, Jack: J, Ten:10, Nine: 9, Eight: 8, Seven: 7, Six: 6, Five: 5, Four: 4, Three: 3, Two: 2.
Diamond: d, Heart: h, Spade: s, Club: c.

EXEMPLE: 
I have King of diamonds and Queen of diamonds in my hand, the board is seven of clubs, six of clubs and As of Spades.
the url to obtain my probability to win or split is
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=dinsszqgkljpjoafirngtfi&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As
the following card on board is King of spades
the url to obtain my probability to win or split is
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=dinsszqgkljpjoafirngtfi&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As&carte6=Ks
the following card on board is King of clubs
the url to obtain my probability to win or split is
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=dinsszqgkljpjoafirngtfi&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As&carte6=Ks&carte7=Kc

For each request, the order of cards doesn't matter.
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=dinsszqgkljpjoafirngtfi&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As&carte6=Ks&carte7=Kc
is equal to 
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=dinsszqgkljpjoafirngtfi&carte1=Kc&carte2=Ks&carte3=As&carte4=6c&carte5=7c&carte6=Qd&carte7=Kd


====================================================
HOW TO INTERPRETE RESULTS ? 

The api give as results:
_"rangeDeGagne" which is an array of two dimensions of double [13][13] where each cell represent the probability to win against one particular hand. 
_"pourcentageDeGagne" which is a double and represent the percentage of hands of a hypothetical adversary that make you win
_"cartes" which is an array of objects card (with the attributes nomCarte and urlPhoto) and will help you to construct your web front.

EXEMPLES 1:
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=aukogapmnbfdbevcugwcq&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As&carte6=Ks&carte7=Kc
(GET WITH 7 CARDS)
give 

{"rangeDeGagne":[[0.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0]
		,[0.0,0.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,1.0,1.0,1.0,1.0]
		,[0.5,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,0.75,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,0.75,0.75,1.0,1.0,1.0,1.0,1.0,1.0,1.0]
		,[1.0,0.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0]
		,[1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,0.75,0.75,0.75,1.0,1.0,1.0,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,0.75,0.75,0.75,1.0,1.0,0.75,1.0,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,0.75,0.75,0.75,1.0,1.0,0.75,0.75,1.0,1.0]
		,[0.6666666666666666,1.0,0.6666666666666666,0.75,0.75,0.75,0.75,1.0,1.0,0.75,0.75,0.75,1.0]]          (--1--)
,"pourcentageDeGagne":0.9363636363636364                                                                              (--2--)
,"cartes":[{"nomCarte":"7c","urlPhoto":"http://www.hegerm.ch/images/cartes/7c.gif"}
	,{"nomCarte":"6c","urlPhoto":"http://www.hegerm.ch/images/cartes/6c.gif"}
	,{"nomCarte":"As","urlPhoto":"http://www.hegerm.ch/images/cartes/As.gif"}
	,{"nomCarte":"Ks","urlPhoto":"http://www.hegerm.ch/images/cartes/Ks.gif"}
	,{"nomCarte":"Kc","urlPhoto":"http://www.hegerm.ch/images/cartes/Kc.gif"}
	,{"nomCarte":"Kd","urlPhoto":"http://www.hegerm.ch/images/cartes/Kd.gif"}
	,{"nomCarte":"Qd","urlPhoto":"http://www.hegerm.ch/images/cartes/Qd.gif"}]         				(--3--)
}

(--number--) == comment

(--1--) 
"rangeDeGagne": is the representation of a winnning range according to the usual array with abscissa the more powerfull card As, King, Queen... and the ordinate 
[[AA,AK,AQ,AJ,AT,A9,A8,A7,A6,A5,A4,A3,A2]
,[AKs,KK,KQ,KJ,KT,K9,K8,K7,K6,K5,K4,K3,K2]
,[AQs,KQs,QQ,QJ,QT,Q9,Q8,Q7,Q6,Q5,Q4,Q3,Q2]
,[AJs,KJs,QJs,JJ,JT,J9,J8,J7,J6,J5,J4,J3,J2]
,[ATs,KTs,QTs,JTs,TT,T9,T8,T7,T6,T5,T4,T3,T2]
,[A9s,K9s,Q9s,J9s,T9s,99,98,97,96,95,94,93,92]
,[A8s,K8s,Q8s,J8s,T8s,98s,88,87,86,85,84,83,82]
,[A7s,K7s,Q7s,J7s,T7s,97s,87s,77,76,75,74,73,72]
,[A6s,K6s,Q6s,J6s,T6s,96s,86s,76,66,65,64,63,62]
,[A5s,K5s,Q5s,J5s,T5s,95s,85s,75,65s,55,54,53,52]
,[A4s,K4s,Q4s,J4s,T4s,94s,84s,74,64s,54s,44,43,42]
,[A3s,K3s,Q3s,J3s,T3s,93s,83s,73,63s,53s,43s,33,32]
,[A2s,K2s,Q2s,J2s,T2s,92s,82s,72s,62s,52s,42s,32s,22]]
The value inside each cell is the probavility to win again each combination.
In our exemple the player lose against all AA possibles,
			lose against all AK possibles,
			win against all AQ possibles,
			lose against all AKs possibles,
			win against 50% of AQs possibles (all hands possibles : AhQh AcQc, player win is adversary get have AhQh, and lose is adversary have AcQc) 

(--2--)
"pourcentageDeGagne": is the proportion of hand that the adversary can have who lost against the player.
In our exemple, player win against 93% of hands possibles of the adversary.

(--3--)
"cartes": is a list of objects that can help you to build your front web.
the attribute nomCarte is the name of the card and urlPhoto is a string you can put in <img src= to had a picture in your front.


EXEMPLES 2:
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=aukogapmnbfdbevcugwcq&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As&carte6=Ks
(GET WITH 6 CARDS)
The results are the same but you have to consider each result as a probability. Indeed it will depend of wich card will be shown as seventh card.
The api calculate all result and give you the exact probability.

EXEMPLES 3:
https://pok-api.herokuapp.com/obtenirPrevision?apiKey=aukogapmnbfdbevcugwcq&carte1=Kd&carte2=Qd&carte3=7c&carte4=6c&carte5=As
(GET WITH 5 CARDS)
The results are the same but you have to consider each result as a probability. Indeed it will depend of wich card will be shown as sixth and seventh card.
The api calculate an aproximation. 
It calculate exactly 50 configations possibles. The number 50 corespond to the square root of the 2500 configurations possibles. 
This use a statistical law who say that a square root of configuration can be use to represent an valuable aproximation of the result.


====================================================

IMPORTANT:

Each time the api calculate a result it save it in a database. 
If you make a get with 6 cards for exemple, the api look first if the result already exist, if it doesn't exist it calculate and save it, if it exist it don't calculate again and give it to you.
With this, the api become faster with time.
Indeed, a get with 6 cards without result already existing spend aproximatively 10 seconds, if the result exist it spend aproximatively 400ms.

