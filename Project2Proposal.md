

###Project 1 Proposal###

####HHZX Trading Simulator####

__Team Composition:__<br>
Rong Huang,Shuai Huang,Jiawen Zhu,Tianrong Xiao

4/11/2016

---

####Table of Contents####

* 1 Project Overview 
  * 1.1 Abstract
  * 1.2 Target Customer
  * 1.3 Search Words
  * 1.4 Assumptions and Constraints
  * 1.5 Scope and Objectives
* 2 Team 
  * 2.1 Team Profile
  * 2.2 Constraints
  * 2.3 Challenges
* 3 Deliverables and Milestones
 * 3.1 Project Deliverables
 * 3.2 Schedule and Budget Summary


---

## 1.0	Project Overview
### 1.1 Abstract

Trading stock for profit is hard to carry out and very risky. Students will gain experience of and deeper understanding about the stock market by utilizing this software. As an old saying goes 'a picture is worth a thousand words'.Charts are the footprints of past stock movement and may help to predict the future. The software simulates the stock movement, and users are allowed to make trading decisions based on the charts. This software will help students to practice their trading skills.This software also would help students understand the significance of the stock market



### 1.2. Target Customer 

The client is Business and Social Science Division of Foothill. The software will help their students understand the stock market.
Our direct customers are students who are taking the Principles of Macroeconomics and Principle of Microeconomics classes. They will try out the game after class to gain a better understanding of the stock market.



### 1.3.	Search Words 
Stock Trading, Game, Software, Trading Simulator

### 1.4.	Assumptions 
  * Past stock movement has predictive value in the future movement
  * Students have little idea of how the stock market works


###1.5.	Scope and Objectives 
This software teaches student how to trade in a simulated stock market. The software uses historical data from real stock on the market right now to create a chart.First, the user would be given a certain amount of principal. Each day, only certain amount of the chart would be revealed to the users. The user will then rely on the chart to make trading decisions which are buying or selling his/her stock. Their performance would be assessed by the percentage of principal remained in their account. Then, the users would be ranked based on the percentage.The username, stock information, and the ranking would all be recorded in a database. 

The design of the software is the following:

The first window is the login window. It allows users to login to the game by inputing username and password:
If the user is new, the user can click the right corner of the window. 
![Image of first login page](https://github.com/FH-Sp16-CS40A-40820/team02-project01/blob/master/Design-Document/gui/1.png)

This is the same login window but for first time user only. It allow users to create a new account.
![Image of first time user login page](https://github.com/FH-Sp16-CS40A-40820/team02-project01/blob/master/Design-Document/gui/2.png)

This is our main window. First time users choose the stock they want to buy by looking at the chart. If they are satisfied with the current stock chart shown, they can start the game. Else, they can choose to see the next stock.When beginning the game, a user firstly has a principle of $10000. When the user decides to purchase certain stock, this money would all go into the market. Then the user can decide to see the next day or the next week or the next year’s data. Judging from the data and the amount of money the user has, the user can decide to hold on to the stock or sell the stock. The user’s performance in the game will be determined by the rate which calculated with the amount of money gained or lost by the user. This rate would then be used to rank different users. The ranking could be checked via the leaderboard:
![Image of the main window](https://github.com/FH-Sp16-CS40A-40820/team02-project01/blob/master/Design-Document/gui/3.jpg)

The last part of the design is the rank board which ranks users with the rate. The techniques that we could use during the project include building up a database, connecting the database to the java program, coding the GUI of the software, and developing algorithms:

![Image of the rankboard](https://github.com/FH-Sp16-CS40A-40820/team02-project01/blob/master/Design-Document/gui/4.png)

We would document the progress of our project through meeting minutes and work on each part of project on our own and share our code on the Github repository.
The priority task we have right now is to design a database that could hold the data and also designing the GUI of the software.



---

## 2.0	Team and Constraints

###2.1.	Team profile

* Rong Huang
  * Rong has taken CS1A,1B,1C,and Introduction to Database. As the project involved database,her experience in database would help.She could also help in coding the software from her experience in Java.

* Shuai Huang
  * Shuai has taken CS1A,B,C, and he has certainly the experience of GUI as he worked with Tianrong for the GUI project in CS1B. He is a fast learner too, as he thinks he is here to learn and cooperate.

* Jiawen Zhu(Evan)
  * Evan has taken CS1A,B,C, and he also has the experience of GUI as he participated in the project for CS1B. He is willing to coooerate with his teammates as well as put some good effect toward to the projects. He is also willing to learn SQL from other experienced team members. 

* Tianrong Xiao
  * He has taken CS1A, 1B, 1C, and he has good experience on Java, C++, and SQL. In addition, he’s good at GUI design.




### 2.2. Constraints
* Non-Technical Constraints:
  *There is little time to fully develop to a grand project
* Technical Constraints:
  * We will use SQL database as our back-end data store
  *The software is developed using Java and thus can be run under any operating system

### 2.3. Challenges
* Design a database schema that supports the application
* Collect stock historical price data and store it in the SQL server database along with other application data
* Game has reasonable equal difficulty levels for every player. The stock with low volatility is considered more difficult to profit from than the one with high volatility.
* Connecting the database with the software.


---

##3.0	Deliverables and Milestones

### 3.1.	Project Deliverables 

Deliverables include:
*	Software System Project Proposal
*	Design Document
*	User Manual
*	Presentation
*	Implementation Code




### 3.2.	Schedule and Budget Summary 
####Milestones

| Item                               | Date            |
| :----------------------------------|:----------------|
| Project Proposal                   | April 13, 2016  |
| Proposal Presentation              | April 14, 2016  |
| Create GUI                         | April 20,2016   |
| Create and populate the database   | April 20,2016   |
| Class Design                       | April 20,2016   |
| Sprint 1                           | April 21, 2016  |
| Implementation                     | April 22,2016   |
| Debugging                          | April 23,2016   |
| Testing                            | April 24,2016   |
| Demonstration and Delivery         | May 4, 2016     |


