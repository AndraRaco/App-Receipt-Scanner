# App-Receipt-Scanner

An Android app (written in Kotlin) that scans a receipt and calculates how much an individual should pay/tip. Let's imagine for a moment how easy will it be to use this app as opposed to everyone having to calculate its share. The very first advantage is the fact that there will be no mistakes and we must be realistic, more often than not, splitting the bill results in a lot of mistakes. We either forgot to add a product or we even forgot that we have consumed it or virtually we mistype a number when we try to calculate and just with a simple mistake like that, everything goes south. This app makes it everything easy for us, which I believe is just the primary scope of day-to-day technology. 

## Requirements

- !!!!!!DE ADAUGAT DACA MAI E CEVA!!!!!!!
- every current version of Android 

## Installing

Once the app will have every feature ready, it will be published on Android Store and be available to the public.

## Describing the app - features list (descriere nontehnica- user stories, features list, descriere de componente, descriere de aspect)

**1. User's stories**

As a [type of user], I want [an action] so that [a benefit/a value]

1. As a waiter, I want a faster way to receive a higher tip so that I can put aside some money for a vacation.
2. As Karen, I want to organise my tips better so I can feel more in control.
3. As a restaurateur (restaurant owner), I want an app that increases the chance of my employees getting a tip after their service.
4. As Alex, I want to know how much I have to pay so that my friends won't discover that I don't know maths.
5. As an accountant, I want to make sure that the waiters don't make a mistake when they calculate change back to customers so that I have to pay less attention to that aspect.
6. As a waitress, I would like an app that makes customers pay a tip so that I can pay off my loans.
7. As a HR manager, I need to view the employees' tips so I can manage company personnel needs.
8. As Susan, I want to use an app when eating out so that I look younger.
9. As a customer, I want to view a list of products so I can select what I ordered.
10. As John, I want to link my credit card to my profile so that I can pay for a meal faster, easier and without using cash.
11. As Mary, I want to use an app that makes it easy so split a bill when going out with my friends.
12. As a math addict, I want to use a tip calculator so that I can get the formula behind the app. 
13. As a customer, I don't want to worry about who is going to foot the bill so that I can enjoy my going out.
14. As an user I want an app which will make my life easier so that I won't worry about how much I have to pay.
15. As a young teenager, I want to not stress myself about the bill so that I can have fun with my friends.
16. As a good mathematician, I don't want to constantly calculate how much should everyone pay, so as to get the split right.
17. As a waiter, I want the customers to have a great time so that I will receive tips. 

**2. Backlog Creation**

We monitorized our backlog creation using Trello. It can be found [here](https://trello.com/b/fLciePHL/receipt-scanner).


**3. How the app functions (features list)** (cred ca am inclus aici feature urile, daca lipseste cv adaugati)

Basically, the user can either opt for scanning a receipt or create a checklist. If he chose to scan an receipt, he will be asked to take a photo of the receipt or use a photo from the gallery. Either way, the scanner will build a list containing the products (name and price). The user can modify this checklist should it contain any mistakes by adding, deleting or clearing the list. These operations can be done by pressing the buttons having the same names. Alongside with the name of the product and the price, the checklist also contains a checkbox which allows the user to select that product. After the checklist is finalised, each buyer will select the products that he consumed by pressing the checkbox of the product. When he finishes, he will press 'Done' button and the total sum will appear on the screen. After he finishes, he will press delete and everything that he consumed and paid will be deleted. The next user takes the phone and begin the same process by selecting his products from the remaining ones.

**4. Follow up implementations (future features)**

As a following implementation, the developers will add a new column called quantity which will let the individual select how many products of this kind he has consumed. His part will be subtracted from the total after he presses 'Done' button. Another idea is to enable split option as a product could have been shared by multiple individual and once paid, it should be subtracted from the total. As a final step, we would like to merge everything and update the app so as to calculate how much should everyone pay and then invites the user to pay his share using a credit card. This thing can be implemented in accordance with restaurant's personnel. If the bill will come in this form instead of as a receipt on a paper. The consumer will not need to scan the receipt and then calculate. The restaurant's personnel should bring the bill in this format and the user should select their products and pay them using a credit card. Just like that the weiter's job gets easier because nobody will ask for a separate bill which is a daunting job when you have a lot of customers. Needless to say, the consumers will be deprived of having to calculate a lot in order to see how much he has to pay and the risk of making a mistake is virtually inexistent.

**5. App's component's  description** (descrierea de componente)
va trebui sa le luam pe rand si sa completam cate ceva la fiecare. daca am uitat ceva adaugati!! banuiesc ca vrea sa luam componentele din xml si sa explicam rolul lor

- **Home Page design** 
!! Sa adauge cine a facut-o pls !!

 - **Navigation drawer**
!la fel :(!

- **Scanner page**
!la fel :(!

- **Checklist's components** - a relative Layout which contains:
   - **TextView** - title of the page - Receipt List
   - **EditText** - textbox in which we write the name of the product we want to add, alongside with its price
   - **LinearLayout** - contains 3 Buttons (Add, Delete, Clear) each of them having a specific functionality. Add adds a                              new product (written in EditText box), Delete removes the selected item, Clear (deletes every                                  instance of the list)
   - **TextView** - marks the beginning the receipt list - My Receipt List 
   - **ListView** - dynamic list which contains the added items resulted from scanning and/or added through the Checklist 

**6. App's appearance (design description)** (mai trebuie adaugat aici - descriere de aspect) 

When the app is installed, the user will see the some pictures which presents the app's basic features. The app has also a navigation drawer whose purpose is to redirect the user to either the homepage, the Scanner or the Checklist. The homepage invites the user to select one of the app's functions (Load scanner or Open Checklist).

- **App Icon??**

- **Home Page design** 
!! Sa adauge cine a facut-o pls !!

- **Navigation drawer**
!la fel :(!

- **Scanner page**
!la fel :(!

- **Checklist**
!la fel :(!


## Describing the code (tehnical - contine diagrama de clase cu referinta la feature-uri; schema de design, lista si diagrama de clase, functii, proprietati, descriere tehnica de componenente)

la fel trebuie abordat pentru fiecare

## Protocoale de teste- structurate pe cap care sa corespunda descrierii anterioare, protocoale de testare care se ref la testele efectuate si la rezultatele lor


## Fisa de interventie care se ref la protocoalele de testare si la masurile luate
