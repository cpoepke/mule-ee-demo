echo Building Mule EE demo

cd ./common/mule-ee-bom
mvn clean install

cd ../mule-ee-license
mvn clean install

cd ../mule-ee-parent
mvn clean install

cd ../../
mvn clean install

exit