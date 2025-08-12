<h1><strong>Yondoru — Pomodoro Timer Application</strong></h1>
<p>Yondoru is a <strong>Pomodoro timer application</strong> designed to help users <em>efficiently manage their work and break intervals</em>. 
With a simple and intuitive interface, Yondoru lets you <strong>start, pause, and reset timers</strong>, customize durations for work sessions and breaks, and even <strong>switch between light and dark themes</strong> to suit your preference.</p>

<hr>

<h2>Features:</h2>
<ul>
    <li>Simple <strong>Start / Pause / Reset</strong> timer controls</li>
    <li>Customizable <strong>work and break durations</strong></li>
    <li>Toggle between <strong>light and dark themes</strong></li>
    <li>Clean and responsive user interface</li>
    <li>Built with <strong>JavaFX</strong>, styled with <strong>CSS</strong></li>
    <li><strong>Maven-based</strong> build system for easy compilation and packaging</li>
</ul>

<hr>

<h2>🖼️ Visual Overview</h2>

<table>
  <tr>
    <td align="center">
      <img src="screenshots/ss1.png" alt="Yondoru Main Screen (Light Theme)" width="300"><br>
      <em>Main Timer Screen (Light Theme)</em>
    </td>
    <td align="center">
      <img src="screenshots/ss3.png" alt="Yondoru Main Screen (Dark Theme)" width="300"><br>
      <em>Main Timer Screen (Dark Theme)</em>
    </td>
    <td align="center">
      <img src="screenshots/ss2.png" alt="Yondoru Alarm Timer Screen" width="300"><br>
      <em>Alarm Timer</em>
    </td>
  </tr>
</table>

<hr>

  </pre> <hr> <h2>📂 File Structure</h2> 
   <pre>
   Directory structure:
└── ishraqgit-yondoru/
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   ├── module-info.java
    │       │   └── com/
    │       │       └── example/
    │       │           └── demo6/
    │       │               ├── HelloApplication.java
    │       │               ├── HelloController.java
    │       │               └── tempCodeRunnerFile.java
    │       └── resources/
    │           └── com/
    │               └── example/
    │                   └── demo6/
    │                       ├── dark.css
    │                       ├── hello-view.fxml
    │                       └── light.css
    └── .mvn/
        └── wrapper/
            └── maven-wrapper.properties 
   </pre> <hr> <h2>
   
   📚 Project Modules</h2> <h3>1️⃣ Application Entry Point</h3> <p>The entry point of Yondoru is the <code>HelloApplication</code> class, which launches the JavaFX application and loads the main FXML layout with initial CSS styling.</p> <strong>Key responsibilities:</strong> <ul> <li>Initialize the JavaFX stage and scene</li> <li>Load the main user interface from FXML</li> <li>Apply default stylesheet (light or dark theme)</li> </ul> <h3>2️⃣ User Interface Definition (FXML)</h3> <p>The UI is defined using <strong>FXML</strong>, separating visual layout from application logic. This makes it easy to customize and switch themes.</p> <strong>Components:</strong> <ul> <li>Timer display label</li> <li>Start, Pause, and Reset buttons</li> <li>Settings panel <em>(future expansion)</em></li> <li>Theme toggle controls</li> </ul> <h3>3️⃣ UI Controller Logic</h3> <p>The <code>HelloController</code> class handles user interactions, button clicks, and UI updates.</p> <strong>Responsibilities:</strong> <ul> <li>Handle Start / Pause / Reset events</li> <li>Update timer display every second</li> <li>Respond to theme toggle input</li> <li>Validate timer customization inputs</li> </ul> <h3>4️⃣ Pomodoro Timer Core Logic</h3> <p>The core logic manages the countdown, session transitions, and timing behavior.</p> <strong>Features:</strong> <ul> <li>Countdown timer implementation</li> <li>Automatic switching between work and break sessions</li> <li>Pause / Resume functionality</li> <li>Event listeners for timer completion</li> </ul> <h3>5️⃣ Application Styling (CSS)</h3> <p>Styling is handled via <strong>external CSS files</strong>, enabling light/dark mode switching.</p> <strong>Details:</strong> <ul> <li>Base styles for fonts, colors, and spacing</li> <li>Separate <code>light.css</code> and <code>dark.css</code> files</li> <li>Dynamic stylesheet switching from the controller</li> </ul> <h3>6️⃣ Maven Build System</h3> <p>Maven manages the build lifecycle, dependencies, and packaging.</p> <strong>Highlights:</strong> <ul> <li>Dependency management (JavaFX libraries)</li> <li>Build commands for compiling and running</li> <li>Packaging into JAR or native bundles <em>(planned)</em></li> </ul> <hr> <h2>⚙️ How to Use</h2> <h3>Prerequisites</h3> <ul> <li>Java <strong>JDK 11+</strong></li> <li>Maven installed</li> <li>Compatible IDE (IntelliJ IDEA, Eclipse, etc.) or terminal access</li> </ul> <h3>Setup & Running</h3> <ol> <li>Clone the repository: <pre><code>git clone https://github.com/IshraqGit/Yondoru.git cd Yondoru</code></pre></li>

   <li>Build the project:
<pre><code>mvn clean install</code></pre></li>

<li>Run the application:
<pre><code>mvn javafx:run</code></pre></li>

</p> <hr> <h2>🛠️ Contributing</h2> <p>Contributions are welcome!</p> <strong>Steps to contribute:</strong> <ol> <li>Fork the repo</li> <li>Create a new branch: <pre><code>git checkout -b feature-name</code></pre></li>

<li>Commit your changes:
<pre><code>git commit -m "Add some feature"</code></pre></li>

<li>Push the branch:
<pre><code>git push origin feature-name</code></pre></li>

<li>Open a pull request</li>


</ol> <hr> <h2>📄 License</h2> <p>This project is licensed under the <strong>MIT License</strong>. See the <code>LICENSE</code> file for details.</p> </body> </html> 
