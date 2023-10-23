
# Mushroom Location Application

This is app for maintaining mushroom locations.  It consists of a Spring Boot backend (Java) and a Vue.js frontend.

BE user can add, delete, modify and query mushroom location.  A location is characterized by name, location coordinates and description. The aim is to share inforamtion in free text what mushrooms can be found and  in that place. Aplication uses GeoJSON format as input-output for its services.
Adding, deleting, modifying are done one object at a time.
Data is read and saved from the PostgreSQL database. The services are free for everyone to use, authentication is not implemented.

Development plans for phase 2 is to create a web application, the UI, where it is possible to use services that  were created in the previous stage -> to display mushroom locations existing in database on a open source map and add new locations.
The map will be interactive - zoomable in and out, movable. The map will have a publicly available base map OpenStreetMap as a background.

Initial view displays all database locations on the map.
Adding a new location is done by clicking on the desired place on the map with the mouse.


According to GeoJSON Specification (RFC 7946):
https://tools.ietf.org/html/rfc7946

GeoJSON is a format for encoding a variety of geographic data structures […]. A GeoJSON object may represent a region of space (a Geometry), a spatially bounded entity (a Feature), or a list of Features (a FeatureCollection). GeoJSON supports the following geometry types: Point, LineString, Polygon, MultiPoint, MultiLineString, MultiPolygon, and GeometryCollection. Features in GeoJSON contain a Geometry object and additional properties, and a FeatureCollection contains a list of Features.

# Setting Up and Running the Mushroom Location Application

### Prerequisites

* Java 17
* Node.js and npm
* PostgreSQL
* An IDE like IntelliJ IDEA or Visual Studio Code
 
## Backend Setup (Spring Boot with Java)

1. **Clone the Repository:** Clone the backend code repository to your local machine.
   git clone https://github.com/5OO/mushroom_location_GIS.git
2. **Database Setup:** Make sure PostgreSQL is installed and running. Create a new database named **mushroom_location_GIS**. 
3. **Configure Application Properties:** Open the **application.properties** file in the src/main/resources directory. Set the database connection properties to match your PostgreSQL setup.  
   *spring.datasource.url=jdbc:postgresql://localhost:5432/mushroom_location_GIS*  
   *spring.datasource.username=your_username*  
   *spring.datasource.password=your_password*    
4. **Run the Application:** You can run the application from your IDE, or navigate to the project directory in the terminal and run:  
   
   *./mvnw spring-boot:run*  

   This will start the Spring Boot application and run any Flyway migrations to set up the database schema.  

