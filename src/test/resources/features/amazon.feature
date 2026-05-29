Feature: Amazon Automation

Scenario: Verify Amazon Home Page Opens
Given User opens browser and launches Amazon website
Then Verify page title contains Amazon

Scenario: Search Headphones Product
Given User opens browser and launches Amazon website
When User searches for "headphones"
Then User scrolls down the page

Scenario: Go To Customer Service And Take Screenshot
Given User opens browser and launches Amazon website
When User clicks on customer service
And User takes screenshot

Scenario: Close Browser Successfully
Given User opens browser and launches Amazon website
Then Close browser