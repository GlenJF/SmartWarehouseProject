# Smart Warehouse

## Description
The project simulates a smart warehouse environment using gRPC (Google Remote Procedure Call). It consists of three services:

- **Light Sensor Service**: This service senses luminance (brightness) levels and adjusts brightness based on server responses.
- **Motion Sensor Service**: Detects motion in the warehouse and sends alert messages to the server.
- **Thermostat Service**: Streams temperature data upon request and provides the current temperature through a unary request.

## Objectives
Each service has the following objectives:
- **Light Sensor Service**: To dynamically adjust the brightness in the warehouse based on the luminance levels detected.
- **Motion Sensor Service**: To detect motion within the warehouse and provide real-time alerts to enhance security.
- **Thermostat Service**: To monitor and control the temperature in the warehouse, providing both streaming data and current temperature upon request.

## Installation
To run the Smart Warehouse project, follow these steps:
1. Unzip the project folder named "Code".
2. Open the project folder named "SmartwarehouseProject" inside the "Code" folder on IntelliJ IDEA.
3. Open each service's server in separate windows (this is located in the java folder under main).
4. Run the server files for each service first.
5. Follow the instructions to run the client files below after starting the respective servers.
6. The project will display information and interact via the console.

## How to Start the Clients
### Starting the Servers
Before starting the clients, ensure that the servers are running. This can be done by selecting the "Run" option in IntelliJ IDEA, which is located at the top of the IDE or Right-click on the class file named server and select "Run "----server".main()".
(Each of the services have their own server class)

### Starting the Clients Individually
1. Open the SmartWarehouseManager class in IntelliJ IDEA.
2. Right-click on the 2SmartWarehouseManager" class file and select "Run SmartWarehouseManager.main()".
3. This will launch the Smart Warehouse Manager application.
4. Once the application window is open, follow the on-screen instructions to start individual clients by entering the corresponding option number.

## Communication Output
Communication messages between the clients and servers will be displayed on the console. It is recommended to monitor the console output for real-time updates on client-server communication.

## Note
It is preferred to start the clients individually rather than starting all at once to ensure smoother communication and better control over the warehouse management system.

## Credits



