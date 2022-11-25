# contact-app
A simple application that manages a list of contacts, allowing you to add, delete, edit, and view your contacts.

# Level:
Intermediate

# Learned:
- How to create a menu system
- Basic CRUD operations
- The basic structure of a state machine; state handling etc
- Inner classes
- Error checking and validation
- Using try-catch blocks with int parsing
- Using enums
- Using a static method
- Overriding the default toString method
- Using an ArrayList
- Proper use of the final keyword

# Example output

```
Welcome to your contact list. To navigate through the list, type the numbers beside the available options.

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
1
Q - Return to the main menu

To add a contact please enter in a name and two valid phone numbers.
Use the format: (NAME) (CELL PHONE) (HOME PHONE)
EXAMPLE: Jake 1-555-555-5555 1-444-444-4444

Jake 1-555-555-5555 1-444-444-4444
Your new contact has been added!

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
4
0 - NAME: Jake	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
2
Q - Return to the main menu
0 - NAME: Jake	CELL: 1-555-555-5555	HOME: 1-444-444-4444

To edit a contact please enter in the number shown at the start of the line for a contact.
0
You are currently editing the contact: NAME: Jake	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Change their name
2 - Change their cell number
3 - Change their home number
e
That was not a valid option
You are currently editing the contact: NAME: Jake	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Change their name
2 - Change their cell number
3 - Change their home number
4
That was not a valid contact number. It must be between 1 and 3
You are currently editing the contact: NAME: Jake	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Change their name
2 - Change their cell number
3 - Change their home number
4
That was not a valid contact number. It must be between 1 and 3
You are currently editing the contact: NAME: Jake	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Change their name
2 - Change their cell number
3 - Change their home number
1
Enter in the name you want to change it to: 
Sally
Your contact has been successfully updated!

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
4
0 - NAME: Sally	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
2
Q - Return to the main menu
0 - NAME: Sally	CELL: 1-555-555-5555	HOME: 1-444-444-4444

To edit a contact please enter in the number shown at the start of the line for a contact.
0
You are currently editing the contact: NAME: Sally	CELL: 1-555-555-5555	HOME: 1-444-444-4444

1 - Change their name
2 - Change their cell number
3 - Change their home number
2
Enter in the new cell number you want to change it to: 
1-555-555-5566
Your contact has been successfully updated!

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
2
Q - Return to the main menu
0 - NAME: Sally	CELL: 1-555-555-5566	HOME: 1-444-444-4444

To edit a contact please enter in the number shown at the start of the line for a contact.
0
You are currently editing the contact: NAME: Sally	CELL: 1-555-555-5566	HOME: 1-444-444-4444

1 - Change their name
2 - Change their cell number
3 - Change their home number
2
Enter in the new cell number you want to change it to: 
1-555-555-55554
Phone number is not valid! Format is: x-xxx-xxx-xxxx
That is an invalid phone number

Q - Return to the main menu
0 - NAME: Sally	CELL: 1-555-555-5566	HOME: 1-444-444-4444

To edit a contact please enter in the number shown at the start of the line for a contact.
q

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts
5

Your contact list is now empty

1 - Add a new contact
2 - Edit an existing contact
3 - Remove an existing contact
4 - Show all contacts
5 - Clear all contacts

```
