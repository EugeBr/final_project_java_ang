<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="client/src/assets/banner-logo.png" alt="Logo" width="100%" height="200px">
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

The Coffee Book is a simple website that uses 2 models, full CRUD operations, and a login/logout process.

Developed with Java Spring and MySQL in the back end and Angular in the front end, styled with Material UI.

Developed for coffee lovers and those who want share new ways of drinking coffee.


### Built With

* [![Spring][Spring]][Next-url]
* [![MySQL][MySQL]][React-url]
* [![Angular][Angular]][Angular-url]
* [![TypeScript][TypeScript]][Svelte-url]
* [![MaterialUI][MaterialUI]][Laravel-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Getting Started

### Prerequisites

To run the application locally, you will need to open the server files in your preferred IDE (e.g., IntelliJ, Eclipse) and the client files in VSCode.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
3. Enter your DB info in `resourses/aplication.properties`
   ```md
   spring.datasource.username=root
   spring.datasource.password=ironhack
   ```
4. Run `FinalProjectApplication.java` in the server
5. And run the client whit the command 
   ```sh
   ng serve
   ``` 
6. Open the application in localhost 

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## User Stories

-  `Signup`: As a user I can sign up in the platform so that I can start creating saving favorite coffees.
-  `Login`: As a user I can login to the platform so that I can edit or delete my coffees.
-  `Logout`: As a user I can logout from the platform.
-  `Profile`: As a user I can see the coffees I created as well as edit my profile data.
-  `Add coffees`: As a user I can add a coffee so that I can share it with the community.
-  `List coffees`: As a non/user I can see all coffees.
-  `See coffee details`: As a non/user I can see any coffee details.
-  `Search coffees`: As a non/user I can search coffees by name.
-  `Add to favorites`: As a user I can add a coffee to favorite so that I can save the coffees that I liked the most.
-  `Random coffee`: As a user I can click on the random link and it will show me a new coffee for me to discover.
-  `404`: As an non/user I can see a 404 page if I try to reach a page that does not exist.



<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png

[Spring]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[MySQL]: https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white
[Angular]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[TypeScript]: https://img.shields.io/badge/TypeScript-F7DF1E?style=for-the-badge&logo=typescript&logoColor=black
[MaterialUI]: https://img.shields.io/badge/Material%20UI-FF2D20?style=for-the-badge&logo=materialdesign&logoColor=white
