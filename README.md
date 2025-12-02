# In-Memory Transactional Key-Value Database

This project implements an in-memory key-value database with transaction support, following the specifications from the Data Processing and Storage assignment. The database supports a single active transaction, deferred updates, commit/rollback logic, and proper isolation ensuring uncommitted writes are never visible to `get()`.

---

## 🚀 How to Run the Code

### Prerequisites
- Java 17 or later  
- A terminal or IDE (VS Code, IntelliJ, etc.)

### Compile
Run:

javac InMemoryDB.java InMemoryDBImpl.java Main.java

### Run
Execute:

java Main

You should see output matching the assignment’s example, confirming that transactions are isolated, uncommitted writes remain invisible, and commit/rollback behave correctly.

Expected output example:

null  
Error: No open transaction.  
null  
6  
Error: No open transaction to commit.  
Error: No open transaction to rollback.  
null  
null  

---

## 📁 Project Structure

InMemoryDB.java        – Interface definition  
InMemoryDBImpl.java    – In-memory database implementation  
Main.java              – Test program demonstrating required behavior  

---

## 📝 Suggested Improvements to the Assignment

This assignment could be improved by providing clearer expectations around the visibility of uncommitted writes, since different database systems handle read isolation differently and the current instructions can be interpreted in multiple ways. More detailed example outputs for each method call would give students a stronger reference point and reduce ambiguity during implementation. Optional extensions such as nested transactions, transaction logs, or limited concurrency features could deepen the learning experience without drastically increasing complexity. Providing an automated test suite or script would also standardize grading and streamline the evaluation process for both students and graders.

---
