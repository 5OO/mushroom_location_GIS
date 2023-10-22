This is app for maintaining mushroom locations. 

BE user can add, delete, modify and query mushroom location.  A location is characterized by name, location coordinates and description. The aim is to share inforamtion in free text what mushrooms can be found and  in that place. Aplication uses GeoJSON format as input-output for its services.
Adding, deleting, modifying are done one object at a time.
Data is read and saved from the PostgreSQL database. The services are free for everyone to use, authentication is not implemented.

Development plans for phase 2 is to create a web application, the UI, where it is possible to use services that  were created in the previous stage -> to display mushroom locations existing in database on a open source map and add new locations.
The map will be interactive - zoomable in and out, movable and limited to Estonia and its surroundings. The map will have a publicly available base map (Land Board, OpenStreetMap, etc.) as a background.

Initial view displays all database locations on the map.
Adding a new location is done by clicking on the desired place on the map with the mouse.


According to GeoJSON Specification (RFC 7946):
https://tools.ietf.org/html/rfc7946

GeoJSON is a format for encoding a variety of geographic data structures […]. A GeoJSON object may represent a region of space (a Geometry), a spatially bounded entity (a Feature), or a list of Features (a FeatureCollection). GeoJSON supports the following geometry types: Point, LineString, Polygon, MultiPoint, MultiLineString, MultiPolygon, and GeometryCollection. Features in GeoJSON contain a Geometry object and additional properties, and a FeatureCollection contains a list of Features.