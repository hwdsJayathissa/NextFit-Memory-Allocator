Next Fit Memory Allocation

Overview
This project implements the Next Fit Memory Allocation Algorithm with a user-friendly Graphical User Interface (GUI) developed using Java Swing. It allows users to input memory block sizes and process sizes, then efficiently allocates processes to memory blocks using the Next Fit strategy.

Features 

◾Input Validation: Ensures valid memory block and process sizes.

◾Graphical User Interface: User-friendly UI for input and results display.

◾Next Fit Algorithm: Accurate implementation of the Next Fit memory allocation logic.

◾Real-Time Results: Displays the memory allocation outcome instantly.

◾Edge Case Handling: Handles cases like memory wrapping and processes larger than blocks.


Technologies Used

◾Programming Language: Java


Framework/Tools:

◾Java Swing for GUI development

◾Eclipse IDE for coding

◾GitHub for version control

Design Pattern: Model-View-Controller (MVC)


Code Structure

The project is organized into the following key files:

◾NextFitAllocator.java

  Contains the core logic of the Next Fit memory allocation algorithm.
  
◾AllocateButtonListener.java

  Manages event handling between the GUI and the allocation logic.
  
◾MainFrame.java

  Sets up the GUI components like input fields, result display area, and buttons.
  
How to Run the Project


Prerequisites

◾Java Development Kit (JDK) installed (Java 8 or above).

◾Eclipse IDE or any Java IDE of your choice.


Steps to Run

◾Clone the repository to your local machine:

git clone https://github.com/yourusername/NextFitMemoryAllocation.git

◾Open the project in your Java IDE (e.g., Eclipse).

◾Compile and run the MainFrame.java file.

◾Enter memory block sizes and process sizes into the input fields.

◾Click the "Allocate" button to see the results.


Next Fit Algorithm Explanation

The Next Fit Algorithm works as follows:

◾Start from the last allocated memory block.

◾Allocate the next process to the next available block that fits the process size.

◾If the end of the list is reached, wrap around to the beginning.
