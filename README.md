# App-Receipt-Scanner

An Android app (written in Kotlin) that scans a receipt and calculates how much an individual should pay/tip. Let's imagine for a moment how easy will it be to use this app as opposed to everyone having to calculate its share. The very first advantage is the fact that there will be no mistakes and we must be realistic, more often than not, splitting the bill results in a lot of mistakes. We either forgot to add a product or we even forgot that we have consumed it or virtually we mistype a number when we try to calculate and just with a simple mistake like that, everything goes south. This app makes it everything easy for us, which I believe is just the primary scope of day-to-day technology. 

## [App demo](https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/app_test.mp4)

## Requirements

- every current version of Android (works on 99.58% of the devices)

## Installing

Once the app will have every feature ready, it will be published on Android Store and be available to the public.

## Describing the app - (non-tehnical description - user stories, backlog creation, features list, design description, behavior description)

### 1. User stories

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

### 2. Backlog Creation

We monitorized our backlog creation using Trello. It can be found [here](https://trello.com/b/fLciePHL/receipt-scanner).

![](https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/Backlog%20creation.png)

### 3. Features list

- Scanning a receipt and extracting the product's name and price
- Creating a checklist from scratch
- Taking a photo of the receipt
- Chosing a photo from the gallery
- Creating a checklist based on the scan
- Editing a checklist
- Calculating the total sum that a individual has to pay based on his selection from the checklist
- Deleting an individual's selected products
- Clearing a checklist

### 4. App's behaviour description
    
Basically, the user can either opt for **scanning a receipt** or **create a checklist**. If he chose to scan an receipt, he will be asked to **take a photo of the receipt** or **use a photo from the gallery**. Either way, the scanner will **build a list** containing the products (name and price). The user can **modify this checklist** should it contain any mistakes by **adding/deleting a product or clearing the list**. These operations can be done by pressing the buttons having the same names. Alongside with the name of the product and the price, the checklist also contains a checkbox which allows the user to select that product. After the checklist is finalised, each buyer will select the products that he consumed by pressing the checkbox of the product. When he finishes, he will press 'Done' button and the **total sum will appear on the screen**. After he finishes, he will press delete and everything that he consumed and paid will be deleted. The next user takes the phone and begin the same process by selecting his products from the remaining ones.

### 5. Follow up implementations (future features)

As a following implementation, the developers will add a **new column called quantity** which will let the individual select how many products of this kind he has consumed. His part will be subtracted from the total after he presses 'Done' button. Another idea is to enable **split option** as a product could have been shared by multiple individual and once paid, it should be subtracted from the total. As a final step, we would like to merge everything and update the app so as to calculate how much should everyone pay and then invites the user to **pay his share using a credit card**. This thing can be implemented in accordance with restaurant's personnel. If the bill will come in this form instead of as a receipt on a paper. The consumer will not need to scan the receipt and then calculate. The restaurant's personnel should bring the bill in this format and the user should select their products and pay them using a credit card. Just like that the weiter's job gets easier because nobody will ask for a separate bill which is a daunting job when you have a lot of customers. Needless to say, the consumers will be deprived of having to calculate a lot in order to see how much he has to pay and the risk of making a mistake is virtually inexistent.

### 6. App's appearance (design description) 

When the app is installed, the user will see the three pictures which presents the app's basic features. The app has also a navigation drawer whose purpose is to redirect the user to either the homepage, the Scanner or the Checklist. The homepage invites the user to select one of the app's functions (Load scanner or Open Checklist).

- **App icon**

![](https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/App_icon.png)


- **Installation Pages design** - consists of three pictures aiming to present the app's functionalities.These apeears only the first time the app is installed. Every page has two buttons (Skip and Next) which can be found in **activity_slider.xml**.
   - **welcome_slider1.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- TextView - Welcome - <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- TextView - Ever felt tired of keeping track of the receipt? - 
    <br>
    <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/welcome_slider1.png" width = "335" height="650">
    
    - **welcome_slider2.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- TextView - We got you - <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- TextView - Just take a quick photo or chose one from your gallery -
    <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/welcome_slider2.png" width = "335" height="650">
    
    - **welcome_slider3.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- TextView - Sync - <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- TextView - Remember to save your information over the cloud with a simple login -
    <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/welcome_slider3.png" width = "335" height="650">
    
 - **Welcome Page design** - appears every time the app is opened
    - **activity_splash.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ProgressBar - <br>
    <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/welcome_page.png" width = "335" height="650">
    
 - **Home Page design** - 
    - **app_bar_main_drawer.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Twp Buttons (Load Scanner and Open Checklist) - <br>
    <br>
    <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/home_page.png" width = "335" height="650">
                       
- **Navigation drawer**
    - **activity_main_drawer.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- NavigationView implemented by Android  <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Two TextViews for username and passward <br>
    <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/Navigation_drawer.png" width = "335" height="650">


- **Scanner page**
    - **content_main_drawer.xml** <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- ImageView (here will appear the image) <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Twp Buttons (Select image - takes the user to the gallery in order to select an                  image and Recognise Text - scans the image that was selected) - <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- EditText (here will appear the text - names and prices of the products-) <br>
    
    **Chose an image option**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/chose_img.PNG" width = "335" height="650">
     
     **After the image was chosen**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/chose_img.PNG" width = "335" height="650">
     
     **Chose an image option**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/img_chosen.PNG" width = "335" height="650">
     
     **Text recognition function**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/Text_recognition.jpeg" width = "335" height="650">
     
     **Transform image into checklist**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/transformed_into_checklist.PNG" width = "335" height="650">
     

- **Checklist** - activity_checklist.xml - a relative Layout which contains:
   - **TextView** - title of the page - Receipt List
   - **EditText** - textbox in which we write the name of the product we want to add. The product is created based on **list_products.xml** which has two TextViews (Name and Price) and a checkbox.
   - **EditText** - textbox in which we write the price of the product we want to add
   - **LinearLayout** - contains 3 Buttons (Add, Delete, Clear, Done) each of them having a specific functionality. Add adds a                         new product (written in EditText box), Delete removes the selected item, Clear (deletes every                                 instance of the list, Done prints the total sum that has to be paid by an individual)
   - **TextView** - marks the beginning the receipt list - My Receipt List 
   - **ListView** - dynamic list which contains the added items resulted from scanning and/or added through the Checklist
   
    **Select an item using the checkbox**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/selected_item.PNG" width = "335" height="650">
     
     **Calculating the total sum by pressing Done**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/pressed_done.PNG" width = "335" height="650">
     
     **Deleting an item by pressing Delete**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/pressed_delete.PNG" width = "335" height="650">
     
     **Adding an item**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/adding_item.PNG" width = "335" height="650">
     
     **Item added**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/item_added.PNG" width = "335" height="650">
    
    **Clearing the list by pressing Clear**
     <br>
     <img src = "https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/pressed_clear.PNG" width = "335" height="650">
   
### 7. UML Use Case Diagram  

![](https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/UML_use_case.png)
   

## Source control

**Branches**: https://github.com/AndraRaco/App-Receipt-Scanner/branches

- **branch text-recognition** -  contains code that allows the user to select an image from the gallery or to take a picture which will be scanned. The scanner is programmed to extract the name of the product and its price;<br>
- **branch pickfromgallery** has code that allows the user to pick an image from gallery when pressing a button;<br>
- **branch ui-update** - was used to create a friendly-looking interface for the user;<br>
- **branch checklist** -  allows the user to add an item (name + value) to a list, to remove it from the list or to clear the whole list; then the app calculates the total price for the chosen products;

**Commits**: https://github.com/AndraRaco/App-Receipt-Scanner/commits

## Describing the code (tehnical - Classes Diagram in reference to features, Design Scheme, Functions and proprieties, Tehnical Description of behaviour)

- Splash
    - info: the first activity that starts when the app launches and acts as a welcome message/ loading page
    - type: AppCompatActivity
    - behaviour: starts every time the app launches, runs for 2 seconds and then reddirects to either slider activity or main activity, depending on wether or not the isFirstTime variable is true or false

- Slider
    - info: a sliding welcome message that briefly describes the app
    - type: AppCompatActivity
    - behaviour: loads the first time the user opens the app after an install/update and contains short messages to inform the user about new app functionalities
    - contains a skip button and a next button
  
  Code for Next Button
  ```
    btnNext.setOnClickListener(View.OnClickListener {
            if (viewPager.getCurrentItem() + 1 < layouts.size) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1)
            } else {
                //go to main activity
                //launcherManager.setFirstLaunch(false);
                startActivity(Intent(applicationContext, MainDrawer::class.java))
            }
        })
        
  ```
  
    Code for Skip Button
  ```
       btnSkip.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    MainDrawer::class.java
                )
            )
        })
        
  ```

- HomeFragment
    - info: part of the main activity, the app's homepage, with two buttons to load the checklist and scan activities
    - type: Fragment
    - behaviour: serves as the homepage and links to the checklist and scan functionalities of the app using 
    - elements: 
        - openchecklistpart
        
            - type: button
            - use: links the homepage to the checklist activity
            - code: 
            
                ```
                openchecklistpart.setOnClickListener {
                        var intent = Intent(
                            view.context,
                            ChecklistActivity::class.java
                        )
                        startActivity(intent)
                    }
                 ```
        - openscanpart
        
            - type: button
            - use: links the homepage to the checklist activity
            - code: 
            
                ```
                openscanpart.setOnClickListener {
                        var intent = Intent(
                            view.context,
                            MainTextRecognizer::class.java
                        )
                        startActivity(intent)
                    }
                 ```
- GalleryActivity
    - info: the app activity that extracts an image from the gallery or from a google drive account
    - type: AppCompatActivity
    - behaviour: the user selects an image, either from the camera or from the gallery or from a google drive account
   
   ```
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //BUTTON CLICK
        img_pick_btn.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }
    }
   ```
   Functions used:
   
 - Picks an image from Gallery
 ```
     private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

```


 -  Select an image
 
- MainTextRecognizer
    - info: the app activity that scans a given image
    - type: AppCompatActivity
    - behaviour: the user selects an image, either from the camera or from the gallery, then, using google's firebase ml ocr algorithms, the image is processed as text and saved as a list
    
Functions used:

 -  Select an image
 ```
  fun selectImage(v: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
    }
```

- Scanning the text
```
fun startRecognizing(v: View) {
        if (imageView.drawable != null) {
            editText.setText("")
            v.isEnabled = false
            val bitmap = (imageView.drawable as BitmapDrawable).bitmap
            val image = FirebaseVisionImage.fromBitmap(bitmap)
            val detector = FirebaseVision.getInstance().onDeviceTextRecognizer

            detector.processImage(image)
                .addOnSuccessListener { firebaseVisionText ->
                    v.isEnabled = true
                    processResultText(firebaseVisionText)

                    var toCheckList: List<String?>//list to send to checklist activity
                    toCheckList = ArrayList(50)

                    var products : List<Pair<Double, String>>//auxiliary list to make tochecklist
                    products = processResultText(firebaseVisionText)

                    for(x in products)
                        toCheckList.add(x.first.toString() + ',' +x.second)
                    //pass the products array to checklist for merging
                    val Checklist = Intent(this, ChecklistActivity::class.java)
                    Checklist.putExtra("Products", toCheckList)
                    startActivity(Checklist)

                }
                .addOnFailureListener {
                    v.isEnabled = true
                    editText.setText("Failed")
                }
        } else {
            Toast.makeText(this, "Select an Image First", Toast.LENGTH_LONG).show()
        }
    }
```
Other functions:

- Function for Processing the text 

```
    private fun processResultText(resultText: FirebaseVisionText) : List<Pair<Double, String>>  {

        var products : List<Pair<Double, String>>
        products = ArrayList(50)

        if (resultText.textBlocks.size == 0) {
            editText.setText("No Text Found")
            return products
        }

        for (block in resultText.textBlocks) {
            val blockText = block.text
            editText.append(blockText + "\n")
        }

        val tuples = getTuples(editText.text.toString())
        products = getTuples(editText.text.toString())
        editText.setText("")
        for (t in tuples) {
            editText.append(t.toString() + "\n")
        }
        return products
    }  
```
- Function for extracting the price and name of the products

```
    fun getTuples(text: String): List<Pair<Double, String>> {
     var products = mutableListOf<Pair<Double, String>>()
        var produs_crt = 0
        var pret_crt = 0
        var nume_crt = 0
        var started = false
        val lines = text.split("\n")
        for (line in lines) {
            if ("total" == line.toLowerCase(Locale.getDefault())
                || "*" in line.toLowerCase(Locale.getDefault())) {
                break
            }

            if ("x " in line.toLowerCase(Locale.getDefault())) {
                val trimmedLine = line.drop(line.toLowerCase(Locale.getDefault()).indexOf("x ") + 2)
                if (trimmedLine.isEmpty()) {
                    continue
                }
                val words = trimmedLine.split(' ')
                if (words.isNotEmpty()) {
                    if (words[0].toDoubleOrNull() != null) {
                        val nr = words[0].toDouble()
                        if (pret_crt == produs_crt) {
                            products.add(Pair(nr, ""))
                            produs_crt += 1
                            pret_crt += 1
                        } else {
                            products[pret_crt] = Pair(nr, products[pret_crt].second)
                            pret_crt += 1
                        }
                        started = true;
                    }
                }
            } else if (started
                && !line[0].isDigit()
                && "discount" !in line.toLowerCase(Locale.getDefault())
                && "total" !in line.toLowerCase(Locale.getDefault())
                && "lei" != line.toLowerCase(Locale.getDefault())
                && "lel" != line.toLowerCase(Locale.getDefault())) {

                if (nume_crt == produs_crt) {
                    products.add(Pair(0.toDouble(), line))
                    produs_crt += 1
                    nume_crt += 1
                } else {
                    products[nume_crt] = Pair(products[nume_crt].first, line)
                    nume_crt += 1
                }
            }
        }
        return products
    }
    
```
   These functions can be found in MainTextRecogniser.kt file.   

- ChecklistActivity
    - info: app activity that creates a checklist for easy recipie management
    - type: AppCompatActivity
    - behaviour: adds items from userimput as a pair < name, price >, stores them in a list and calculates the total of the selected items
    
 Functions used: 
 
 -  Add function which functions by pressing Add button
 
 ``` 
   add.setOnClickListener {
            addRow()
        }
 ```
      
  ```
        fun addRow() {
        val name = editText.text.toString()
        val price = et_price.text.toString().toDouble()
        val p = Product(name, price)
        itemlist.add(p)
        //listView.adapter =  adapter
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
        // This is because every time when you add the item the input space or the edit text space will be cleared
        editText.text.clear()
        et_price.text.clear()
    }
 ```
  
  -  Clear function which functions by pressing Clear button
  
 
```  
 clear.setOnClickListener {
            clearRows()
        }
 ```
 
 ```
    fun clearRows() {
        itemlist.clear()
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
    }
 ```
 
 - Delete function which functions by pressing Delete button

   
```     
    delete.setOnClickListener {
         deleteRow()
        }
``` 

```     fun deleteRow() {
        val position: SparseBooleanArray = listView.checkedItemPositions
        val count = listView.count
        var item = count - 1
        while (item >= 0) {
            if (position.get(item)) {
                itemlist.removeAt(item)
            }
            item--
        }
        position.clear()
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
    }
 ```
      
   -  Calculate sum function which functions by pressing Done button
   
 ``` 
 calculate.setOnClickListener {
            calculatePriceToPay()
        }
 ``` 
 
```  fun calculatePriceToPay() {
        val position: SparseBooleanArray = listView.checkedItemPositions
        val count = listView.count
        var sum: Double = 0.0

        var item = count - 1
        while (item >= 0) {
            if (position.get(item)) {
                val priceOfProduct = itemlist[item].price
                sum += priceOfProduct
            }
            item--
        }

        android.widget.Toast.makeText(
            this,
            "You have to pay $sum",
            android.widget.Toast.LENGTH_SHORT
        ).show()
    }
 ```
      
 These functions can be found in ChecklistActivity.kt file.   
  
    
## Build tools
Our project is developed using Andorid Studio IDE that has a Gradle-based building tool. When we want to build our project in an APK, so that we can give it to our users to install the application and use it, we go to:
![](https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/build_tools1.jpeg)


and click Build APK. Then, in the folder our project is in, it generates 2 files:
![](https://github.com/AndraRaco/App-Receipt-Scanner/blob/master/Docs/build_tools2.jpeg)

One of the file, "app-debug.apk", is the apk that will install our application, the other one, "output.json", is a message that tells us if the apk was generated succesfully or not. We then transfer the APK to our mobile device and run it to install the application.

## Protocoale de teste- structurate pe cap care sa corespunda descrierii anterioare, protocoale de testare care se ref la testele efectuate si la rezultatele lor


## Fisa de interventie care se ref la protocoalele de testare si la masurile luate
