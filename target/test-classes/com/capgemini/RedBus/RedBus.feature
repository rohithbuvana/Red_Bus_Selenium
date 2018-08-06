Feature: Travel Booking in RedBus

Scenario: Successfull Booking

Given : that user loads the redbus page
When : User enters the source as "Pune"
And : User enters the destination as "Chennai"
And : User enters the onward date as "17/08/2018"
And : User clicks on search buses button
And : User clicks on the view seats button
And : User selects the seat
And : User selects the boarding point
And : User clicks on proceed 
And : User enters the name as "Rohith"
And : User selects gender as "Male"
And : User enters age as"21"
And : User enters the email as "rr@gmail.com"
And : User enters the phone number as "9444011312"
And : User clicks proceed to pay
Then : the user booked successfully
