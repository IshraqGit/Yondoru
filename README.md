# Yondoru — Pomodoro Timer Application

Yondoru is a **Pomodoro timer application** designed to help users *efficiently manage their work and break intervals*. With a simple and intuitive interface, Yondoru lets you **start, pause, and reset timers**, customize durations for work sessions and breaks, and even **switch between light and dark themes** to suit your preference.

---

## 🚀 Features

- Simple **start/pause/reset** timer controls  
- Customizable **work and break durations**  
- Toggle between **light and dark themes**  
- Clean and responsive user interface  
- Built with JavaFX, styled with CSS  
- Maven-based build system for easy compilation and packaging  

---

## 🖼️ Visual Overview

<!-- Add project screenshots or UI images here -->
![Yondoru Main Screen](path/to/screenshot_main.png)
*Main Timer Screen with dark theme*

### Architecture Flowchart

```mermaid
flowchart TD
    A0["Application Entry Point"]
    A1["User Interface Definition (FXML)"]
    A2["UI Controller Logic"]
    A3["Pomodoro Timer Core Logic"]
    A4["Application Styling (CSS)"]
    A5["Maven Build System"]
    A0 -- "Loads" --> A1
    A0 -- "Applies Initial" --> A4
    A1 -- "Defines Controller" --> A2
    A2 -- "Manages Elements" --> A1
    A2 -- "Implements" --> A3
    A2 -- "Switches Styles" --> A4
    A3 -- "Updates UI" --> A2
    A5 -- "Builds" --> A0
    A5 -- "Packages Resources" --> A1
    A5 -- "Compiles Code" --> A2
    A5 -- "Packages Resources" --> A4
