# Library Management System

## Overview

The **Library Management System** is a Java-based application designed to manage the functionalities of a library, such as adding books, removing books, borrowing books, and displaying book information. It allows users (librarians and members) to interact with the system to manage library operations.

This system consists of different types of books (Fiction, Non-Fiction) and provides an interface for librarians and members to perform operations in a multi-threaded environment using locks to ensure thread safety.

## Features

- **Add Books**: Librarians can add different types of books (Fiction and Non-Fiction) to the library.
- **Remove Books**: Librarians can remove books from the library by title.
- **Borrow Books**: Members can borrow books that are available.
- **Display Book Information**: Display details such as title, author, genre/subject, and availability status.
- **Show All Books**: View a list of all books currently available in the library.
- **Thread Safety**: Implemented using locks to ensure that concurrent access to shared resources (such as adding/removing books) is handled safely.

## Class Structure

### 1. `Book` (Abstract Class)
- Represents a general book in the library.
- Contains fields such as `title`, `author`, `isbn`, and `isAvailable`.
- Provides common functionality for all books such as displaying book information and setting availability.

### 2. `FictionBook` (Subclass of `Book`)
- Extends the `Book` class.
- Adds a `genre` field specific to fiction books.
- Overrides `displayInfo()` to include genre information.

### 3. `NonFictionBook` (Subclass of `Book`)
- Extends the `Book` class.
- Adds a `subject` field specific to non-fiction books.
- Overrides `displayInfo()` to include subject information.

### 4. `Library`
- Manages a collection of books.
- Provides methods to add books, remove books, and retrieve books by title.
- Displays information about all books.

### 5. `Librarian`
- Implements the `LibraryOperations` interface to manage books.
- Provides thread-safe operations to add and remove books, as well as borrow books.
- Uses a lock (`ReentrantLock`) to prevent concurrent modification issues.

### 6. `Member`
- Represents a library member.
- Allows members to borrow books, checking the availability status before borrowing.

### 7. `LibraryManagementSystem`
- The main class that provides an interactive console menu for managing the library.
- Uses a `Scanner` to accept user input for various operations.
- Runs an interactive loop allowing users to perform different library operations.

### 8. `LibraryOperations` (Interface)
- Defines the operations that a librarian can perform, including adding, removing, borrowing books, and displaying book information.

## Dependencies

- Java 8 or later (for using `java.util.concurrent.locks`)

## How to Run

1. Clone the repository.
2. Compile the Java files.
3. Run the `LibraryManagementSystem` class to start the interactive console interface.
4. Follow the on-screen instructions to perform operations.

### Example Run:

Library Management System
1. Add Books
2. Remove Books
3. Borrow Books
4. Display Book Information
5. Show All Books
6. Exit
Enter your choice: 1
Enter the type of book to add (1 for Fiction, 2 for Non-Fiction): 1
Enter the book title: The Hobbit
Enter the author's name: J.R.R. Tolkien
Enter the book's ISBN: 978-0-345-33968-3
Enter the genre of the Fiction book: Fantasy
Bob Smith added the book titled: The Hobbit  
  

## Key Sections in the README:

- **Overview**: Provides a brief explanation of the project.
- **Features**: Lists the functionalities provided by the system.
- **Class Structure**: Describes each important class and its role in the system.
- **Dependencies**: Lists the required environment (Java version).
- **How to Run**: Gives clear instructions on how to compile and run the project.
- **Example Run**: Provides a sample output to help users understand how to interact with the system.
- **License**: Information on the project's license (here using MIT as an example). 

Feel free to adjust any details based on your preferences or project specifics!
