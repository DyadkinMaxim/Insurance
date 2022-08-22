# Application development "Insurance premium calculation” 
Maxim Dyadkin

## Requiremenent
  ### Microservices:
  - Calculator Service:
    - Retrieve all Premiums
    - Retrieve one Premium using Id.
    - Add new Premium
  - Management Service:
    - Retrieve all TypeClasses(factor that depends on vehicle manufacturer)
    - Retrieve one TypeClass with TypeClass Name.
    - Add TypeClass
    - Update TypeClass
    - Delete TypeClass
    - Retrieve all Regions (representation of CSV data)
    - Retrieve one Region by its postcode
    - Manually add Region
    - Add all Regions from uploaded CSV
    - Delete Region

## Softwares Pre-requisite
  - Java 11
  - Maven 
  - Intellij Idea(latest version preferable)
  - H2 driver(latest version preferable) - I have chosen relational DB as it does match with the domain model and there are 
  no elements like cash where may be used NoSQL systems(like Redis)
  As it is not production level application
  - free ports 8080 and 8081
  - Postman(Optional)

## How to Run the project
  - Run Calculator and Management services
    - Top Intellij panel -> Run/Debug Configurations -> run CalculatorApplication and then run ManagementApplication
    - Both services should be running at the same time to achieve requirements.
    - It may be validated as message appears in the log: "Started Application-name in X seconds (JVM running for X)"
    - The app is running now :)
   
## How to Test the project
   - There are three Integration tests: RegionIT, TypeClassIT and PremiumIT. Each of them responsible for testing 
   corresponding business functionality. I think creating unit tests is redundant actitity as the project volume is not really big.
    - Management services should be running at the same time to achieve required data.
    - Tests may be run in manual way(run inside each test) or via Maven Intellij plugin(choose module -> Lifecycle -> test)
    - Also manual tests are available - Postman collection @insurance.postman_collection is located in the root of insurance module
     so this JSON may be imported in Postman and some operations can be tested manually. 

## Workflow
 General workflow regarding the task: user can  savePremium method, entry annual mileage, postcode and the name of car typeclass.
 Then Calculator will interact with Management and required data about regional and type class factors will be returned to Calculator.
 Finally some inner premium calculations execute and user will get Premium entity as reponse. Premium value there - is result factor of the Insuance.
 Regions may be uploaded from CSV, so regional factor value generates in random way from 0.0 to 2.0 there(According to the task).
 There are groups of records which have the same postcode, so in calculations I decided to select the record with minimal regional factor value
 (Does not violate requirements).
  
