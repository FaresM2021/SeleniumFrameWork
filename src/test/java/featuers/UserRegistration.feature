Feature: User Registration
	I want to check that the user can registration in our e-comerce website
	
	Scenario Outline: User Registration
	Given the user in the home page
	When I click on register link
	And I entred "<firstname>" , "<lastname>" , "<email>" , "<password>"
	Then The registration page displayed successfully
	
	Examples:
		| firstname | lastname | email | password |
		| aziz | mohamed | m.mohamedc744@gmail.com | 123456 |
		| aziz | mohamed | m.mohamedc715034@gmail.com | 123456 |
		| omar | fares   | m.djfbzsdj74@gmail.com   | 415697 |