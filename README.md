<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="client/src/assets/banner-logo.png" alt="Logo" width="100%" height="150px">
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

The Coffee Book is a simple website that uses 2 models, full CRUD operations, microservices and a login/logout process.

Developed with Java Spring and MySQL in the backend and Angular in the frontend, styled with Material UI.

Designed for coffee lovers and those who want to share new ways of drinking coffee.

<div align="center">
    <img src="[class.diagram](https://res.cloudinary.com/drrxks8d9/image/upload/v1686169972/Coffee/usecase.diagram_gj9wlh.png)" alt="diagram" width="400" height="400">
    <img src="[usecase.diagram](https://res.cloudinary.com/drrxks8d9/image/upload/v1686169972/Coffee/class.diagram_pzguhs.png)" alt="diagram" width="400" height="400">
</div>

### Built With

* ![Spring][Spring]
* ![MySQL][MySQL]
* ![Angular][Angular]
* ![TypeScript][TypeScript]
* ![MaterialUI][MaterialUI]

## Getting Started

### Prerequisites

To run the application locally, you will need to open the server files in your preferred IDE (e.g., IntelliJ, Eclipse) and the client files in VSCode.

### Installation

1. Clone the repo

   ```sh $ git clone https://github.com/your_username_/Project-Name.git ```
   
2. Install NPM packages
   ```sh
   $ npm install
   ```
3. Enter your DB info in `resourses/aplication.properties`
   ```md
   spring.datasource.username=yourrootname
   spring.datasource.password=yourpassword
   ```
4. Run `FinalProjectApplication.java` in the server
5. And run the client whit the command 
   ```sh
   $ ng serve
   ``` 
6. Open the application in localhost 

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Functionalities

-  `Signup`: As a user you can sign up in the platform so that you can start creating and saving favorite coffees.
-  `Login`: As a user you can login to the platform so that you can edit or delete your coffees.
-  `Logout`: As a user you can logout from the platform.
-  `Profile`: As a user you can see the coffees you created as well as edit your profile data.
-  `Add coffees`: As a user you can add a coffee so that you can share it with the community.
-  `List coffees`: As a non/user you can see all coffees.
-  `See coffee details`: As a non/user you can see any coffee details.
-  `Search coffees`: As a non/user you can search coffees by name.
-  `Add to favorites`: As a user you can add a coffee to favorites so that you can save the coffees that you liked the most.
-  `Random coffee`: As a user you can click on the random link and it will show you a new coffee to discover.
-  `Coffee tweets`: As a non/user you can read a list of funny tweets about coffee.
-  `404`: As an non/user you can see a 404 page if you try to reach a page that does not exist.



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
