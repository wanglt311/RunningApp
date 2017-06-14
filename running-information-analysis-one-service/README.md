Running Steps:

1.Download project running-information-analysis-one-ser

2.Enter project:
running-information-analysis-one-service

3.Run mysql on docker: 
in terminal, run : docker-compose up -d

or directly run mysql:
mysql --host=127.0.0.1 --port=3306 --user=root --password=root

4.Generate fatjar file:
mvn clean install

5.Enter target folder:
target

6.Run fatjar file:
java -jar running-information-analysis-one-service-1.0.0.BUILD-SNAPSHOT.jar

As the project is running, open postman:
do the following:
