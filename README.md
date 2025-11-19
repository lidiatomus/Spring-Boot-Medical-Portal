

# ⚕️ Spring Boot OOP Medical Portal

A back-end application developed using **Spring Boot** and the **MVC (Model-View-Controller) pattern** to manage and display core medical entities (Patients, Doctors, Diseases, Departments, and Prescriptions). This project's primary focus is demonstrating strong **Object-Oriented Programming (OOP) principles**, particularly **inheritance** and **polymorphism**, in modeling complex, specialized real-world concepts.

> **Note:** This is a demonstration project using **in-memory services** (data is volatile and resets upon restart) to showcase the service layer logic without an external database connection.

-----

## 💻 Technology Stack

  * **Framework:** **Spring Boot**
  * **Language:** Java
  * **Architecture:** MVC (Model-View-Controller) Pattern
  * **Data Handling:** **In-Memory Services**
  * **Templating:** Assumes **Thymeleaf** or similar engine for rendering views based on the `*Controller.java` classes.

-----

## ✨ OOP Design Highlights

The application features two distinct, polymorphic class hierarchies to handle specialized data, which is demonstrated via the Service layer logic.


### **I. Disease Hierarchy**

The `Disease` model is designed to handle different types of medical conditions polymorphically:

  * **`Disease` (Base Class):** Common fields like `name`, `symptoms`, and `prevention`.
  * **`ChronicDisease` (Extends `Disease`):** Adds unique property: `managementPlan`.
  * **`InfectiousDisease` (Extends `Disease`):** Adds unique properties: `transmissionMode` and `isVaccinatable`.

### **II. Department Hierarchy**

Hospital departments are abstracted to manage common and specialized characteristics:

  * **`BaseDepartment` (Abstract Base Class):** Common fields (`id`, `name`) and an abstract method `getDetails()`.
  * **`Department` (General):** Simple general-purpose department.
  * **`DiagnosticDepartment` (Extends `BaseDepartment`):** Adds a unique property: `numberOfDiagnosticMachines`.
  * **`SurgicalDepartment` (Extends `BaseDepartment`):** Adds a unique property: `numberOfOperatingRooms`.

-----

## 🏥 Core Features & Functionality

The application uses dedicated **Service** layers (`*Service.java`) for business logic and **Controller** layers (`*Controller.java`) for web routing and orchestration.

| Feature | Routes | Description |
| :--- | :--- | :--- |
| **Patient Management** | `/patients` | CRUD operations for patient records. Supports linking patients to diseases and adding prescriptions. |
| **Doctor Management** | `/doctors` | Manages doctor records. Includes **appointing** and **removing** patients from a doctor's workload. |
| **Disease Management** | `/disease` | Displays a polymorphic list of diseases. Supports adding new diseases (Chronic/Infectious) via form submission. |
| **Prescription Management**| `/prescriptions` | Full **CRUD** functionality (Create, Read, Update, Delete) for prescriptions, managed by `PrescriptionController`. |
| **Department Listings** | `/departments` | Lists all specialized departments, demonstrating polymorphism via the `getDetails()` method to show machine/room counts. |
| **Contact/Home** | `/`, `/contact` | Basic application entry point and contact information view. |

-----

## 📂 Project Structure

| File/Component | Layer | Description |
| :--- | :--- | :--- |
| `MedicalDemoApplication.java` | Spring Entry | Main class to run the Spring Boot application. |
| `*.java` (Model) | Model | `Patient`, `Doctor`, `Prescription`, and the Disease/Department hierarchies. |
| `*Service.java` | Service Layer | Implements the **business logic** and manages the **in-memory** data lists for all entities. |
| `*Controller.java` | Controller Layer | Handles web requests (`@GetMapping`, `@PostMapping`), calls Service methods, and selects the appropriate view. |

-----


### Prerequisites

  * Java Development Kit (JDK) 17 or newer.
  * Maven or Gradle (used by Spring Boot for dependency management).



