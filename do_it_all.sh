#!/bin/sh

cd Parking-Lot
mvn clean install
cp target/Parking-Lot.jar ../

echo "*************************************************************"
echo " Application Build and test was succesful."
echo "*************************************************************"
echo "                                                             "
cd ..
echo "                                                             "
echo "*************************************************************"
echo " Running Parking Lot application now..."
echo "*************************************************************"

if [ "$#" -eq 1 ] 
then
   echo "Argument detected, Running Parking lot in File Interpreter mode..."
   java -jar Parking-Lot.jar "$1"
else 
   echo "No arguments detected, Running Parking lot in Interactive mode..."
   java -jar Parking-Lot.jar
fi
