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

upload RunningInfo
![image](https://github.com/wanglt311/RunningApp/blob/master/images/uploadrunninginfo.png)

Display RunningInfo with sorted healthWarningLevel, every page for 2
![image](https://github.com/wanglt311/RunningApp/blob/master/images/displayrunninginfowithsortedhealthlevel.png)
![image](https://github.com/wanglt311/RunningApp/blob/master/images/healthlevel2.png)

Example of do not enter size value, use default size = "2"
![image](https://github.com/wanglt311/RunningApp/blob/master/images/healthleveldefaultsizeis2.png)

Delete by runningId
![image](https://github.com/wanglt311/RunningApp/blob/master/images/deletebyrunningid.png)

The problem I met with 500 error is because:
spring.jpa.hibernate.ddl-auto=upate
So the "id" field is no default value.
Then I change this into:
spring.jpa.hibernate.ddl-auto=create, everything is fine.
